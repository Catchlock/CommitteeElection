
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.math3.distribution.MultivariateNormalDistribution;


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
Αφηρημένη υπερκλάση που συναθροίζει τα κοινά στοιχεία ψηφοφόρων και
υποψήφιων.
*/
public abstract class Person {
    String name;
    double x;
    double y;
    int profileIndex;
    
    //Μέθοδος κατασκευής που καθορίζει το όνομα και τις συντεταγμένες
    public Person(String name, double x, double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    //Μέθοδος κατασκευής που καθορίζει μόνο το όνομα
    public Person(String name){
        this.name = name;
    }
    
    //Copy constructor
    public Person(Person p){
        name = p.getName();
        x = p.getX();
        y = p.getY();
        profileIndex = p.getProfileIndex();
    }
    
    /*
    Απαριθμητής των τύπων ενός ατόμου. Χρησιμοποιείται για να διαχωρίσουμε
    τμήματα κώδικα που αφορούν μόνο τους ψηφοφόρους ή μόνο τους υποψήφιους.
    */
    public enum personType{
        VOTER,
        CANDIDATE
    }
    
    //Getters & Setters
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getX(){
        return x;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public int getProfileIndex(){
        return profileIndex;
    }
    
    public void setProfileIndex(int preferenceIndex){
        this.profileIndex = preferenceIndex;
    }
    
    //Μέθοδος που υπολογίζει την ευκλείδια απόσταση δύο ατόμων
    public double distance(Person p){
        double d = sqrt(Math.pow((x - p.getX()),2)+
                Math.pow((y - p.getY()),2));
        return d;
    }
    
    /*
    Στατική μέθοδος δημιουργίας n ατόμων, ψηφοφόρων ή υποψήφιων ανάλογα με
    την τιμή του πρώτου ορίσματος, με ομοιόμορφη κατανομή μέσα σε ένα
    ορθογώνιο χώρο με κέντρο το σημείο (xCenter, yCenter), πλάτος width,
    ύψος height και οριακές συντεταγμένες xLimit και yLimit.
    */
    public static ArrayList<Person> squareUniformDistribution(personType pt,
            int n, double xCenter, double yCenter, double width,
            double height, int xLimit, int yLimit){
        
        ArrayList<Person> people =  new ArrayList(n);
        Random rand = new Random();
        
        while (people.size() < n){
            double x = rand.nextDouble()*width + xCenter - width/2;
            double z = rand.nextDouble();
            double y = z*height + yCenter - height/2;
            if(x >= -xLimit && x <= xLimit && y >= -yLimit && y <= yLimit){
                if (pt == personType.VOTER){
                    people.add(new Voter(("v" + people.size()),x,y));
                }
                else if (pt == personType.CANDIDATE){
                    people.add(new Candidate(("c" + people.size()),x,y));
                }
            }
        }
        return people;
    }
    
    /*
    Στατική μέθοδος δημιουργίας n ατόμων, ψηφοφόρων ή υποψήφιων ανάλογα με
    την τιμή του πρώτου ορίσματος, με ομοιόμορφη κατανομή μέσα σε ένα
    κυκλικό χώρο με κέντρο το σημείο (xCenter, yCenter), ακτίνα radius
    και οριακές συντεταγμένες xLimit και yLimit.
    */
    public static ArrayList<Person> discUniformDistribution(personType pt,
            int n, double xCenter, double yCenter, double radius, int xLimit, int yLimit){
        
        ArrayList<Person> people =  new ArrayList(n);
        Random rand = new Random();
        
        while (people.size() < n){
            double angle = rand.nextDouble()*2*Math.PI;
            double r = rand.nextDouble()*radius;
            double x = xCenter + r*Math.cos(angle);
            double y = yCenter + r*Math.sin(angle);
            if(x >= -xLimit && x <= xLimit && y >= -yLimit && y <= yLimit){
                if (pt == personType.VOTER){
                    people.add(new Voter(("v" + people.size()),x,y));
                }
                else if (pt == personType.CANDIDATE){
                    people.add(new Candidate(("c" + people.size()),x,y));
                }
            }
        }
        return people;
    }
    
    /*
    Στατική μέθοδος δημιουργίας n ατόμων, ψηφοφόρων ή υποψήφιων ανάλογα με
    την τιμή του πρώτου ορίσματος, με ομοιόμορφη κατανομή μέσα σε ένα
    κυκλικό χώρο με κέντρο το σημείο (xCenter, yCenter), ακτίνα radius
    και οριακές συντεταγμένες xLimit και yLimit.
    */
    public static ArrayList<Person> ringUniformDistribution(personType pt,
            int n, double xCenter, double yCenter, double minRadius,
            double maxRadius, int xLimit, int yLimit){
        
        ArrayList<Person> people =  new ArrayList(n);
        Random rand = new Random();
        
        while (people.size() < n){
            double angle = rand.nextDouble()*2*Math.PI;
            double r = rand.nextDouble()*(maxRadius - minRadius) + minRadius;
            double x = xCenter + r*Math.cos(angle);
            double y = yCenter + r*Math.sin(angle);
            if(x >= -xLimit && x <= xLimit && y >= -yLimit && y <= yLimit){
                if (pt == personType.VOTER){
                    people.add(new Voter(("v" + people.size()),x,y));
                }
                else if (pt == personType.CANDIDATE){
                    people.add(new Candidate(("c" + people.size()),x,y));
                }
            }
        }
        return people;
    }
    
    /*
    Στατική μέθοδος δημιουργίας n ατόμων, ψηφοφόρων ή υποψήφιων ανάλογα με
    την τιμή του πρώτου ορίσματος, με κανονική κατανομή (Gauss) μέσα
    σε ένα ορθογώνιο χώρο με οριακές συντεταγμένες xLimit/yLimit, μέση τιμή
    xMean/yMean και τυπική απόκλιση xStdDev/yStdDev.
    */
    public static ArrayList<Person> gaussianDistribution(personType pt,
            int n, double xMean, double yMean, int xLimit, int yLimit,
            double xStdDev, double yStdDev){
        ArrayList<Person> people =  new ArrayList(n);
        double[] means = new double[] {xMean, yMean};
        double[][] covariances = new double[][] {{Math.pow(xStdDev, 2), 0},
            {0, Math.pow(yStdDev, 2)}};
        MultivariateNormalDistribution mnd =
                new MultivariateNormalDistribution(means, covariances);
        while (people.size() < n){
            double[] sample = mnd.sample();
            double x = sample[0];
            double y = sample[1];
            if(x >= -xLimit && x <= xLimit && y >= -yLimit && y <= yLimit){
                if (pt == personType.VOTER){
                    people.add(new Voter(("v" + people.size()),x,y));
                }
                else if (pt == personType.CANDIDATE){
                    people.add(new Candidate(("c" + people.size()),x,y));
                }
            }
        }
        return people;
    }
}
