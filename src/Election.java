
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/*
Κλάση της οποίας τα στιγμιότυπα αναπαριστούν μία ψηφοφορία με n ψηφοφόρους
και m υποψήφιους, για την επιλογή μία k-μελούς επιτροπής.
*/
public class Election {
    private PreferenceProfile profile;
    private ArrayList<Candidate> candidates;
    private ArrayList<Voter> voters;
    private int k;
    private int m;
    private int n;

    /*
    Constructor της κλάσης, παίρνει ως ορίσματα τους πίνακες των ψηφοφόρων
    και των υποψήφιων και το μέγεθος της επιτροπής k. Θέτει αυτόματα τις
    σταθερές m και n, ελέγχει αν οι υποψήφιοι είναι αρκετοί για να
    στελεχώσουν την επιτροπή, και δημιουργεί το προφίλ προτιμήσεων των
    ψηφοφόρων.
    */
    public Election(int k, ArrayList<Voter> voters,
            ArrayList<Candidate> candidates){
        this.candidates = candidates;
        this.voters = voters;
        m = candidates.size();
        n = voters.size();
        if(k < m){
            this.k = k;
        }
        else {
            this.k = m;
        }
        profile = new PreferenceProfile(voters, candidates);
    }
    
    //Getters & Setters των διαφόρων πεδίων της κλάσης.
    public PreferenceProfile getPreferenceProfile(){
        return profile;
    }
    
    public int getCommitteeSize(){
        return k;
    }
    
    public void setCommitteeSize(int k){
        this.k = k;
    }
    
    public int getNumberOfCandidates(){
        return m;
    }
    
    public int getNumberOfVoters(){
        return n;
    }
    
    public ArrayList<Candidate> getCandidates(){
        return candidates;
    }
    
    public ArrayList<Voter> getVoters(){
        return voters;
    }
    
    /*
    Μέθοδος που υπολογίζει τη βαθμολογία σχετικής πλειοψηφίας ενός
    υποψήφιου
    */
    public void calcPluralityScore(Candidate c){
        int score = 0;
        for(Voter v: voters){
            if (v.getFirstPreference().getCandidate().equals(c));
            score = score + 1;
        }
        c.setPluralityScore(score);
    }
    
    /*
    Μέθοδος που υπολογίζει τη βαθμολογία σχετ. πλειοψηφείας όλων των
    υποψήφιων. Τρέχει σε γραμμικό χρόνο ως προς το πλήθος των ψηφοφόρων
    χρησιμοποιώντας τα pointers που διατηρούνται σε κάθε ψηφοφόρο προς
    την πρώτη τους προτίμηση. "Γλιτώνει" χρόνο σε σύγκριση με τη
    μεμονωμένη κλήση της προηγούμενης μεθόδου για κάθε υποψήφιο, που έχει
    πολυπλοκότητα m*n.
    */
    public void calcPluralityAll(){
        for (Voter v: voters) {
            v.getFirstPreference().getCandidate().increasePluralityByOne();
        }
    }
    
    /*
    Στατική μέθοδος σύγκρισης υποψήφιων με βάση τη βαθμολογία σχετικής
    πλειοψηφίας. Κατασκευασμένη ώστε στην ταξινόμηση να επιστρέφονται οι
    υποψήφιοι με φθίνουσα σειρά προτίμησης.
    */
    public static Comparator<Candidate> PluralityComparator
            = new Comparator<Candidate>(){

        @Override
        public int compare(Candidate c1, Candidate c2) {
            return c2.getPluralityScore()-c1.getPluralityScore();
        }
        
    };
   
    //Μέθοδος που υπολογίζει τη βαθμολογία Borda ενός υποψήφιου
    public void calcBordaScore(Candidate c){
        int score = 0;
        int col = c.getProfileIndex();
        for(Voter v: voters){
            int row = v.getProfileIndex();
            score = score + profile.getItem(row,col).calcBorda(m);
        }
        c.setBordaScore(score);
    }
    
