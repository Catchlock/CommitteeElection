
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
Τα αντικείμενα της κλάσης αυτής, αναπαριστούν ένα προφίλ προτιμήσεων
*/
public class PreferenceProfile {
    private PreferenceItem[][] profile;
    
    //Constructor που αρικοποιεί τον πίνακα στις δοσμένες διαστάσεις
    public PreferenceProfile(int row, int col){
        profile = new PreferenceItem[row][col];
    }
    
    /*
    Constructor που κατασκευάζει τον πίνακα προτιμήσεων, από τους πίνακες
    ψηφοφόρων και υποψήφιων που δίνονται ως ορίσματα
    */
    public PreferenceProfile(ArrayList<Voter> voters,
            ArrayList<Candidate> candidates){
        profile = new PreferenceItem[voters.size()][candidates.size()];
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
        int n = voters.size();
        int m = candidates.size();
        /*
        Σε κάθε ψηφοφόρο/υποψήφιο αποθηκεύουμε έναν ακέραιο που δείχνει
        σε ποιά γραμμή/στήλη του πίνακα αντιστοιχεί.
        */
        for(int i = 0; i < voters.size(); i++){
            voters.get(i).setProfileIndex(i);
        }
        for(int i = 0; i < candidates.size(); i++){
            candidates.get(i).setProfileIndex(i);
        }
        
        profile = new PreferenceItem [n][m];
        List<Candidate> tempPreference = new ArrayList<>(candidates);
        Collections.shuffle(tempPreference);
        
        /*
        Για κάθε ψηφοφόρο, ταξινομείται ο πίνακας των υποψήφιων βάσει των
        αποστάσεων σε αύξουσα σειρά (φθίνουσα σειρά προτίμησης). Με τη
        βοήθεια του ταξινομημένου πίνακα, κατασκευάζονται τα κατάλληλα
        PreferenceItems που κρατάνε την θέση καθώς και pointers στον
        αντίστοιχο voter και τον αντίστοιχο candidate, καθώς και pointers
        προς τα PreferenceItems που κρατούν την προηγούμενη και την επόμενη
        θέση προτίμησης του αντίστοιχου ψηφοφόρου.
        */
        for (int row = 0; row < n; row++){
            Voter v = voters.get(row);
            Collections.sort(tempPreference, v);
            PreferenceItem next = null;
            PreferenceItem previous = null;
            for (int j = 0 ; j < m; j++){
                Candidate c = tempPreference.get(j);
                int col = c.getProfileIndex();
                int position = j + 1;
                profile[row][col] = new PreferenceItem(v, c, position);
                if (position == 1){
                    v.setFirstPreference(profile[row][col]);
                }
                profile[row][col].setPrevious(previous);
                previous = profile[row][col];
            }
            for (int j = m - 1; j >= 0; j--){
                Candidate c = tempPreference.get(j);
                int col = c.getProfileIndex();
                profile[row][col].setNext(next);
                next = profile[row][col];
            }
        } 
    }
}
