
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;

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
public class ElectionGUI extends javax.swing.JFrame {

    private final String eol = System.getProperty("line.separator");
    private Election election2D;
    private Election electionGP;
    private int n = 300;
    private int m = 100;
    private int nClusters = 1;
    private int mClusters = 1;
    private int k = 10;
    private int xLimit = 6;
    private int yLimit = 6;
    private ArrayList<Candidate> committeeSNTV;
    private ArrayList<Candidate> committeeBorda;
    private ArrayList<Candidate> committeeBloc;
    private ArrayList<Candidate> committeeSTV;
    private ArrayList<Candidate> committeeGCC;
    private ArrayList<Candidate> committeeGM;
    private ArrayList<Candidate> committeeKM;
    private boolean saved = false;
    private File folder;
    
    /**
     * Creates new form ElectionGUI2
     */
    public ElectionGUI() {
        initComponents();
        folder = new File(System.getProperty("user.home"));
    }

    //Getters & Setters
    public Election getElection2D() {
        return election2D;
    }

    public void setElection2D(Election election2D) {
        this.election2D = election2D;
    }

    public Election getElectionGP() {
        return electionGP;
    }

    public void setElectionGP(Election electionGP) {
        this.electionGP = electionGP;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
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

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
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

    public ArrayList<Candidate> getCommitteeSNTV() {
        return committeeSNTV;
    }

    public void setCommitteeSNTV(ArrayList<Candidate> committeeSNTV) {
        this.committeeSNTV = committeeSNTV;
    }

    public ArrayList<Candidate> getCommitteeBorda() {
        return committeeBorda;
    }

    public void setCommitteeBorda(ArrayList<Candidate> committeeBorda) {
        this.committeeBorda = committeeBorda;
    }

    public ArrayList<Candidate> getCommitteeBloc() {
        return committeeBloc;
    }

    public void setCommitteeBloc(ArrayList<Candidate> committeeBloc) {
        this.committeeBloc = committeeBloc;
    }

    public ArrayList<Candidate> getCommitteeSTV() {
        return committeeSTV;
    }

    public void setCommitteeSTV(ArrayList<Candidate> committeeSTV) {
        this.committeeSTV = committeeSTV;
    }

    public ArrayList<Candidate> getCommitteeGCC() {
        return committeeGCC;
    }

    public void setCommitteeGCC(ArrayList<Candidate> committeeGCC) {
        this.committeeGCC = committeeGCC;
    }

    public ArrayList<Candidate> getCommitteeGM() {
        return committeeGM;
    }

    public void setCommitteeGM(ArrayList<Candidate> committeeGM) {
        this.committeeGM = committeeGM;
    }

    public ArrayList<Candidate> getCommitteeKM() {
        return committeeKM;
    }

    public void setCommitteeKM(ArrayList<Candidate> committeeKM) {
        this.committeeKM = committeeKM;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
    
    //Μέθοδος που "σβήνει" τα πάνελ που περιέχουν τα γραφήματα
    public void clearGraphPanels(){
        plotAreaSNTV.removeAll();
        plotAreaSNTV.revalidate();
        plotAreaSNTV.repaint();
        
        plotAreaBorda.removeAll();
        plotAreaBorda.revalidate();
        plotAreaBorda.repaint();
        
        plotAreaBloc.removeAll();
        plotAreaBloc.revalidate();
        plotAreaBloc.repaint();
        
        plotAreaSTV.removeAll();
        plotAreaSTV.revalidate();
        plotAreaSTV.repaint();
        
        plotAreaGCC.removeAll();
        plotAreaGCC.revalidate();
        plotAreaGCC.repaint();
        
        plotAreaGM.removeAll();
        plotAreaGM.revalidate();
        plotAreaGM.repaint();
        
        plotAreaKM.removeAll();
        plotAreaKM.revalidate();
        plotAreaKM.repaint();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        plotAreaSTV = new javax.swing.JPanel();
        plotAreaGCC = new javax.swing.JPanel();
        plotAreaGM = new javax.swing.JPanel();
        plotAreaKM = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        mainTitle = new javax.swing.JLabel();
        nLabel = new javax.swing.JLabel();
        mLabel = new javax.swing.JLabel();
        kLabel = new javax.swing.JLabel();
        nTxtField = new javax.swing.JTextField();
        mTxtField = new javax.swing.JTextField();
        kTxtField = new javax.swing.JTextField();
        nClusterTitle = new javax.swing.JLabel();
        nClusterLabel = new javax.swing.JLabel();
        nClusterTxtField = new javax.swing.JTextField();
        mClusterTitle = new javax.swing.JLabel();
        mClusterLabel = new javax.swing.JLabel();
        mClusterTxtField = new javax.swing.JTextField();
        createElectionBtn = new javax.swing.JButton();
        saveElectionBtn = new javax.swing.JButton();
        loadElectionBtn = new javax.swing.JButton();
        plotResultsBtn = new javax.swing.JButton();
        xLimitLabel = new javax.swing.JLabel();
        xLimitTxtField = new javax.swing.JTextField();
        yLimitLabel = new javax.swing.JLabel();
        yLimitTxtField = new javax.swing.JTextField();
        generalPreferencesCheckBox = new javax.swing.JCheckBox();
        consistencyBtn = new javax.swing.JButton();
        plotAreaSNTV = new javax.swing.JPanel();
        plotAreaBorda = new javax.swing.JPanel();
        plotAreaBloc = new javax.swing.JPanel();
        systemPanel = new javax.swing.JPanel();
        systemPane = new javax.swing.JScrollPane();
        systemTxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Committee Elections v0.9");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/elections.png")));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {270, 270, 270, 270};
        layout.rowHeights = new int[] {270, 270, 140};
        getContentPane().setLayout(layout);