    /*
    Overload της μεθόδου calcBordaScore, για υπολογισμό βαθμολογίας
    υποψήφιου από υποσύνολο των ψηφοφόρων.
    */
    public void calcBordaScore(ArrayList<Voter> voterSubset, Candidate c){
        int score = 0;
        int col = c.getProfileIndex();
        for(Voter v: voterSubset){
            int row = v.getProfileIndex();
            score = score + profile.getItem(row,col).calcBorda(m);
        }
        c.setBordaScore(score);
    }
    
    /*
    Στατική μέθοδος σύγκρισης υποψήφιων με βάση τη βαθμολογία Borda.
    Κατασκευασμένη ώστε στην ταξινόμηση να επιστρέφονται οι υποψήφιοι με
    φθίνουσα σειρά προτίμησης.
    */
    public static Comparator<Candidate> BordaComparator
            = new Comparator<Candidate>(){

        @Override
        public int compare(Candidate c1, Candidate c2) {
            return c2.getBordaScore()-c1.getBordaScore();
        }
        
    };
    
    /*
    Μέθοδος που υπολογίζει τη συνολική βαθμολογία k-Approval ενός
    υποψήφιου.
    */
    public void calcBlocScore(Candidate c){
        int score = 0;
        int col = c.getProfileIndex();
        for(Voter v: voters){
            int row = v.getProfileIndex();
            score = score + profile.getItem(n,m).calcBloc(k);
        }
        c.setBlocScore(score);
    }
    
    /*
    Μέθοδος που υπολογίζει τις βαθμολογίες k-Approval όλων των υποψήφιων.
    Τρέχει σε χρόνο n*k, ένω η επαναλαμβανόμενη κλήση της προηγούμενης
    μεθόδου χρειάζεται να διαπεράσει ολόκληρο τον πίνακα του προφίλ
    προτιμήσεων, δηλαδή χρειάζεται χρόνο της τάξης n*m.
    */
    public void calcBlocAll(){
        for (Voter v: voters) {
            PreferenceItem currentPI = v.getFirstPreference();
            for (int i = 0; i < k; i++){
                currentPI.getCandidate().increaseBlocByOne();
                currentPI = currentPI.getNext();
            }
        }
    }
    
    /*
    Στατική μέθοδος σύγκρισης υποψήφιων με βάση τη βαθμολογία Bloc.
    Κατασκευασμένη ώστε στην ταξινόμηση να επιστρέφονται οι υποψήφιοι με
    φθίνουσα σειρά προτίμησης.
    */
    public static Comparator<Candidate> BlocComparator
            = new Comparator<Candidate>(){

        @Override
        public int compare(Candidate c1, Candidate c2) {
            return c2.getBlocScore()-c1.getBlocScore();
        }
        
    };

    
    /*
    Μέθοδος επιλογής μίας k-μελούς επιτροπής με βάση τον κανόνα SNTV.
    Αναδιατάσσεται τυχαία ο πίνακας των υποψήφιων κι υπολογίζονται οι
    βαθμολογίες σχετικής πλειοψηφίας. Ταξινομείται ο πίνακας βάσει των
    βαθμολογιών αυτών, κι επιλέγονται οι k πρώτοι. (Κανόνας Best-k)
    */
    public ArrayList<Candidate> singleNonTrasferableVote (){
        ArrayList<Candidate> committee = new ArrayList<Candidate>(k);
        Collections.shuffle(candidates);
        calcPluralityAll();
        Collections.sort(candidates, PluralityComparator);
       
        for (int i = 0; i < k; i++){
            committee.add(candidates.get(i));
        }
        
        return committee;
    }
    
    /*
    Μέθοδος επιλογής μίας k-μελούς επιτροπής με βάση τον κανόνα k-Borda.
    Αναδιατάσσεται τυχαία ο πίνακας των υποψήφιων κι υπολογίζονται οι
    βαθμολογίες Borda όλων των υποψήφιων. Ταξινομείται ο πίνακας βάσει των
    βαθμολογιών αυτών, κι επιλέγονται οι k πρώτοι. (Κανόνας Best-k)
    */
    public ArrayList<Candidate> kBorda (){
        ArrayList<Candidate> committee = new ArrayList<Candidate>(k);
        Collections.shuffle(candidates);
        for (Candidate c: candidates){
            calcBordaScore(c);
        }
        Collections.sort(candidates, BordaComparator);
       
        for (int i = 0; i < k; i++){
            committee.add(candidates.get(i));
        }
        
        return committee;
    }
    
