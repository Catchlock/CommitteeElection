
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
    private int generalParserIndex;

    /*
    Μέθοδος κατασκευής νέων υποψήφιων με συντεταγμένες στο επίπεδο.
    Μηδενικές αρχικές βαθμολογίες και το boolean πεδίο selected
    αρχικοποιείται με τιμή false.
    */
    public Candidate(String name, double x, double y){
        super(name,x,y);
        selected = false;
        pluralityScore = 0;
        bordaScore = 0;
        blocScore = 0;
    }
    
    /*
    Μέθοδος κατασκευής νέων υποψήφιων χωρίς συντεταγμένες. Μηδενικές αρχικές
    βαθμολογίες και το boolean πεδίο selected αρχικοποιείται με τιμή false.
    */
    public Candidate(String name){
        super(name);
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
    
    public int getGeneralParserIndex() {
        return generalParserIndex;
    }

    public void setGeneralParserIndex(int generalParserIndex) {
        this.generalParserIndex = generalParserIndex;
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