        plotAreaSTV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plotAreaSTV.setMaximumSize(new java.awt.Dimension(300, 300));
        plotAreaSTV.setMinimumSize(new java.awt.Dimension(300, 300));
        plotAreaSTV.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout plotAreaSTVLayout = new javax.swing.GroupLayout(plotAreaSTV);
        plotAreaSTV.setLayout(plotAreaSTVLayout);
        plotAreaSTVLayout.setHorizontalGroup(
            plotAreaSTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        plotAreaSTVLayout.setVerticalGroup(
            plotAreaSTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaSTV, gridBagConstraints);

        plotAreaGCC.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plotAreaGCC.setMaximumSize(new java.awt.Dimension(300, 300));
        plotAreaGCC.setMinimumSize(new java.awt.Dimension(300, 300));
        plotAreaGCC.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout plotAreaGCCLayout = new javax.swing.GroupLayout(plotAreaGCC);
        plotAreaGCC.setLayout(plotAreaGCCLayout);
        plotAreaGCCLayout.setHorizontalGroup(
            plotAreaGCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        plotAreaGCCLayout.setVerticalGroup(
            plotAreaGCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaGCC, gridBagConstraints);

        plotAreaGM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plotAreaGM.setMaximumSize(new java.awt.Dimension(300, 300));
        plotAreaGM.setMinimumSize(new java.awt.Dimension(300, 300));
        plotAreaGM.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout plotAreaGMLayout = new javax.swing.GroupLayout(plotAreaGM);
        plotAreaGM.setLayout(plotAreaGMLayout);
        plotAreaGMLayout.setHorizontalGroup(
            plotAreaGMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        plotAreaGMLayout.setVerticalGroup(
            plotAreaGMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaGM, gridBagConstraints);

        plotAreaKM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plotAreaKM.setMaximumSize(new java.awt.Dimension(300, 300));
        plotAreaKM.setMinimumSize(new java.awt.Dimension(300, 300));
        plotAreaKM.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout plotAreaKMLayout = new javax.swing.GroupLayout(plotAreaKM);
        plotAreaKM.setLayout(plotAreaKMLayout);
        plotAreaKMLayout.setHorizontalGroup(
            plotAreaKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        plotAreaKMLayout.setVerticalGroup(
            plotAreaKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaKM, gridBagConstraints);

        menuPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuPanel.setMaximumSize(new java.awt.Dimension(270, 410));
        menuPanel.setMinimumSize(new java.awt.Dimension(270, 410));
        menuPanel.setPreferredSize(new java.awt.Dimension(270, 410));
        java.awt.GridBagLayout menuPanelLayout = new java.awt.GridBagLayout();
        menuPanelLayout.columnWidths = new int[] {10, 35, 45, 45, 45, 45, 35, 10};
        menuPanelLayout.rowHeights = new int[] {40, 20, 20, 20, 5, 20, 20, 30, 20, 30, 20, 20, 40, 40, 10, 30};
        menuPanel.setLayout(menuPanelLayout);

        mainTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Create a 2D Committee Election");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mainTitle, gridBagConstraints);

        nLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nLabel.setText("Number of Voters: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nLabel, gridBagConstraints);

        mLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mLabel.setText("Number of Candidates: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mLabel, gridBagConstraints);

        kLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        kLabel.setText("Committee Size: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(kLabel, gridBagConstraints);

        nTxtField.setText("300");
        nTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nTxtFieldFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nTxtField, gridBagConstraints);

        mTxtField.setText("100");
        mTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mTxtFieldFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mTxtField, gridBagConstraints);

        kTxtField.setText("10");
        kTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kTxtFieldFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(kTxtField, gridBagConstraints);

        nClusterTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nClusterTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nClusterTitle.setText("Voter Distribution");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nClusterTitle, gridBagConstraints);

        nClusterLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nClusterLabel.setText("Number of Voter Clusters: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nClusterLabel, gridBagConstraints);

        nClusterTxtField.setText("1");
        nClusterTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nClusterTxtFieldFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nClusterTxtField, gridBagConstraints);

        mClusterTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mClusterTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mClusterTitle.setText("Candidate Distribution");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mClusterTitle, gridBagConstraints);

        mClusterLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mClusterLabel.setText("Number of Candidate Clusters: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mClusterLabel, gridBagConstraints);

        mClusterTxtField.setText("1");
        mClusterTxtField.setMaximumSize(new java.awt.Dimension(50, 20));
        mClusterTxtField.setMinimumSize(new java.awt.Dimension(50, 20));
        mClusterTxtField.setPreferredSize(new java.awt.Dimension(50, 20));
        mClusterTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mClusterTxtFieldFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mClusterTxtField, gridBagConstraints);

        createElectionBtn.setText("Create Election");
        createElectionBtn.setMaximumSize(new java.awt.Dimension(110, 23));
        createElectionBtn.setMinimumSize(new java.awt.Dimension(110, 23));
        createElectionBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        createElectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createElectionBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(createElectionBtn, gridBagConstraints);

        saveElectionBtn.setText("Save Election");
        saveElectionBtn.setEnabled(false);
        saveElectionBtn.setMaximumSize(new java.awt.Dimension(110, 23));
        saveElectionBtn.setMinimumSize(new java.awt.Dimension(110, 23));
        saveElectionBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        saveElectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveElectionBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(saveElectionBtn, gridBagConstraints);

        loadElectionBtn.setText("Load Election");
        loadElectionBtn.setMaximumSize(new java.awt.Dimension(110, 23));
        loadElectionBtn.setMinimumSize(new java.awt.Dimension(110, 23));
        loadElectionBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        loadElectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadElectionBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(loadElectionBtn, gridBagConstraints);

        plotResultsBtn.setText("Plot Results");
        plotResultsBtn.setEnabled(false);
        plotResultsBtn.setMaximumSize(new java.awt.Dimension(110, 23));
        plotResultsBtn.setMinimumSize(new java.awt.Dimension(110, 23));
        plotResultsBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        plotResultsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotResultsBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(plotResultsBtn, gridBagConstraints);

        xLimitLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        xLimitLabel.setText("x-Axis bound: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(xLimitLabel, gridBagConstraints);

        xLimitTxtField.setText("3");
        xLimitTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xLimitTxtFieldFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(xLimitTxtField, gridBagConstraints);

        yLimitLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        yLimitLabel.setText("y-Axis bound: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(yLimitLabel, gridBagConstraints);

        yLimitTxtField.setText("3");
        yLimitTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                yLimitTxtFieldFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(yLimitTxtField, gridBagConstraints);

        generalPreferencesCheckBox.setText("General Preferences");
        generalPreferencesCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        generalPreferencesCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        generalPreferencesCheckBox.setMaximumSize(new java.awt.Dimension(1203, 230));
        generalPreferencesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalPreferencesCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(generalPreferencesCheckBox, gridBagConstraints);

        consistencyBtn.setText("Consistency Check");
        consistencyBtn.setEnabled(false);
        consistencyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consistencyBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(consistencyBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(menuPanel, gridBagConstraints);

        plotAreaSNTV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plotAreaSNTV.setMaximumSize(new java.awt.Dimension(300, 300));
        plotAreaSNTV.setMinimumSize(new java.awt.Dimension(300, 300));
        plotAreaSNTV.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout plotAreaSNTVLayout = new javax.swing.GroupLayout(plotAreaSNTV);
        plotAreaSNTV.setLayout(plotAreaSNTVLayout);
        plotAreaSNTVLayout.setHorizontalGroup(
            plotAreaSNTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        plotAreaSNTVLayout.setVerticalGroup(
            plotAreaSNTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaSNTV, gridBagConstraints);

        plotAreaBorda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plotAreaBorda.setMaximumSize(new java.awt.Dimension(300, 300));
        plotAreaBorda.setMinimumSize(new java.awt.Dimension(300, 300));
        plotAreaBorda.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout plotAreaBordaLayout = new javax.swing.GroupLayout(plotAreaBorda);
        plotAreaBorda.setLayout(plotAreaBordaLayout);
        plotAreaBordaLayout.setHorizontalGroup(
            plotAreaBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        plotAreaBordaLayout.setVerticalGroup(
            plotAreaBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaBorda, gridBagConstraints);

        plotAreaBloc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plotAreaBloc.setMaximumSize(new java.awt.Dimension(300, 300));
        plotAreaBloc.setMinimumSize(new java.awt.Dimension(300, 300));
        plotAreaBloc.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout plotAreaBlocLayout = new javax.swing.GroupLayout(plotAreaBloc);
        plotAreaBloc.setLayout(plotAreaBlocLayout);
        plotAreaBlocLayout.setHorizontalGroup(
            plotAreaBlocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        plotAreaBlocLayout.setVerticalGroup(
            plotAreaBlocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaBloc, gridBagConstraints);

        systemPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        systemPanel.setLayout(new java.awt.BorderLayout());

        systemTxt.setEditable(false);
        systemTxt.setColumns(20);
        systemTxt.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        systemTxt.setRows(5);
        systemPane.setViewportView(systemTxt);

        systemPanel.add(systemPane, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(systemPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Μέθοδος δημιουργίας δισδιάστατων επιτροπών. Καλείται μόλις ο χρήστης
    πατήσει το κουμπί "Create Election".
    */
    private void createElectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createElectionBtnActionPerformed
        //Confirmation of discarding an election2D that is not saved
        boolean discard = true;
        if(election2D != null && !saved){
            int response = JOptionPane.showConfirmDialog(null, "Current "
                    + "election is not saved, are you sure you want to create "
                    + "a new election?" + eol + "Press \"No\" to save current "
                            + "election in a file.", "Confirm", 
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.QUESTION_MESSAGE);
            
            if (response == JOptionPane.NO_OPTION) {
                discard = false;
                systemTxt.append("-Election creation cancelled." + eol);
            }
        }
        
        if (discard){
            //Input validation
            String err = "";
            
            try{
                int x = Integer.parseInt(nTxtField.getText());
                if (x < 1 || x > 1000){
                    throw (new Exception());
                }
                n = x;
            }
            catch(Exception e){
                nTxtField.setBackground(Color.cyan);
                err = err + "-Error: Value " + nTxtField.getText() + " is not "
                        + "a valid voter population size. Enter a valid "
                        + "integer (max 1000)." + eol;
            }
            
            try{
                int x = Integer.parseInt(mTxtField.getText());
                if (x < 1 || x > 1000){
                    throw (new Exception());
                }
                m = x;
            }
            catch(Exception e){
                mTxtField.setBackground(Color.cyan);
                err = err + "-Error: Value " + mTxtField.getText() + " is not "
                        + "a valid candidate population size. Enter a valid "
                        + "integer (max 1000)." + eol;
            }
            
            try{
                int x = Integer.parseInt(kTxtField.getText());
                if (x < 1 || x > 100 || x > m){
                    throw (new Exception());
                }
                k = x;
            }
            catch(Exception e){
                kTxtField.setBackground(Color.cyan);
                err = err + "-Error: Value " + kTxtField.getText() + " is not "
                        + "a valid committee size. Maximum size is the minimum "
                        + "between 100 and the candidate population." + eol;
            }
            
            try{
                int x = Integer.parseInt(xLimitTxtField.getText());
                if (x < 1 || x > 100){
                    throw (new Exception());
                }
                xLimit = x;
            }
            catch(Exception e){
                xLimitTxtField.setBackground(Color.cyan);
                err = err + "-Error: Maximum x-Axis value goes up to 100." 
                        + eol;
            }
            
            try{
                int x = Integer.parseInt(yLimitTxtField.getText());
                if (x < 1 || x > 100){
                    throw (new Exception());
                }
                yLimit = x;
            }
            catch(Exception e){
                yLimitTxtField.setBackground(Color.cyan);
                err = err + "-Error: Maximum y-Axis value goes up to 100." 
                        + eol;
            }
            
            try{
                int x = Integer.parseInt(nClusterTxtField.getText());
                if (x < 1 || x > 20){
                    throw (new Exception());
                }
                nClusters = x;
            }
            catch(Exception e){
                nClusterTxtField.setBackground(Color.cyan);
                err = err + "-Error: Maximum number of voter clusters is 20." 
                        + eol;
            }
            
            try{
                int x = Integer.parseInt(mClusterTxtField.getText());
                if (x < 1 || x > 20){
                    throw (new Exception());
                }
                mClusters = x;
            }
            catch(Exception e){
                mClusterTxtField.setBackground(Color.cyan);
                err = err + "-Error: Maximum number of candidate clusters "
                        + "is 20." + eol;
            }
            
            if (err != ""){
                systemTxt.append(err);
            }
            else {
                nTxtField.setBackground(Color.white);
                mTxtField.setBackground(Color.white);
                kTxtField.setBackground(Color.white);
                xLimitTxtField.setBackground(Color.white);
                yLimitTxtField.setBackground(Color.white);
                nClusterTxtField.setBackground(Color.white);
                mClusterTxtField.setBackground(Color.white);
                
                ArrayList<Voter> voters = new ArrayList();
                ArrayList<Candidate> candidates = new ArrayList();

                int tempN = n;
                int tempM = m;

                boolean finalCluster = false;
                boolean cancelled = false;
                String card = "square";
                
                for(int i = 0; i < nClusters; i++){
                    String title = "Voter Cluster " + (i+1) + "/" + nClusters;
                    String footnote = "Voters remaining: " + tempN;
                    if (i+1 == nClusters){
                        finalCluster = true;
                    }
                    DistributionDialog dd = new DistributionDialog(this, true, 
                            tempN, xLimit, yLimit, Person.personType.VOTER, 
                            title, footnote, finalCluster, card);
                    
                    dd.setVisible(true);
                    if (dd.isCancelled()){
                        cancelled = true;
                        break;
                    }
                    tempN = tempN - dd.getClusterSize();
                    voters.addAll((ArrayList<Voter>)
                            (ArrayList<?>)dd.getIndividuals());
                    
                    card = dd.getCard();
                }  

                finalCluster = false;
                if (!cancelled){
                    for(int i = 0; i < mClusters; i++){
                        String title = "Candidate Cluster " + (i+1) + "/" 
                                + mClusters;
                        
                        String footnote = "Candidates remaining: " + tempM;
                        if (i+1 == mClusters){
                            finalCluster = true;
                        }
                        DistributionDialog dd = new DistributionDialog(this, 
                                true, tempM, xLimit, yLimit, 
                                Person.personType.CANDIDATE, title, footnote, 
                                finalCluster, card);
                        
                        dd.setVisible(true);
                        if (dd.isCancelled()){
                            cancelled = true;
                            break;
                        }
                        tempM = tempM - dd.getClusterSize();
                        candidates.addAll((ArrayList<Candidate>)
                                (ArrayList<?>)dd.getIndividuals());
                        
                        card = dd.getCard();
                    }  
                }

                if (!cancelled){
                    for(int i = 0; i < voters.size(); i++){
                        voters.get(i).setName("v" + i);
                    }
                    
                    for(int i = 0; i < candidates.size(); i++){
                        candidates.get(i).setName("c" + i);
                    }
                    
                    election2D = new Election(k, voters, candidates, true);
                    clearGraphPanels();
                    plotResultsBtn.setEnabled(true);
                    saveElectionBtn.setEnabled(true);
                    consistencyBtn.setEnabled(false);
                    systemTxt.append("-New election created." + eol);
                    saved = false;
                } else {
                    systemTxt.append("-Election creation cancelled." + eol);
                }
            } 
        }
    }//GEN-LAST:event_createElectionBtnActionPerformed

    private void plotResultsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotResultsBtnActionPerformed
        if(!generalPreferencesCheckBox.isSelected()){
            clearGraphPanels();
            systemTxt.append("-Generating results and graphing scatter plots." 
                    + eol);
            
            committeeSNTV = election2D.singleNonTransferableVote();
            committeeBorda = election2D.kBorda();
            committeeBloc = election2D.bloc();
            committeeSTV = election2D.singleTransferableVote();
            committeeGCC = election2D.greedyCC();
            committeeGM = election2D.greedyMonroe();
            committeeKM = election2D.kMeans();
            
            consistencyBtn.setEnabled(true);
            
            ChartPanel chartSNTV = ChartPanelMaker.
                    createChart(election2D.getVoters(), 
                            election2D.getCandidates(), committeeSNTV, "SNTV");
            plotAreaSNTV.setLayout(new java.awt.BorderLayout());
            plotAreaSNTV.add(chartSNTV,BorderLayout.CENTER);
            plotAreaSNTV.validate();

            ChartPanel chartBorda = ChartPanelMaker.
                    createChart(election2D.getVoters(), 
                            election2D.getCandidates(), committeeBorda, 
                            "k-Borda");
            plotAreaBorda.setLayout(new java.awt.BorderLayout());
            plotAreaBorda.add(chartBorda,BorderLayout.CENTER);
            plotAreaBorda.validate();

            ChartPanel chartBloc = ChartPanelMaker.
                    createChart(election2D.getVoters(), 
                            election2D.getCandidates(), committeeBloc, "Bloc");
            plotAreaBloc.setLayout(new java.awt.BorderLayout());
            plotAreaBloc.add(chartBloc,BorderLayout.CENTER);
            plotAreaBloc.validate();

            ChartPanel chartSTV = ChartPanelMaker.
                    createChart(election2D.getVoters(), 
                            election2D.getCandidates(), committeeSTV, "STV");
            plotAreaSTV.setLayout(new java.awt.BorderLayout());
            plotAreaSTV.add(chartSTV,BorderLayout.CENTER);
            plotAreaSTV.validate();

            ChartPanel chartGCC = ChartPanelMaker.
                    createChart(election2D.getVoters(), 
                            election2D.getCandidates(), committeeGCC, 
                            "Greedy-CC");
            plotAreaGCC.setLayout(new java.awt.BorderLayout());
            plotAreaGCC.add(chartGCC,BorderLayout.CENTER);
            plotAreaGCC.validate();
            
            ChartPanel chartGM = ChartPanelMaker.
                    createChart(election2D.getVoters(), 
                            election2D.getCandidates(), committeeGM, 
                            "Greedy-Monroe");
            plotAreaGM.setLayout(new java.awt.BorderLayout());
            plotAreaGM.add(chartGM,BorderLayout.CENTER);
            plotAreaGM.validate();

            ChartPanel chartKM = ChartPanelMaker.
                    createChart(election2D.getVoters(), 
                            election2D.getCandidates(), committeeKM, "k-Means");
            plotAreaKM.setLayout(new java.awt.BorderLayout());
            plotAreaKM.add(chartKM,BorderLayout.CENTER);
            plotAreaKM.validate();

            //ProportionalityTest, calculating norms
            double[] vectorSNTV = election2D.getDistanceVector(committeeSNTV);
            systemTxt.append(NormCalculator.getNormText(vectorSNTV, "SNTV"));

            double[] vectorBorda = election2D.getDistanceVector(committeeBorda);
            systemTxt.append(NormCalculator.getNormText(vectorBorda,"k-Borda"));

            double[] vectorBloc = election2D.getDistanceVector(committeeBloc);
            systemTxt.append(NormCalculator.getNormText(vectorBloc, "Bloc"));

            double[] vectorSTV = election2D.getDistanceVector(committeeSTV);
            systemTxt.append(NormCalculator.getNormText(vectorSTV, "STV"));

            double[] vectorGCC = election2D.getDistanceVector(committeeGCC);
            systemTxt.append(NormCalculator.getNormText(vectorGCC,"Greedy-CC"));

            double[] vectorGM = election2D.getDistanceVector(committeeGM);
            systemTxt.append(NormCalculator.getNormText(vectorGM, 
                    "Greedy-Monroe"));

            double[] vectorKM = election2D.getDistanceVector(committeeKM);
            systemTxt.append(NormCalculator.getNormText(vectorKM, "k-Means") 
                    + eol);
            
            systemTxt.append("----------------------------------------" + eol);
        }
        else {
            kTxtField.setBackground(Color.white);
            clearGraphPanels();
            String err = "";
            m = electionGP.getNumberOfCandidates();
            
            try{
                int x = Integer.parseInt(kTxtField.getText());
                if (x < 1 || x > 100 || x > m){
                    throw (new Exception());
                }
                k = x;
                electionGP.setCommitteeSize(k);
            }
            catch(Exception e){
                kTxtField.setBackground(Color.cyan);
                err = "-Error: Value " + kTxtField.getText() + " is not a "
                        + "valid committee size. Maximum size is the minimum "
                        + "between 100 and the candidate population." + eol;
            }
            
            if(err == ""){
                committeeSNTV = electionGP.singleNonTransferableVote();
                committeeBorda = electionGP.kBorda();
                committeeBloc = electionGP.bloc();
                committeeSTV = electionGP.singleTransferableVote();
                committeeGCC = electionGP.greedyCC();
                committeeGM = electionGP.greedyMonroe();
                
                consistencyBtn.setEnabled(true);

                systemTxt.append(eol + "SNTV Winning Committee:" + eol);
                for (Candidate c: committeeSNTV){
                    systemTxt.append("        " + c.getName() + eol);
                }

                systemTxt.append(eol + "k-Borda Winning Committee:" + eol);
                for (Candidate c: committeeBorda){
                    systemTxt.append("        " + c.getName() + eol);
                }

                systemTxt.append(eol + "Bloc Winning Committee:" + eol);
                for (Candidate c: committeeBloc){
                    systemTxt.append("        " + c.getName() + eol);
                }

                systemTxt.append(eol + "STV Winning Committee:" + eol);
                for (Candidate c: committeeSTV){
                    systemTxt.append("        " + c.getName() + eol);
                }

                systemTxt.append(eol + "Greedy-CC Winning Committee:" + eol);
                for (Candidate c: committeeGCC){
                    systemTxt.append("        " + c.getName() + eol);
                }

                systemTxt.append(eol + "Greedy-Monroe Winning Committee:" 
                        + eol);
                for (Candidate c: committeeGM){
                    systemTxt.append("        " + c.getName() + eol);
                }
                
                systemTxt.append(eol + "-----------------------------" + eol 
                        + eol);
            }
            else{
                systemTxt.append(err);
                systemTxt.append("-Calculating winning committees cancelled. "
                        + "Please choose a new committee size and try again.");
            }
            
            //ProportionalityTest, calculating norms
            double[] vectorSNTV = electionGP.getDistanceVector(committeeSNTV);
            systemTxt.append(NormCalculator.getNormText(vectorSNTV, "SNTV"));

            double[] vectorBorda = electionGP.getDistanceVector(committeeBorda);
            systemTxt.append(NormCalculator.getNormText(vectorBorda,"k-Borda"));

            double[] vectorBloc = electionGP.getDistanceVector(committeeBloc);
            systemTxt.append(NormCalculator.getNormText(vectorBloc, "Bloc"));

            double[] vectorSTV = electionGP.getDistanceVector(committeeSTV);
            systemTxt.append(NormCalculator.getNormText(vectorSTV, "STV"));

            double[] vectorGCC = electionGP.getDistanceVector(committeeGCC);
            systemTxt.append(NormCalculator.getNormText(vectorGCC,"Greedy-CC"));

            double[] vectorGM = electionGP.getDistanceVector(committeeGM);
            systemTxt.append(NormCalculator.getNormText(vectorGM, 
                    "Greedy-Monroe"));

            
            systemTxt.append("----------------------------------------" + eol);
        }
    }//GEN-LAST:event_plotResultsBtnActionPerformed

    private void saveElectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveElectionBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setApproveButtonText("Save");
        fileChooser.setCurrentDirectory(folder);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            folder = fileChooser.getCurrentDirectory();
            File selectedFile = fileChooser.getSelectedFile();
            Store2dElection store = new Store2dElection(this, selectedFile);
            store.writeToFile();
            systemTxt.append("-Election saved successfully." + eol);
            saved = true;
        } else if (result == JFileChooser.CANCEL_OPTION){
            systemTxt.append("-Saving cancelled" + eol);
        }
    }//GEN-LAST:event_saveElectionBtnActionPerformed

    private void loadElectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadElectionBtnActionPerformed
        if(!generalPreferencesCheckBox.isSelected()){
            //Confirmation of discarding an election2D that is not saved
            boolean discard = true;
            if(election2D != null && !saved){
                int response = JOptionPane.showConfirmDialog(null, "Current "
                        + "election is not saved, are you sure you want to load "
                        + "an election?" + eol + "Press \"No\" to save current "
                                + "election in a file.", "Confirm", 
                                JOptionPane.YES_NO_OPTION, 
                                JOptionPane.QUESTION_MESSAGE);
                
                if (response == JOptionPane.NO_OPTION) {
                    discard = false;
                }
            }

            if (discard){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(folder);
                int result = fileChooser.showOpenDialog(this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    folder = fileChooser.getCurrentDirectory();
                    File selectedFile = fileChooser.getSelectedFile();
                    Parse2dElection parser = new Parse2dElection();
                    parser.parseFromFile(selectedFile);
                    if(parser.getErr() == null){
                        election2D = parser.getElection();
                        nTxtField.setText(String.valueOf(election2D.
                                getNumberOfVoters()));
                        mTxtField.setText(String.valueOf(election2D.
                                getNumberOfCandidates()));
                        kTxtField.setText(String.valueOf(election2D.
                                getCommitteeSize()));
                        xLimit = parser.getxLimit();
                        xLimitTxtField.setText(String.valueOf(xLimit));
                        yLimit = parser.getyLimit();
                        yLimitTxtField.setText(String.valueOf(yLimit));
                        nClusters = parser.getnClusters();
                        nClusterTxtField.setText(String.valueOf(nClusters));
                        mClusters = parser.getmClusters();
                        mClusterTxtField.setText(String.valueOf(mClusters));

                        systemTxt.append("-Election loaded." + eol);
                        plotResultsBtn.setEnabled(true);
                        saveElectionBtn.setEnabled(true);
                        consistencyBtn.setEnabled(false);
                        saved = true;
                    } else {
                        systemTxt.append(parser.getErr() + eol);
                    }
                } else if (result == JFileChooser.CANCEL_OPTION){
                    systemTxt.append("-Loading cancelled." + eol);
                }
            }
        }
        else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(folder);
            int result = fileChooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                folder = fileChooser.getCurrentDirectory();
                File selectedFile = fileChooser.getSelectedFile();
                ParseGeneralElection parser = new ParseGeneralElection();
                parser.parseFromFile(selectedFile);

                if(parser.getErr() == null){
                    ArrayList<Voter> voters = parser.getVoters();
                    ArrayList<Candidate> candidates = parser.getCandidates();
                    n = voters.size();
                    m = candidates.size();
                    try{
                        int x = Integer.parseInt(kTxtField.getText());
                        if (x < 1 || x > 100 || x > m){
                            throw (new Exception());
                        }
                        k = x;
                    }
                    catch(Exception e){
                        kTxtField.setBackground(Color.cyan);
                        kTxtField.setText("1");
                        k = 1;
                        systemTxt.append("-Committee size was invalid. It has "
                                + "been set equal to 1." + eol);
                    }
                    
                    electionGP = new Election(k,voters,candidates,false);
                    plotResultsBtn.setEnabled(true);
                    consistencyBtn.setEnabled(false);
                    systemTxt.append("-Election " + selectedFile.getName() 
                            + " has been loaded successfully." + eol);
                }
                else {
                    systemTxt.append(parser.getErr() + eol);
                }
            } else if (result == JFileChooser.CANCEL_OPTION){
                systemTxt.append("-Loading cancelled." + eol);
            }
        }
    }//GEN-LAST:event_loadElectionBtnActionPerformed

    private void nTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nTxtFieldFocusGained
        nTxtField.selectAll();
    }//GEN-LAST:event_nTxtFieldFocusGained

    private void mTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mTxtFieldFocusGained
        mTxtField.selectAll();
    }//GEN-LAST:event_mTxtFieldFocusGained

    private void kTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kTxtFieldFocusGained
        kTxtField.selectAll();
    }//GEN-LAST:event_kTxtFieldFocusGained

    private void xLimitTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xLimitTxtFieldFocusGained
        xLimitTxtField.selectAll();
    }//GEN-LAST:event_xLimitTxtFieldFocusGained