    /*
    Μέθοδος επιλογής μίας k-μελούς επιτροπής με βάση τον κανόνα Bloc.
    Αναδιατάσσεται τυχαία ο πίνακας των υποψήφιων κι υπολογίζονται οι
    βαθμολογίες k-Approval όλων των υποψήφιων. Ταξινομείται ο πίνακας βάσει
    των βαθμολογιών αυτών, κι επιλέγονται οι k πρώτοι. (Κανόνας Best-k)
    */
    public ArrayList<Candidate> bloc (){
        ArrayList<Candidate> committee = new ArrayList<Candidate>(k);
        Collections.shuffle(candidates);
        calcBlocAll();
        Collections.sort(candidates, BlocComparator);
       
        for (int i = 0; i < k; i++){
            committee.add(candidates.get(i));
        }
        
        return committee;
    }
    
    /*
    Μέθοδος που υλοποιεί τον κανόνα επιλογής επιτροπών STV.
    */
    public ArrayList<Candidate> singleTransferableVote(){
        ArrayList<Candidate> committee = new ArrayList(k);
        calcPluralityAll();
        int droopQuota = n /(k + 1) + 1;
////        <Print_Test_Code>
//        System.out.println("Droop Quota = " + droopQuota + "\n");
////        </Print_Test_Code>
        
        /*
        Κρατάμε αντίγραφα των πινάκων των ψηφοφόρων και των υποψήφιων
        για να υπάρχει η δυνατότητα επαναφοράς τους στην αρχική κατάσταση
        */
        ArrayList<Voter> stvVoters = new ArrayList(n);
        for (Voter v: voters) {
            stvVoters.add(new Voter(v));
        }
        ArrayList<Candidate> stvCandidates = new ArrayList(m);
        for (Candidate c: candidates) {
            stvCandidates.add(new Candidate(c));
        }
                   
        Collections.shuffle(candidates);
        Collections.shuffle(voters);
        
        while (committee.size() < k){

            /*
            Αν οι υποψήφιοι που απομένουν είναι όσοι λείπουν από την
            επιτροπή, τότε προστίθενται όλοι σε αυτήν.
            */
            if (candidates.size() == (k - committee.size())){
                committee.addAll(candidates);
////                <Print_Test_Code>
//                System.out.println("Number of candidates left is equal"
//                        + " to number of committee members missing. "
//                        + "Winning committee includes all of them.");
////                </Print_Test_Code>
            }
            else{
////                <Print_Test_Code>
//                for(Voter v : voters){
//                    int i = v.getProfileIndex();
//                    System.out.print(v.getName() + "'s Preference: ");
//                    for(Candidate c: candidates){
//                        int j = c.getProfileIndex();
//                        System.out.print(c.getName() + "("
//                                + profile.getItem(i, j).getPosition() + ") ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                for (Candidate candidate: candidates){
//                    System.out.println(candidate.getName()
//                            + "'s Plurality Score is: "
//                            + candidate.getPluralityScore());
//                }   
//                System.out.println();
////                </Print_Test_Code>

                //Βρίσκεται ο υποψήφιος με τη μέγιστη βαθμολογία
                int maxScore = 0;
                Candidate chosenCandidate = null;
                for (Candidate c: candidates) {
                    if (c.getPluralityScore() > maxScore){
                        maxScore = c.getPluralityScore();
                        chosenCandidate = c;
                    }
                }

                //Αν είναι μεγαλύτερη του ορίου Droop, προστίθεται στην
                //επιτροπή
                if(maxScore >= droopQuota){
                    committee.add(chosenCandidate);
////                    <Print_Test_Code>
//                    System.out.println("Candidate "
//                            + chosenCandidate.getName() + " added\n");
////                    </Print_Test_Code>

                    /*
                    Loop αφαίρεσης ψηφοφόρων ίσων σε πλήθος με το όριο
                    εισόδου, που έχουν ως πρώτη προτίμηση τον επιλεγμένο
                    υποψήφιο.
                    */
                    int counter = 0;
                    ListIterator<Voter> it = voters.listIterator();
                    while (it.hasNext()){
                        Voter v = it.next();
                        if (v.getFirstPreference().getCandidate().
                                equals(chosenCandidate)){
                            it.remove();
////                            <Print_Test_Code>
//                            System.out.println(v.getName() + " removed");
////                            </Print_Test_Code>
                            counter++;
                            if (counter == droopQuota){
                                break;
                            }
                        }
                    }
                }
                
                /*
                Αν ο υποψήφιος με τη μεγαλύτερη βαθμολογία δεν ξεπερνά το
                όριο εισόδου, τότε βρίσκεται ο υποψήφιος με τη μικρότερη
                βαθμολογία και διαγράφεται.
                */
                else{
                    int minScore = n;
                    for (Candidate c: candidates) {
                        if (c.getPluralityScore() < minScore){
                            minScore = c.getPluralityScore();
                            chosenCandidate = c;
                        }
                    }
////                    <Print_Test_Code>
//                    System.out.println("Candidate "
//                            + chosenCandidate.getName() + " deleted\n");
////                    </Print_Test_Code>
                }
                
                candidates.remove(chosenCandidate);

                /*
                Χρησιμοποιώντας τη διπλά συνδεδεμένη λίστα της προτίμησης
                κάθε ψηφοφόρου, αφαιρείται από την "αλυσίδα" ο επιλεγμένος
                υποψήφιος. Παράλληλα προσαρμόζεται κι η βαθμολογία, όπου
                χρειάζεται.
                */
                for (Voter v: voters) {
                    int row = v.getProfileIndex();
                    int col = chosenCandidate.getProfileIndex();
                    PreferenceItem current = profile.getItem(row, col);
                    if (current.getPosition() == 1 &&
                            current.getNext() != null){
                        current.getNext().setPosition(1);
                        current.getNext().getCandidate()
                                .increasePluralityByOne();
                        v.setFirstPreference(current.getNext());
                    }
                    if (current.getPrevious() != null){
                        current.getPrevious().setNext(current.getNext());
                    }
                    if (current.getNext() != null){
                        current.getNext()
                                .setPrevious(current.getPrevious());
                    }
                }
            }
        }
        //Επαναφέρονται οι πίνακες στην αρχική τους κατάσταση
        voters = stvVoters;
        candidates = stvCandidates;
        profile = new PreferenceProfile(voters, candidates);
        return committee;
    }
    
