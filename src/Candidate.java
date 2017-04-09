

/*
Κλάση της οποίας τα στιγμιότυπα αναπαριστούν τους υποψήφιους στον
δισδιάστατο χώρο. Κληρονομεί την κλάση Person και διατηρεί ακόμη τις
βαθμολογίες με βάση τους κανόνες της σχετικής πλειοψηφίας, Borda και Bloc.
Αποθηκεύονται επίσης οι βοηθητικές μεταβλητές kMeansIndex και selected οι
οποίες χρησιμοποιούνται στον κανόνα επιλογής μέσω clustering (k-means).
*/
public class Candidate extends Person {
    private int kMeansIndex;
    private boolean selected;
    private int pluralityScore;
    private int bordaScore;
    private int blocScore;
    
    /*
    Μέθοδος κατασκευής νέων υποψήφιων. Μηδενικές αρχικές βαθμολογίες και
    το boolean πεδίο selected αρχικοποιείται με τιμή false.
    */
    public Candidate(String name, double x, double y){
        super(name,x,y);
        selected = false;
        pluralityScore = 0;
        bordaScore = 0;
        blocScore = 0;
    }
    
    //Copy constructor
    public Candidate(Candidate c){
        super(c);
        kMeansIndex = c.getkMeansIndex();
        selected = c.getSelected();
        pluralityScore = c.getPluralityScore();
        bordaScore = c.getBordaScore();
        blocScore = c.getBlocScore();
    }
    
    //Getters & setters για τα διάφορα πεδία της κλάσης
    public int getkMeansIndex(){
        return kMeansIndex;
    }
    
    public void setkMeansIndex(int kMeansIndex){
        this.kMeansIndex = kMeansIndex;
    }
    
    public boolean getSelected(){
        return selected;
    }
    
    public void setSelected(boolean selected){
        this.selected = selected;
    }
    
    public int getPluralityScore(){
        return pluralityScore;
    }
    
    public void setPluralityScore(int ps){
        pluralityScore = ps;
    }
      
    public int getBordaScore(){
        return bordaScore;
    }
    
    public void setBordaScore(int bs){
        bordaScore = bs;
    }
      
    public int getBlocScore(){
        return blocScore;
    }
    
    public void setBlocScore(int bs){
        blocScore = bs;
    }
    
    /*
    Βοηθητική μέθοδος που αυξάνει την βαθμολογία σχετικής πλειοψηφίας
    κατά 1.
    */
    public void increasePluralityByOne(){
        pluralityScore++;
    }
    
    /*
    Βοηθητική μέθοδος που αυξάνει την βαθμολογία k-Approval (Bloc)
    κατά 1.
    */
    public void increaseBlocByOne(){
        blocScore++;
    }
}
