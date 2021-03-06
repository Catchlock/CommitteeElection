
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
public class ParseGeneralElection {
    private ArrayList<Voter> voters;
    private ArrayList<Candidate> candidates;
    private String err;
    
    public ArrayList<Voter> getVoters() {
        return voters;
    }

    public void setVoters(ArrayList<Voter> voters) {
        this.voters = voters;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
    
    public void parseFromFile(File file){
        try {
            Scanner fileScanner = new Scanner(file);
            int m = fileScanner.nextInt();
            candidates = new ArrayList(m);
            fileScanner.nextLine();
            for (int i = 0; i < m; i++){
                String candidateLine = fileScanner.nextLine();
                String[] candidateData = candidateLine.split(",");
                String name = candidateData[1];
                Candidate c = new Candidate(name);
                c.setProfileIndex(i);
                candidates.add(c);
            }
            
            String ballotLine = fileScanner.nextLine();
            String[] ballotInfo = ballotLine.split(",");
            int n = Integer.parseInt(ballotInfo[0]);
            
            voters = new ArrayList(n);
            int vIndex = 0;
            
            while(voters.size() < n){
                String voterLine = fileScanner.nextLine();
                voterLine = voterLine.replaceAll("\\s", "");
                voterLine = voterLine.replace(",{}", "");
                String[] voterData = voterLine.split(",");
                int times = Integer.parseInt(voterData[0]);
                
                for(int i = 0; i < times; i++){
                    Voter v = new Voter("v"+vIndex);
                    v.setProfileIndex(vIndex);
                    vIndex++;
                    v.setGeneralPrefIndices(new int[m]);
                    
                    for(int j = 1; j < m+1; j++){
                        if("{".equals(voterData[j].substring(0, 1)) 
                                && "}".equals(voterData[j]
                                        .substring(voterData[j].length()-1))){
                            voterData[j] = voterData[j]
                                    .substring(1, voterData[j].length()-1);
                        }
                        if("{".equals(voterData[j].substring(0, 1))){
                            int j2 = j;
                            ArrayList<Integer> ties = new ArrayList();
                            ties.add(Integer.parseInt(voterData[j2]
                                    .substring(1)));
                            j2++;
                            while(!"}".equals(voterData[j2]
                                    .substring(voterData[j2].length() - 1))){
                                ties.add(Integer.parseInt(voterData[j2]));
                                j2++;
                            }
                            ties.add(Integer.parseInt(voterData[j2]
                                    .substring(0, voterData[j2].length() - 1)));
                            Collections.shuffle(ties);
                            for(Integer a: ties){
                                v.getGeneralPrefIndices()[j-1] = a;
                                j++;
                            }
                            j--;
                        }
                        else{
                            v.getGeneralPrefIndices()[j-1] = 
                                    Integer.parseInt(voterData[j]);
                        }
                    }
                    voters.add(v);
                }
            }
            fileScanner.close();
            
        } catch (FileNotFoundException ex) {
            err = "File Not Found!";
        } catch (Exception e){
            err = "Invalid election file.";
        }
          
    }
}