    /*
    Μέθοδος που βρίσκει μέσα από ένα σύνολο υποψήφιων, τον υποψήφιο εκείνο
    που είναι πιο ψηλά στην προτίμηση ενός ψηφοφόρου. Χρησιμοποιείται στην 
    συνάρτηση ικανοποίησης για τον κανόνα CC, αλλά και στη μέθοδο kMeans.
    */
    public Candidate findPreferredCandidate(Voter v,
            ArrayList<Candidate> committee){
        int i = v.getProfileIndex();
        int position = m + 1;
        Candidate preferredCandidate = null;
        for (Candidate c: committee){
            int j = c.getProfileIndex();
            if (profile.getItem(i,j).getPosition() < position){
                preferredCandidate = c;
                position = profile.getItem(i,j).getPosition();
            }
        }
        return preferredCandidate;
    }  
    
    /*
    Μέθοδος που υπολογίζει τη συνολική ικανοποίηση ενός συνόλου ψηφοφόρων
    για μία επιτροπή. ΥΚάθε ψηφοφόρος αντλεί ικανοποίηση μόνο από τον
    υποψήφιο της επιτροπής που βρίσκεται πιο ψηλά στην προτίμησή του, και
    είναι ίση με τη βαθμολογία Borda.
    */
    public int bordaSatisfaction(ArrayList<Candidate> committee,
            ArrayList<Voter> voters){
        int satScore = 0;
        for (Voter v: voters){
            Candidate preferredCandidate
                    = findPreferredCandidate(v, committee);
            int row = v.getProfileIndex();
            int col = preferredCandidate.getProfileIndex();
            satScore = satScore + profile.getItem(row, col).calcBorda(m);
        }
        return satScore;
    }
    
    
    /*
    Μέθοδος που υλοποιεί τον άπληστο προσεγγιστικό αλγόριθμο του κανόνα
    Chamberlin-Courant. Τρέχει σε χρόνο της τάξης m*n*k^2.
    */
    public ArrayList<Candidate> greedyCC(){
        //Αντιγράφεται η λίστα των υποψήφιων για να μην αλλοιωθεί η αρχική
        ArrayList<Candidate> ccCandidates = new ArrayList(m);
        for (Candidate c: candidates){
            ccCandidates.add(new Candidate(c));
        }
        
        ArrayList<Candidate> committee = new ArrayList(k);
        int maxSatisfaction = 0;
        Collections.shuffle(ccCandidates);

////        <Print_Test_Code>
//        for(Voter v: voters){
//            System.out.print(v.getName() + "'s Preference: ");
//            PreferenceItem pi = v.getFirstPreference();
//            while (pi.getNext() != null) {
//                System.out.print(pi.getCandidate().getName() + " ");
//                pi = pi.getNext();
//            }
//            System.out.println();
//        }
//        System.out.println();
//        int iteration = 1;
////        </Print_Test_Code>
        
        //Βρόχος κατασκευής της επιτροπής - k επαναλήψεις max
        while (committee.size() < k){
            
////            <Print_Test_Code>
//            System.out.println("-------------\nΕπανάληψη #"
//                    + iteration + "\n");
//            iteration++;
////            </Print_Test_Code>
            
            Candidate nextMember = null;
            
            //Επιλέγεται ο υποψήφιος που μεγιστοποιεί την ικανοποίηση
            for (int i=0; i<ccCandidates.size(); i++){
                committee.add(ccCandidates.get(i));
                int s = bordaSatisfaction(committee, voters);
                
////                <Print_Test_Code>
//                System.out.println("Με την προσθήκη του υποψήφιου "
//                        + ccCandidates.get(i).getName()
//                        + " , η συνολική ικανοποίηση γίνεται ίση με: "
//                        + s);
////                </Print_Test_Code>
                
                if (s > maxSatisfaction){
                    maxSatisfaction = s;
                    nextMember = ccCandidates.get(i);
                }
                committee.remove(ccCandidates.get(i));
            }
            
            if (nextMember != null){
                committee.add(nextMember);
                ccCandidates.remove(nextMember);
                
////                <Print_Test_Code>
//                System.out.println("\nΕπιλέγεται ο υποψήφιος "
//                        + nextMember.getName() + "\n\n");
////                </Print_Test_Code>
            }
            
            /*
            Αν δεν γίνεται να βελτιωθεί η ικανοποίηση, κι η επιτροπή δεν
            έχει συμπληρωθεί ακόμα, συμπληρώνεται με τυχαίο τρόπο.
            */
            else {
////                </Print_Test_Code>
//                System.out.print("\nΗ ικανοποίηση δεν βελτιώνεται άλλο, "
//                        + "επιλέγονται τυχαία οι υποψήφιοι: ");
////                </Print_Test_Code>

                int missing = k - committee.size();
                for (int j = 0; j < missing; j++){
                    committee.add(ccCandidates.get(j));
////                    <Print_Test_Code>
//                    System.out.print(ccCandidates.get(j).getName() + " ");
////                    </Print_Test_Code>
                }
            }
        }
        
        return committee;
    }
    
  
    /*
    Μέθοδος που υλοποιεί τον άπληστο προσεγγιστικό αλγόριθμο για τον κανόνα
    Monroe.
    */
    public ArrayList<Candidate> greedyMonroe(){
        /*
        Κρατούνται αντίγραφα των πινάκων των ψηφοφόρων και των υποψήφιων,
        επειδή θα γίνουν διαγραφές κατά την εκτέλεση της μεθόδου.
        */
        ArrayList<Voter> mVoters = new ArrayList(n);
        ArrayList<Candidate> mCandidates = new ArrayList(m);
        for (Voter v: voters){
            mVoters.add(new Voter(v));
        }
        for (Candidate c: candidates){
            mCandidates.add(new Candidate(c));
        }
        
        /*
        Aρχικοποιούνται η ζητούμενη επιτροπή, ο πίνακας που διατηρεί τα
        υποσύνολα των ψηφοφόρων που αντιστοιχούν σε κάθε εκλεγμένο μέλος
        της επιτροπής, καθώς και διάφορες βοηθητικές μεταβλητές/πίνακες.
        Υπολογίζεται το πλήθος των υποψήφιων που θα εκπροσωπούν έναν
        επιπλέον ψηφοφόρο(y).
        */
        ArrayList<Candidate> committee = new ArrayList(k);
        ArrayList<List<Voter>> voterSubsets = new ArrayList();
        ArrayList<Voter> voterSubset = new ArrayList();
        ArrayList<Voter> tempVoterSubset = new ArrayList();
        int y = n%k;
        int subsetSize = n/k;
////        <Print_Test_Code>
//        System.out.println("Κάθε μέλος της επιτροπής(k=" + k + ") θα "
//                + "αντιπροσωπεύει " + subsetSize + " ψηφοφόρους, εκτός "
//                + "από τα πρώτα " + y + " μέλη που αντιπροσωπεύουν "
//                + (subsetSize+1));
//        int iteration = 1;
////        </Print_Test_Code>        
        
        //"Τυχαιοποιούνται" οι πίνακες των υποψήφιων και των ψηφοφόρων.
        Collections.shuffle(candidates);
        Collections.shuffle(voters);

        /*
        Βασικός βρόχος κατασκευής της επιτροπής. Σε κάθε επανάληψη
        βρίσκεται το ζεύγος του υποψήφιου και του υποσυνόλου των ψηφοφόρων
        που μεγιστοποιεί την ικανοποίηση, και προστίθεται ο υποψήφιος αυτός
        στην επιτροπή.
        */
        while (committee.size() < k){
////        <Print_Test_Code>
//            System.out.println("-------------\nΕπανάληψη #"
//                    + iteration + "\n");
//            System.out.print("Η επιτροπή έχει διαμορφωθεί ως εξής: ");
//            for (Candidate c : committee){
//                System.out.print(c.getName() + " ");
//            }
//            System.out.println("\n");
//            for(Voter v : voters){
//                int i = v.getRowIndex();
//                System.out.print(v.getName() + "'s Preference: ");
//                for(Candidate c: candidates){
//                    int j = c.getColIndex();
//                    System.out.print(c.getName() + "("
//                            + profile[i][j].getPosition() + ") ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            iteration++;
////            </Print_Test_Code>
          
            int maxSatisfaction = 0;
            Candidate nextMember = null;
            for (int i=0; i < candidates.size(); i++){
                Candidate c = candidates.get(i);
                /*
                Για κάθε υποψήφιο, ταξινομείται η στήλη του πίνακα
                προτίμησης που αντιστοιχεί σε αυτόν με βάση τη θέση του
                (σε φθίνουσα σειρά).
                */
                List<PreferenceItem> piList = new ArrayList(voters.size());
                for (int j = 0; j < voters.size(); j++){
                    Voter v = voters.get(j);
                    piList.add(profile.getItem(v.getProfileIndex(),
                            c.getProfileIndex()));
                }
                Collections.sort(piList, PreferenceItem.PiComparator);
                
                /*
                Με τη βοήθεια της ταξινομημένης στήλης, επιλέγεται ο
                κατάλληλος αριθμός των ψηφοφόρων κι υπολογίζεται η
                ικανοποίησή τους.
                */
                int s = 0;
                if (committee.size() < y){
                    subsetSize = n/k + 1;
                }
                else {
                    subsetSize = n/k;
                }
                for (int j = 0; j < subsetSize; j++){
                    s = s + piList.get(j).calcBorda(m);
                    tempVoterSubset.add(piList.get(j).getVoter());
                }
                piList.clear();
////                <Print_Test_Code>
//                System.out.println("Αν στην επιτροπή προστεθεί ο "
//                        + "υποψήφιος " + c.getName() 
//                        + " η ικανοποίηση θα αυξηθεί κατά " + s);
////                </Print_Test_Code>
                
                /*
                Κάθε φορά που αυξάνει η ικανοποίηση, αποθηκεύεται η νέα
                μέγιστη τιμή της, ο υποψήφιος αλλά και το υποσύνολο των
                ψηφοφόρων. Κατόπιν αδειάζει το προσωρινό υποσύνολο των
                ψηφοφόρων, για να γίνει η δοκιμή του επόμενου ζεύγους.
                */
                if (s > maxSatisfaction){
                    maxSatisfaction = s;
                    nextMember = c;
                    voterSubset = new ArrayList<>(tempVoterSubset);
                }
                tempVoterSubset.clear();
            }
////            <Print_Test_Code>
//            System.out.println("\nΠροστίθεται στην επιτροπή ο υποψήφιος "
//                    + nextMember.getName() + "\n");
////            </Print_Test_Code>
            
            /*
            Βγαίνοντας από τον εσωτερικό βρόχο, έχει γίνει η τελική επιλογή
            του μέλους της επιτροπής, το οποίο και διαγράφεται από τον
            πίνακα των υποψήφιων. Διαγράφεται επίσης το υποσύνολο των
            ψηφοφόρων, οι οποίοι πλέον εκπροσωπούνται από το συγκεκριμένο
            μέλος και προστίθεται στον πίνακα που διατηρεί τη συγκεκριμένη
            πληροφορία.
            */
            voterSubsets.add(voterSubset);
            for (Voter v : voterSubset){
                voters.remove(v);
            }
            committee.add(nextMember);
            candidates.remove(nextMember);
        }
        
        /*
        Επαναφέρονται οι πίνακες των ψηφοφόρων και των υποψήφιων στην
        αρχική τους κατάσταση κι επιστρέφεται η νικήτρια επιτροπή.
        */
        voters = mVoters;
        candidates = mCandidates;
        return committee;
    }
    
