
import java.util.Comparator;


/*
Τα αντικείμενα της κλάσης αυτής αποτελούν δομικά στοιχεία του δισδιάστατου
πίνακα προτιμήσεων, κι αντιστοιχούν σε ένα ζευγάρι ψηφοφόρου-υποψήφιου. Η
θέση του υποψήφιου στην προτίμηση του ψηφοφόρου αποθηκεύεται εσωτερικά,
καθώς και δείκτες προς την προηγούμενη και την επόμενη προτίμηση του
ψηφοφόρου. Δηλαδή, το προφίλ προτιμήσεων λειτουργεί κι ως πίνακας με
indexing σταθερού χρόνου, αλλά και κάθε γραμμή του (κάθε προτίμηση ενός
ψηφοφόρου) λειτουργεί κι ως μία διπλά διασυνδεδεμένη λίστα.
*/
public class PreferenceItem {
    private Voter voter;
    private Candidate candidate;
    private int position;
    private PreferenceItem next;
    private PreferenceItem previous;
    
    //Μέθοδος κατασκευής νέων αντικειμένων της κλάσης
    public PreferenceItem(Voter v, Candidate c, int pos){
        voter = v;
        candidate = c;
        position = pos;
    }
    
    //Copy constructor
    public PreferenceItem(PreferenceItem pi){
        voter = pi.getVoter();
        candidate = pi.getCandidate();
        position = pi.getPosition();
    }
    
    
    //Getters & setters για τα διάφορα πεδία της κλάσης
    public Voter getVoter(){
        return voter;
    }
    
    public void setVoter(Voter v){
        voter = v;
    }
    
    public Candidate getCandidate(){
        return candidate;
    }
    
    public void setCandidate(Candidate c){
        candidate = c;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int pos) {
        position = pos;
    }
    
    public PreferenceItem getNext(){
        return next;
    }
    
    public void setNext(PreferenceItem next){
        this.next = next;
    }
    
    public PreferenceItem getPrevious(){
        return previous;
    }
    
    public void setPrevious(PreferenceItem previous){
        this.previous = previous;
    }
    
    /*
    Μέθοδος που υπολογίζει την βαθμολογία που λαμβάνει ο υποψήφιος από
    τον ψηφοφόρο βάσει του κανόνα σχετικής πλειοψηφίας
    */
    public int calcPlurality(){
        if (position == 1){
            return 1;
        }
        return 0;
    }
    
    /*
    Μέθοδος που υπολογίζει την βαθμολογία που λαμβάνει ο υποψήφιος από
    τον ψηφοφόρο βάσει του κανόνα Borda
    */
    public int calcBorda(int m){
        return m - (position);
    }
    
    /*
    Μέθοδος που υπολογίζει την βαθμολογία που λαμβάνει ο υποψήφιος από
    τον ψηφοφόρο βάσει του κανόνα k-Approval (Bloc)
    */
    public int calcBloc(int k){
        if (position <= k){
            return 1;
        }
        return 0;
    }
    
    /*
    Στατική μέθοδος σύγκρισης αντικειμένων της κλάσης με βάση το πεδίο
    position. Κατασκευασμένη έτσι ώστε στην ταξινόμηση μίας στήλης του
    πίνακα προτιμήσεων, να μπορούμε να εξάγουμε τους ψηφοφόρους σε φθίνουσα
    σειρά ως προς την προτίμησή τους για τον υποψήφιο που αντιστοιχεί στην
    στήλη αυτή (χρησιμοποιείται στον κανόνα Monroe).
    */
    public static Comparator<PreferenceItem> PiComparator
            = new Comparator<PreferenceItem>(){

        @Override
        public int compare(PreferenceItem pi1, PreferenceItem pi2) {
            return pi1.getPosition() - pi2.getPosition();
        }
        
    };
}