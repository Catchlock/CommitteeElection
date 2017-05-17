
import java.awt.Color;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

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
public abstract class ChartPanelMaker {
    
    public static ChartPanel createChart(ArrayList<Voter> voters,
            ArrayList<Candidate> candidates,ArrayList<Candidate> committee, 
            String title){
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries comitteeDataset = new XYSeries("Committee");
        for (Candidate c: committee) {
            comitteeDataset.add(c.getX(), c.getY());
        }
        dataset.addSeries(comitteeDataset);
        
        int n = voters.size();
        int m = candidates.size();
        
        int skipN = n/150;
        if(skipN < 1){
            skipN = 1;
        }
        
        int skipM = m/150;
        if(skipM < 1){
            skipM = 1;
        }
        
        Collections.sort(voters, Election.VoterNameComparator);
        Collections.sort(candidates, Election.CandidateNameComparator);
        
        XYSeries voterDataset = new XYSeries("Voters");
        for (int i = 0; i < n; i++) {
            Voter v = voters.get(i);
            if (i%skipN == 0){
                voterDataset.add(v.getX(), v.getY());
            }
        }
        dataset.addSeries(voterDataset);
        
        XYSeries candidateDataset = new XYSeries("Candidates");
        for (int i = 0; i < m; i++) {
            Candidate c = candidates.get(i);
            if (i%skipM == 0){
                candidateDataset.add(c.getX(), c.getY());
            }
        }
        dataset.addSeries(candidateDataset);
        
        Shape committeeShape = ShapeUtilities.createDiamond(5);
        Shape voterShape = ShapeUtilities.createDownTriangle(3);
        Shape candidateShape = ShapeUtilities.createUpTriangle(3);
        
        Color committeeColor = Color.DARK_GRAY;
        Color voterColor = Color.ORANGE;
        Color candidateColor = Color.LIGHT_GRAY;
        
        JFreeChart chart = ChartFactory.createScatterPlot(title, "",
                "", dataset, PlotOrientation.VERTICAL, true, true, true);
        XYPlot plot = chart.getXYPlot();
        XYItemRenderer r = plot.getRenderer();
        r.setSeriesShape(0, committeeShape);
        r.setSeriesPaint(0, committeeColor);
        r.setSeriesShape(1, voterShape);
        r.setSeriesPaint(1, voterColor);
        r.setSeriesShape(2, candidateShape);
        r.setSeriesPaint(2, candidateColor);
        ChartPanel chartPanel = new ChartPanel(chart);
        
        return chartPanel;
    }
}