    /*
    Μέθοδος που υλοποιεί τον αλγόριθμο ομαδοποίησης (clustering) ή k-means.
    Επιλέγονται τυχαία k υποψήφιοι, και ομαδοποιούνται οι ψηφοφόροι σε k
    συστάδες, σε κάθε μία από τις οποίες συνυπάρχουν οι ψηφοφόροι εκείνοι
    που προτιμούν το ίδιο μέλος της τυχαία επιλεγμένης επιτροπής.
    Επαναληπτικά, υπολογίζεται για κάθε συστάδα ο υποψήφιος που προτιμάται
    (από το σύνολο των υποψήφιων) και με βάση την νέα k-άδα υποψήφιων που
    προκύπτει επαναυπολογίζονται οι συστάδες κ.ο.κ
    */
    public ArrayList<Candidate> kMeans(){
        int iterations = 0;
        ArrayList<Candidate> committee = new ArrayList(k);
        ArrayList<ArrayList<Voter>> clusters = new ArrayList(k);
        for (int i = 0; i < k; i++){
            ArrayList<Voter> voterSubset = new ArrayList();
            clusters.add(voterSubset);
        }
        
        Collections.shuffle(candidates);
        for(int i = 0; i < k; i++){
            committee.add(candidates.get(i));
            committee.get(i).setkMeansIndex(i);
        }
        
        //
        while(iterations < 30){
            boolean stop = true;
            iterations++;
            
            for (Voter v: voters){
                Candidate c = findPreferredCandidate(v, committee);
                clusters.get(c.getkMeansIndex()).add(v);
            }

            for (int i = 0; i < k; i++){
                int bestScore = -1;
                Candidate representative = null;
                for (Candidate c: candidates){
                    calcBordaScore(clusters.get(i), c);
                    if (c.getBordaScore() > bestScore &&
                            c.getSelected() == false){
                        representative = c;
                        bestScore = c.getBordaScore();
                    }
                }
                if (!representative.equals(committee.get(i))){
                    stop = false;
                }
                representative.setkMeansIndex(i);
                representative.setSelected(true);
                committee.set(i, representative);
            }
            
            if(stop){
                break;
            }
            
            for (Candidate c: committee){
                c.setSelected(false);
            }
        }
        return committee;
    }
}