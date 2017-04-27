
import java.util.ArrayList;
import java.util.Comparator;

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
    private double kmDistance;
    private double kmMin;
    private double kmMax;
    private int[] generalPrefIndices;

    //Μέθοδος κατασκευής ψηφοφόρου που ορίζει όνομα και συντεταγμένες
    public Voter(String name, double x, double y){
        super(name, x, y);
    }
    
    //Μέθοδος κατασκευής ψηφοφόρου που ορίζει όνομα
    public Voter(String name){
        super(name);
    }
    
    //Copy constructor
    public Voter(Voter v){
        super(v);
        this.generalPrefIndices = v.getGeneralPrefIndices();
        firstPreference = v.getFirstPreference();
        kmDistance = v.getKmDistance();
        kmMin = v.getKmMin();
        kmMax = v.getKmMax();
    }
    
    //Getters & Setters
    public PreferenceItem getFirstPreference(){
        return firstPreference;
    }
    
    public void setFirstPreference(PreferenceItem firstPreference){
        this.firstPreference = firstPreference;
    }

    public double getKmDistance() {
        return kmDistance;
    }

    public void setKmDistance(double kmDistance) {
        this.kmDistance = kmDistance;
    }

    public double getKmMin() {
        return kmMin;
    }

    public void setKmMin(double kmMin) {
        this.kmMin = kmMin;
    }

    public double getKmMax() {
        return kmMax;
    }

    public void setKmMax(double kmMax) {
        this.kmMax = kmMax;
    }

    public int[] getGeneralPrefIndices() {
        return generalPrefIndices;
    }

    public void setGeneralPrefIndices(int[] generalPrefIndices) {
        this.generalPrefIndices = generalPrefIndices;
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
