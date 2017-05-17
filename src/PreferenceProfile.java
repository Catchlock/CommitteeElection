
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
Τα αντικείμενα της κλάσης αυτής, αναπαριστούν ένα προφίλ προτιμήσεων
*/
public class PreferenceProfile {
    private PreferenceItem[][] profile;
    private boolean election2D;
    
    //Constructor που αρικοποιεί τον πίνακα στις δοσμένες διαστάσεις
    public PreferenceProfile(int row, int col){
        profile = new PreferenceItem[row][col];
    }
    
    /*
    Constructor που κατασκευάζει τον πίνακα προτιμήσεων, από τους πίνακες
    ψηφοφόρων και υποψήφιων που δίνονται ως ορίσματα
    */
    public PreferenceProfile(ArrayList<Voter> voters,
            ArrayList<Candidate> candidates, boolean election2D){
        profile = new PreferenceItem[voters.size()][candidates.size()];
        this.election2D = election2D;
        buildProfile(voters, candidates);
    }
    
    //Getters & Setters
    public PreferenceItem[][] getProfile(){
        return profile;
    }
    
    public void setProfile(PreferenceItem[][] profile){
        this.profile = profile;
    }
    
    public void addItem(PreferenceItem pi, int row, int col){
        profile[row][col] = pi;
    }
    
    public PreferenceItem getItem(int row, int col){
        return profile[row][col];
    }
    
    //Μέθοδος που υλοποιεί την κατασκευή του προφίλ προτιμήσεων.
    public void buildProfile(ArrayList<Voter> voters,
            ArrayList<Candidate> candidates){
        candidates.sort(Election.IndexComparator);
        int n = voters.size();
        int m = candidates.size();
        /*
        Σε κάθε ψηφοφόρο/υποψήφιο αποθηκεύουμε έναν ακέραιο που δείχνει
        σε ποιά γραμμή/στήλη του πίνακα αντιστοιχεί.
        */
        if(election2D){
            for(int i = 0; i < voters.size(); i++){
                voters.get(i).setProfileIndex(i);
            }
            for(int i = 0; i < candidates.size(); i++){
                candidates.get(i).setProfileIndex(i);
            }
        }
        
        profile = new PreferenceItem [n][m];
        List<Candidate> tempPreference = new ArrayList(m);
        
        /*
        Για κάθε ψηφοφόρο, ταξινομείται ο πίνακας των υποψήφιων βάσει των
        αποστάσεων σε αύξουσα σειρά (φθίνουσα σειρά προτίμησης). Με τη
        βοήθεια του ταξινομημένου πίνακα, κατασκευάζονται τα κατάλληλα
        PreferenceItems που κρατάνε την θέση αλλά και pointers στον
        αντίστοιχο voter και τον αντίστοιχο candidate, καθώς και pointers
        προς τα PreferenceItems που κρατούν την προηγούμενη και την επόμενη
        θέση προτίμησης του αντίστοιχου ψηφοφόρου.
        */
        for (int row = 0; row < n; row++){
            Voter v = voters.get(row);
            if(election2D){
                tempPreference = new ArrayList<>(candidates);
                Collections.sort(tempPreference, v);
            }
            else {
                tempPreference = new ArrayList<>();
                for(int i = 0; i < m; i++){
                    int cIndex = v.getGeneralPrefIndices()[i] - 1;
                    Candidate c = candidates.get(cIndex);
                    tempPreference.add(c);
                }
            }
            PreferenceItem bridge = null;
            
            for(int i = 0; i < m; i++){
                Candidate c = tempPreference.get(i);
                int col = c.getProfileIndex();
                int position = i + 1;
                profile[row][col] = new PreferenceItem(v,c,position);
                if (position == 1){
                    v.setFirstPreference(profile[row][col]);
                }
                if(bridge != null){
                    profile[row][col].setPrevious(bridge);
                    bridge.setNext(profile[row][col]);
                }
                bridge = profile[row][col];
            }
        } 
    }
}
