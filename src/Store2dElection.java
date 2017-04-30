
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
public class Store2dElection {
    private File file;
    private Election election;
    private int xLimit;
    private int yLimit;
    private int nClusters;
    private int mClusters;
    private ArrayList<ArrayList<Candidate>> committees;
    
    public Store2dElection (ElectionGUI eGUI, File file){
        this.file = file;
        election = eGUI.getElection2D();
        xLimit = eGUI.getxLimit();
        yLimit = eGUI.getyLimit();
        nClusters = eGUI.getnClusters();
        mClusters = eGUI.getmClusters();
        committees = new ArrayList();
        committees.add(eGUI.getCommitteeSNTV());
        committees.add(eGUI.getCommitteeBorda());
        committees.add(eGUI.getCommitteeBloc());
        committees.add(eGUI.getCommitteeSTV());
        committees.add(eGUI.getCommitteeGCC());
        committees.add(eGUI.getCommitteeGM());
        committees.add(eGUI.getCommitteeKM());
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public int getxLimit() {
        return xLimit;
    }

    public void setxLimit(int xLimit) {
        this.xLimit = xLimit;
    }

    public int getyLimit() {
        return yLimit;
    }

    public void setyLimit(int yLimit) {
        this.yLimit = yLimit;
    }

    public int getnClusters() {
        return nClusters;
    }

    public void setnClusters(int nClusters) {
        this.nClusters = nClusters;
    }

    public int getmClusters() {
        return mClusters;
    }

    public void setmClusters(int mClusters) {
        this.mClusters = mClusters;
    }

    public ArrayList<ArrayList<Candidate>> getCommittees() {
        return committees;
    }

    public void setCommittees(ArrayList<ArrayList<Candidate>> committees) {
        this.committees = committees;
    }

    public void writeToFile(){
        try {
            FileWriter write = new FileWriter(file);
            PrintWriter print_line = new PrintWriter(write);

            print_line.println(String.valueOf(election.getNumberOfVoters()));
            print_line.println(String.valueOf(election.getNumberOfCandidates()));
            print_line.println(String.valueOf(election.getCommitteeSize()));
            print_line.println(String.valueOf(xLimit));
            print_line.println(String.valueOf(yLimit));
            print_line.println(String.valueOf(nClusters));
            print_line.println(String.valueOf(mClusters));

            for(Voter v: election.getVoters()){
                String voterData = v.getName() + "," + v.getX() + "," + v.getY();
                print_line.println(voterData);
            }
            for(Candidate c: election.getCandidates()){
                String candidateData = c.getName() + "," + c.getX() + "," + c.getY();
                print_line.println(candidateData);
            }
            
            if(committees.get(0) != null){
                for(ArrayList<Candidate> committee: committees){
                    String winners = "";
                    for(Candidate c: committee){
                        winners += c.getName() + ",";
                    }
                    winners = winners.substring(0, (winners.length()-1));
                    print_line.println(winners);
                }
            }

            print_line.close();
        } catch (IOException ex) {
            Logger.getLogger(Store2dElection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
