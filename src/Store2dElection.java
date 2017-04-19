
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private Election election;
    private File file;
    private int xLimit;
    private int yLimit;
    private int nClusters;
    private int mClusters;
    
    public Store2dElection (Election election, File file, int xLimit, int yLimit, int nClusters, int mClusters){
        this.election = election;
        this.file = file;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
        this.nClusters = nClusters;
        this.mClusters = mClusters;
    }
    
    public void setElection(Election election){
        this.election = election;
    }
    
    public Election getElection(){
        return election;
    }
    
    public void setFile(File file){
        this.file = file;
    }
    
    public File getFile(){
        return file;
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

            print_line.close();
        } catch (IOException ex) {
            Logger.getLogger(Store2dElection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
