
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
public class Parse2dElection {
    private Election election;
    private int xLimit;
    private int yLimit;
    private int nClusters;
    private int mClusters;
    private String err;
    
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
    
    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
    
    public void parseFromFile(File file){
        try {
            Scanner fileScanner = new Scanner(file);
            int n = fileScanner.nextInt();
            int m = fileScanner.nextInt();
            int k = fileScanner.nextInt();
            xLimit = fileScanner.nextInt();
            yLimit = fileScanner.nextInt();
            nClusters = fileScanner.nextInt();
            mClusters = fileScanner.nextInt();
            
            ArrayList<Candidate> candidates = new ArrayList();
            ArrayList<Voter> voters = new ArrayList();
            fileScanner.nextLine();
            
            for (int i = 0; i < n; i++){
                String voterData = fileScanner.nextLine();
                String[] data = voterData.split(",");
                String vName = data[0];
                double x = Double.parseDouble(data[1]);
                double y = Double.parseDouble(data[2]);
                voters.add(new Voter(vName,x,y));
            }
            
            for (int i = 0; i < m; i++){
                String candidateData = fileScanner.nextLine();
                String[] data = candidateData.split(",");
                String cName = data[0];
                double x = Double.parseDouble(data[1]);
                double y = Double.parseDouble(data[2]);
                candidates.add(new Candidate(cName,x,y));
            }
            
            fileScanner.close();
            
            election = new Election(k,voters,candidates);
            
        } catch (FileNotFoundException ex) {
            err = "File Not Found!";
        } catch (Exception e){
            err = "Invalid election file.";
        }
          
    }
}
