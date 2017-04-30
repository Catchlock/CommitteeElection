
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/*
 * The MIT License
 *
 * Copyright 2017 Nikolas Laskaris.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author Nikolas Laskaris
 */

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
    private boolean election2D;

    /*
    Constructor της κλάσης, παίρνει ως ορίσματα τους πίνακες των ψηφοφόρων
    και των υποψήφιων και το μέγεθος της επιτροπής k. Θέτει αυτόματα τις
    σταθερές m και n, ελέγχει αν οι υποψήφιοι είναι αρκετοί για να
    στελεχώσουν την επιτροπή, και δημιουργεί το προφίλ προτιμήσεων των
    ψηφοφόρων.
    */
    public Election(int k, ArrayList<Voter> voters,
            ArrayList<Candidate> candidates, boolean election2D){
        this.candidates = candidates;
        this.voters = voters;
        this.election2D = election2D;
        m = candidates.size();
        n = voters.size();
        if(k < m){
            this.k = k;
        }
        else {
            this.k = m;
        }
        profile = new PreferenceProfile(voters, candidates, election2D);
    }
    
    //Getters & Setters των διαφόρων πεδίων της κλάσης.
    public PreferenceProfile getProfile() {
        return profile;
    }

    public void setProfile(PreferenceProfile profile) {
        this.profile = profile;
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
    
    public boolean isElection2D() {
        return election2D;
    }

    public void setElection2D(boolean election2D) {
        this.election2D = election2D;
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
        for(Candidate c: candidates){
            c.setPluralityScore(0);
        }
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
//    public void calcBlocScore(Candidate c){
//        int score = 0;
//        int col = c.getProfileIndex();
//        for(Voter v: voters){
//            int row = v.getProfileIndex();
//            score = score + profile.getItem(n,m).calcBloc(k);
//        }
//        c.setBlocScore(score);
//    }
    
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
    public static Comparator<Candidate> IndexComparator
            = new Comparator<Candidate>(){

        @Override
        public int compare(Candidate c1, Candidate c2) {
            int number1 = c1.getProfileIndex();
            int number2 = c2.getProfileIndex();
            return number1 - number2;
        }
        
    };

    public void clearCandidates(){
        for(Candidate c: candidates){
            c.clear();
        }
    }
    
    public void clearVoters(){
        for(Voter v: voters){
            v.clear();
        }
    }
    
    /*
    Μέθοδος επιλογής μίας k-μελούς επιτροπής με βάση τον κανόνα SNTV.
    Αναδιατάσσεται τυχαία ο πίνακας των υποψήφιων κι υπολογίζονται οι
    βαθμολογίες σχετικής πλειοψηφίας. Ταξινομείται ο πίνακας βάσει των
    βαθμολογιών αυτών, κι επιλέγονται οι k πρώτοι. (Κανόνας Best-k)
    */
    public ArrayList<Candidate> singleNonTransferableVote (){
        clearCandidates();
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
        clearCandidates();
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
        clearCandidates();
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
        clearCandidates();
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
        
        PreferenceProfile backupProfile = profile;
        profile = new PreferenceProfile(stvVoters, stvCandidates, election2D);
        
        
        ArrayList<Candidate> committee = new ArrayList(k);
        calcPluralityAll();
        int droopQuota = n /(k + 1) + 1;
////        <Print_Test_Code>
//        System.out.println("Droop Quota = " + droopQuota + "\n");
////        </Print_Test_Code>
                
        Collections.shuffle(stvCandidates);
        Collections.shuffle(stvVoters);
        
        while (committee.size() < k){

            /*
            Αν οι υποψήφιοι που απομένουν είναι όσοι λείπουν από την
            επιτροπή, τότε προστίθενται όλοι σε αυτήν.
            */
            if (stvCandidates.size() == (k - committee.size())){
                committee.addAll(stvCandidates);
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
                for (Candidate c: stvCandidates) {
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
                    ListIterator<Voter> it = stvVoters.listIterator();
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
                    for (Candidate c: stvCandidates) {
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
                
                stvCandidates.remove(chosenCandidate);

                /*
                Χρησιμοποιώντας τη διπλά συνδεδεμένη λίστα της προτίμησης
                κάθε ψηφοφόρου, αφαιρείται από την "αλυσίδα" ο επιλεγμένος
                υποψήφιος. Παράλληλα προσαρμόζεται κι η βαθμολογία, όπου
                χρειάζεται.
                */
                for (Voter v: stvVoters) {
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
        
        profile = backupProfile;
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
    public int bordaSatisfaction(ArrayList<Candidate> committee){
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
    
    public double[] getDistanceVector(ArrayList<Candidate> committee){
        double[] distanceVector = new double[n];
        for(int i = 0; i < n; i++){
            Candidate c = findPreferredCandidate(voters.get(i),committee);
            distanceVector[i] = voters.get(i).distance(c);
        }
        
        return distanceVector;
    }
    
    /*
    Μέθοδος που υλοποιεί τον άπληστο προσεγγιστικό αλγόριθμο του κανόνα
    Chamberlin-Courant. Τρέχει σε χρόνο της τάξης m*n*k^2.
    */
    public ArrayList<Candidate> greedyCC(){
        clearCandidates();
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
                int s = bordaSatisfaction(committee);
                
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
        clearCandidates();
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
        
        
        PreferenceProfile backupProfile = profile;
        profile = new PreferenceProfile(mVoters, mCandidates, election2D);
        
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
        Collections.shuffle(mCandidates);
        Collections.shuffle(mVoters);

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
            for (int i=0; i < mCandidates.size(); i++){
                Candidate c = mCandidates.get(i);
                /*
                Για κάθε υποψήφιο, ταξινομείται η στήλη του πίνακα
                προτίμησης που αντιστοιχεί σε αυτόν με βάση τη θέση του
                (σε φθίνουσα σειρά).
                */
                List<PreferenceItem> piList = new ArrayList(mVoters.size());
                for (int j = 0; j < mVoters.size(); j++){
                    Voter v = mVoters.get(j);
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
                mVoters.remove(v);
            }
            if(nextMember != null){
                committee.add(nextMember);
                mCandidates.remove(nextMember);
            }
            else{
                int remaining = k - committee.size();
                Collections.shuffle(mCandidates);
                for(int i = 0; i < remaining; i++){
                    committee.add(mCandidates.get(i));
                }
            }
        }
        
        /*
        Επαναφέρονται οι πίνακες των ψηφοφόρων και των υποψήφιων στην
        αρχική τους κατάσταση κι επιστρέφεται η νικήτρια επιτροπή.
        */
        profile = backupProfile;
        return committee;
    }
    
    /*
    Μέθοδος που υλοποιεί τον αλγόριθμο ομαδοποίησης (clustering) ή k-means.
    Επιλέγονται αρχικά k υποψήφιοι, και ομαδοποιούνται οι ψηφοφόροι σε k
    συστάδες, σε κάθε μία από τις οποίες συνυπάρχουν οι ψηφοφόροι εκείνοι
    που προτιμούν το ίδιο μέλος της τυχαία επιλεγμένης επιτροπής.
    Επαναληπτικά, υπολογίζεται για κάθε συστάδα ο υποψήφιος που προτιμάται
    (από το σύνολο των υποψήφιων) και με βάση την νέα k-άδα υποψήφιων που
    προκύπτει επαναυπολογίζονται οι συστάδες κ.ο.κ
    */
    public ArrayList<Candidate> kMeans(){
        clearCandidates();
        int iterations = 0;
        ArrayList<Candidate> committee = new ArrayList(k);
        ArrayList<ArrayList<Voter>> voterClusters = new ArrayList(k);
        
        committee = initializekMeansCommittee();
        
        for(int i = 0; i < k; i++){
            committee.get(i).setkMeansIndex(i);
        }
        
        while(iterations < 50){
            boolean end = true;
            iterations++;
            
            for (int i = 0; i < k; i++){
                ArrayList<Voter> voterSubset = new ArrayList();
                voterClusters.add(voterSubset);
            }
            
            for (Voter v: voters){
                Candidate c = findPreferredCandidate(v, committee);
                voterClusters.get(c.getkMeansIndex()).add(v);
            }

            for(Candidate c: candidates){
                c.setSelected(false);
            }
            Collections.shuffle(candidates);
            
            for (int i = 0; i < k; i++){
                int bestScore = -1;
                Candidate representative = null;
                for (Candidate c: candidates){
                    calcBordaScore(voterClusters.get(i), c);
                    if (c.getBordaScore() > bestScore &&
                            c.getSelected() == false){
                        representative = c;
                        bestScore = c.getBordaScore();
                    }
                }
                if (!representative.equals(committee.get(i))){
                    end = false;
                    representative.setkMeansIndex(i);
                    representative.setSelected(true);
                    committee.set(i, representative);
                }
            }
            if(end){
                break;
            }
        }
        return committee;
    }
    
    //Αρχικοποίηση επιτροπής για τον αλγόριθμο k-means
    public ArrayList<Candidate> initializekMeansCommittee(){
        ArrayList<Candidate> committee = new ArrayList(k);
        ArrayList<Voter> voterCommittee = new ArrayList(k);
        
        ArrayList<Voter> kmVoters = new ArrayList(n);
        for (Voter v: voters){
            kmVoters.add(new Voter(v));
        }
        
        Random r = new Random();
        int firstMemberIndex = r.nextInt(n);
        voterCommittee.add(kmVoters.get(firstMemberIndex));
        kmVoters.remove(firstMemberIndex);
        
        while(voterCommittee.size() < k){
            double total = 0;
            for(Voter v: kmVoters){
                v.setKmDistance(0);
            }
            for(Voter v1: kmVoters){
                for(Voter v2: voterCommittee){
                    v1.setKmDistance(v1.getKmDistance()+v1.distance(v2));
                    total += v1.distance(v2);
                }
            }
            
            double bridgeValue = 0;
            for(Voter v: kmVoters){
                double chance = v.getKmDistance()/total;
                v.setKmMin(bridgeValue);
                v.setKmMax(bridgeValue + chance);
                bridgeValue = v.getKmMax();
            }
            
            double winValue = r.nextDouble();
            
            ListIterator<Voter> it = kmVoters.listIterator();
            while(it.hasNext()){
                Voter v = it.next();
                if(winValue >= v.getKmMin() && winValue < v.getKmMax()){
                    voterCommittee.add(v);
                    it.remove();
                }
            }
        }
        
        for(Voter v: voterCommittee){
            committee.add(v.getFirstPreference().getCandidate());
        }
        
        return committee;
    }
    
}