    private void yLimitTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yLimitTxtFieldFocusGained
        yLimitTxtField.selectAll();
    }//GEN-LAST:event_yLimitTxtFieldFocusGained

    private void nClusterTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nClusterTxtFieldFocusGained
        nClusterTxtField.selectAll();
    }//GEN-LAST:event_nClusterTxtFieldFocusGained

    private void mClusterTxtFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mClusterTxtFieldFocusGained
        mClusterTxtField.selectAll();
    }//GEN-LAST:event_mClusterTxtFieldFocusGained

    private void generalPreferencesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalPreferencesCheckBoxActionPerformed
        if(generalPreferencesCheckBox.isSelected()){
            nTxtField.setEnabled(false);
            mTxtField.setEnabled(false);
            xLimitTxtField.setEnabled(false);
            yLimitTxtField.setEnabled(false);
            nClusterTxtField.setEnabled(false);
            mClusterTxtField.setEnabled(false);
            createElectionBtn.setEnabled(false);
            saveElectionBtn.setEnabled(false);
            plotResultsBtn.setText("Calculate Results");
            
            GridBagConstraints gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 3;
            gbc.gridheight = 2;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(systemPanel, gbc);
            
            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(plotAreaSNTV, gbc);
            
            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(plotAreaBorda, gbc);
            
            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 3;
            gbc.gridy = 0;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(plotAreaBloc, gbc);
        }
        else {
            nTxtField.setEnabled(true);
            mTxtField.setEnabled(true);
            xLimitTxtField.setEnabled(true);
            yLimitTxtField.setEnabled(true);
            nClusterTxtField.setEnabled(true);
            mClusterTxtField.setEnabled(true);
            createElectionBtn.setEnabled(true);
            saveElectionBtn.setEnabled(true);
            plotResultsBtn.setText("Plot Results");
            
            GridBagConstraints gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 3;
            gbc.gridheight = 1;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(systemPanel, gbc);
            
            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(plotAreaSNTV, gbc);
            
            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(plotAreaBorda, gbc);
            
            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 3;
            gbc.gridy = 1;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            getContentPane().add(plotAreaBloc, gbc);
        }
    }//GEN-LAST:event_generalPreferencesCheckBoxActionPerformed

    private void consistencyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consistencyBtnActionPerformed
        Election doubleElection = null;
        Election election = election2D;
        boolean is2D = true;
        ArrayList<Voter> doubleVoters = new ArrayList(2*n);
        ArrayList<Candidate> candidatesCopy = new ArrayList(m);
        
        if(generalPreferencesCheckBox.isSelected()){
            election = electionGP;
            is2D = false;
        }
        
        ArrayList<Voter> voters = election.getVoters();

        for(Voter v: voters){
            doubleVoters.add(new Voter(v));
            doubleVoters.add(new Voter(v));
        }

        for(Candidate c: election.getCandidates()){
            candidatesCopy.add(new Candidate(c));
        }

        doubleElection = new Election(election.getCommitteeSize(), 
                doubleVoters, candidatesCopy, is2D);
        
        ArrayList<Candidate> committeeSNTV2 = 
                doubleElection.singleNonTransferableVote();
        int possibleTie = n;
        boolean consistent = true;
        
        for(Candidate c: committeeSNTV2){
            if(c.getPluralityScore() < possibleTie){
                possibleTie = c.getPluralityScore();
            }
        }
        
        for(Candidate c: committeeSNTV2){
            if(!c.isContainedIn(committeeSNTV) 
                    && (c.getPluralityScore() > possibleTie)){
                consistent = false;
                systemTxt.append("-Single Non Transferable Vote is NOT "
                        + "homogeneous." + eol);
                break;
            }
        }
        
        if(consistent){
            systemTxt.append("-Single Non Transferable Vote is homogeneous "
                    + "in this example." + eol);
        }
        
        
        ArrayList<Candidate> committeeBorda2 = doubleElection.kBorda();
        possibleTie = m*n;
        consistent = true;
        
        for(Candidate c: committeeBorda2){
            if(c.getBordaScore() < possibleTie){
                possibleTie = c.getBordaScore();
            }
        }
        
        for(Candidate c: committeeBorda2){
            if(!c.isContainedIn(committeeBorda) 
                    && (c.getBordaScore() > possibleTie)){
                consistent = false;
                systemTxt.append("-k-Borda rule is NOT homogeneous." + eol);
                break;
            }
        }
        
        if(consistent){
            systemTxt.append("-k-Borda rule is homogeneous in this example." 
                    + eol);
        }
        
        
        ArrayList<Candidate> committeeBloc2 = doubleElection.bloc();
        possibleTie = n;
        consistent = true;
        
        for(Candidate c: committeeBloc2){
            if(c.getBlocScore() < possibleTie){
                possibleTie = c.getBlocScore();
            }
        }
        
        for(Candidate c: committeeBloc2){
            if(!c.isContainedIn(committeeBloc) 
                    && (c.getBlocScore() > possibleTie)){
                consistent = false;
                systemTxt.append("-Bloc rule is NOT homogeneous." + eol);
                break;
            }
        }
        
        if(consistent){
            systemTxt.append("-Bloc rule is homogeneous in this example." 
                    + eol);
        }
        
        
        ArrayList<Candidate> committeeSTV2 = 
                doubleElection.singleTransferableVote();
        consistent = true;
       
        for(Candidate c: committeeSTV2){
            if(!c.isContainedIn(committeeSTV)){
                consistent = false;
                systemTxt.append("-Single Transferable Vote is NOT "
                        + "homogeneous." + eol);
                break;
            }
        }
        
        if(consistent){
            systemTxt.append("-Single Transferable Vote is homogeneous in "
                    + "this example." + eol);
        }
        
        
        ArrayList<Candidate> committeeGCC2 = doubleElection.greedyCC();
        consistent = true;
       
        for(Candidate c: committeeGCC2){
            if(!c.isContainedIn(committeeGCC)){
                if(2*election.bordaSatisfaction(committeeGCC) != 
                        doubleElection.bordaSatisfaction(committeeGCC2)){
                    consistent = false;
                    systemTxt.append("-Greedy Chamberlin-Courant rule is "
                            + "homogeneous but the program does not keep tied "
                            + "outcomes to prove it." + eol);
                    break;
                }
            }
        }
        
        if(consistent){
            systemTxt.append("-Greedy Chamberlin-Courant rule is homogeneous "
                    + "in this example." + eol);
        }
        
        
        ArrayList<Candidate> committeeGM2 = doubleElection.greedyMonroe();
        consistent = true;
       
        for(Candidate c: committeeGM2){
            if(!c.isContainedIn(committeeGM)){
                consistent = false;
                systemTxt.append("-Greedy Monroe rule is NOT homogeneous." 
                        + eol);
                break;
            }
        }
        
        if(consistent){
            systemTxt.append("-Greedy Monroe rule is homogeneous in this "
                    + "example." + eol);
        }
        
        
        if(!generalPreferencesCheckBox.isSelected()){
            ArrayList<Candidate> committeeKM2 = doubleElection.kMeans();
            consistent = true;

            for(Candidate c: committeeKM2){
                if(!c.isContainedIn(committeeKM)){
                    consistent = false;
                    systemTxt.append("-k-Means algorithm is NOT homogeneous." 
                            + eol);
                    break;
                }
            }

            if(consistent){
                systemTxt.append("-k-Means algorithm is homogeneous in this "
                        + "example." + eol);
            }
        }
        
        systemTxt.append("-------------------------------------------" + eol);
    }//GEN-LAST:event_consistencyBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ElectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElectionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consistencyBtn;
    private javax.swing.JButton createElectionBtn;
    private javax.swing.JCheckBox generalPreferencesCheckBox;
    private javax.swing.JLabel kLabel;
    private javax.swing.JTextField kTxtField;
    private javax.swing.JButton loadElectionBtn;
    private javax.swing.JLabel mClusterLabel;
    private javax.swing.JLabel mClusterTitle;
    private javax.swing.JTextField mClusterTxtField;
    private javax.swing.JLabel mLabel;
    private javax.swing.JTextField mTxtField;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel nClusterLabel;
    private javax.swing.JLabel nClusterTitle;
    private javax.swing.JTextField nClusterTxtField;
    private javax.swing.JLabel nLabel;
    private javax.swing.JTextField nTxtField;
    private javax.swing.JPanel plotAreaBloc;
    private javax.swing.JPanel plotAreaBorda;
    private javax.swing.JPanel plotAreaGCC;
    private javax.swing.JPanel plotAreaGM;
    private javax.swing.JPanel plotAreaKM;
    private javax.swing.JPanel plotAreaSNTV;
    private javax.swing.JPanel plotAreaSTV;
    private javax.swing.JButton plotResultsBtn;
    private javax.swing.JButton saveElectionBtn;
    private javax.swing.JScrollPane systemPane;
    private javax.swing.JPanel systemPanel;
    private javax.swing.JTextArea systemTxt;
    private javax.swing.JLabel xLimitLabel;
    private javax.swing.JTextField xLimitTxtField;
    private javax.swing.JLabel yLimitLabel;
    private javax.swing.JTextField yLimitTxtField;
    // End of variables declaration//GEN-END:variables
}
