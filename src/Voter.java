
import java.util.Comparator;

/*
Κλάση της οποίας τα στιγμιότυπα αναπαριστούν ψηφοφόρους στις δύο διαστάσεις.
Υλοποιεί το interface Comparator<Candidate>, για τη σύγκριση δύο υποψήφιων
από έναν ψηφοφόρο βάσει της Ευκλείδιας απόστασης. Διατηρεί εσωτερικά, εκτός
από τα πεδία που κληρονομεί από την κλάση Person, δηλαδή το όνομα και τις
συντεταγμένες, κι έναν ακέραιο που "δειχνει" στην γραμμή του πίνακα
προτιμήσεων στην οποία αντιστοιχεί ο ψηφοφόρος, καθώς κι ένα pointer στην
πρώτη του προτίμηση.
*/
public class Voter extends Person implements Comparator<Candidate>{
    private PreferenceItem firstPreference;
    
    //Μέθοδος κατασκευής ψηφοφόρου που ορίζει όνομα και συντεταγμένες
    public Voter(String name, double x, double y){
        super(name, x, y);
    }
    
    //Copy constructor
    public Voter(Voter v){
        super(v);
        firstPreference = v.getFirstPreference();
    }
    
    //Getters & Setters
    public PreferenceItem getFirstPreference(){
        return firstPreference;
    }
    
    public void setFirstPreference(PreferenceItem firstPreference){
        this.firstPreference = firstPreference;
    }

    /*
    Υλοποίηση της abstract μεθόδου compare του interface Comparator,
    για τη σύγκριση δύο υποψήφιων. Φτιαγμένη έτσι ώστε να παράγεται το
    αποτέλεσμα της ταξινόμησης μίας λίστας υποψήφιων σε φθίνουσα σειρά
    προτίμησης.
    */
    @Override
    public int compare(Candidate c1, Candidate c2) {
        return (distance(c1)- distance(c2) > 0) ? 1 : -1;
    }
}
