
import javax.swing.JOptionPane;


public class ElectionGUI2 extends javax.swing.JFrame {

    private Election election;
    private int n = 300;
    private int nClusters = 1;
    private int m = 100;
    private int mClusters = 1;
    private int k = 10;
    
    /**
     * Creates new form ElectionGUI2
     */
    public ElectionGUI2() {
        initComponents();
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
        plotAreaSNTV = new javax.swing.JPanel();
        plotAreaBorda = new javax.swing.JPanel();
        plotAreaBloc = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {300, 300, 300, 300};
        layout.rowHeights = new int[] {300, 300, 80};
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
        gridBagConstraints.gridx = 0;
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaKM, gridBagConstraints);

        menuPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuPanel.setMaximumSize(new java.awt.Dimension(300, 380));
        menuPanel.setMinimumSize(new java.awt.Dimension(300, 380));
        menuPanel.setPreferredSize(new java.awt.Dimension(300, 380));
        java.awt.GridBagLayout menuPanelLayout = new java.awt.GridBagLayout();
        menuPanelLayout.columnWidths = new int[] {50, 50, 50, 50, 50, 50};
        menuPanelLayout.rowHeights = new int[] {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
        menuPanel.setLayout(menuPanelLayout);

        mainTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("Create a Committee Election");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mainTitle, gridBagConstraints);

        nLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nLabel.setText("Number of Voters:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nLabel, gridBagConstraints);

        mLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mLabel.setText("Number of Candidates:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mLabel, gridBagConstraints);

        kLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        kLabel.setText("Committee Size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(kLabel, gridBagConstraints);

        nTxtField.setText("300");
        nTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nTxtFieldFocusLost(evt);
            }
        });
        nTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nTxtField, gridBagConstraints);

        mTxtField.setText("100");
        mTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mTxtFieldFocusLost(evt);
            }
        });
        mTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mTxtField, gridBagConstraints);

        kTxtField.setText("10");
        kTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                kTxtFieldFocusLost(evt);
            }
        });
        kTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(kTxtField, gridBagConstraints);

        nClusterTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nClusterTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nClusterTitle.setText("Voter Distribution");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nClusterTitle, gridBagConstraints);

        nClusterLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nClusterLabel.setText("Number of Voter Clusters:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nClusterLabel, gridBagConstraints);

        nClusterTxtField.setText("1");
        nClusterTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nClusterTxtFieldFocusLost(evt);
            }
        });
        nClusterTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nClusterTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(nClusterTxtField, gridBagConstraints);

        mClusterTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mClusterTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mClusterTitle.setText("Candidate Distribution");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mClusterTitle, gridBagConstraints);

        mClusterLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mClusterLabel.setText("Number of Candidate Clusters:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mClusterLabel, gridBagConstraints);

        mClusterTxtField.setText("1");
        mClusterTxtField.setMaximumSize(new java.awt.Dimension(50, 20));
        mClusterTxtField.setMinimumSize(new java.awt.Dimension(50, 20));
        mClusterTxtField.setPreferredSize(new java.awt.Dimension(50, 20));
        mClusterTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mClusterTxtFieldFocusLost(evt);
            }
        });
        mClusterTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClusterTxtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(mClusterTxtField, gridBagConstraints);

        createElectionBtn.setText("Create Election");
        createElectionBtn.setMaximumSize(new java.awt.Dimension(110, 23));
        createElectionBtn.setMinimumSize(new java.awt.Dimension(110, 23));
        createElectionBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        menuPanel.add(createElectionBtn, gridBagConstraints);

        saveElectionBtn.setText("Save Election");
        saveElectionBtn.setMaximumSize(new java.awt.Dimension(110, 23));
        saveElectionBtn.setMinimumSize(new java.awt.Dimension(110, 23));
        saveElectionBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        menuPanel.add(loadElectionBtn, gridBagConstraints);

        plotResultsBtn.setText("Plot Results");
        plotResultsBtn.setMaximumSize(new java.awt.Dimension(110, 23));
        plotResultsBtn.setMinimumSize(new java.awt.Dimension(110, 23));
        plotResultsBtn.setPreferredSize(new java.awt.Dimension(110, 23));
        plotResultsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotResultsBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        menuPanel.add(plotResultsBtn, gridBagConstraints);

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
        gridBagConstraints.gridy = 0;
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
        gridBagConstraints.gridy = 0;
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
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(plotAreaBloc, gridBagConstraints);

        titlePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(titlePanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plotResultsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotResultsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotResultsBtnActionPerformed

    private void loadElectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadElectionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadElectionBtnActionPerformed

    private void nTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nTxtFieldActionPerformed
        try{
            n = Integer.parseInt(nTxtField.getText());
            if (n < 1 || n > 1000){
                throw (new Exception());
            }
        }
        catch(Exception e){
            nTxtField.setText("300");
            n = 300;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 1000)");
        }
    }//GEN-LAST:event_nTxtFieldActionPerformed

    private void nTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nTxtFieldFocusLost
        try{
            n = Integer.parseInt(nTxtField.getText());
            if (n < 1 || n > 1000){
                throw (new Exception());
            }
        }
        catch(Exception e){
            nTxtField.setText("300");
            n = 300;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 1000)");
        }
    }//GEN-LAST:event_nTxtFieldFocusLost

    private void mTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTxtFieldActionPerformed
        try{
            m = Integer.parseInt(mTxtField.getText());
            if (m < 1 || m > 1000){
                throw (new Exception());
            }
        }
        catch(Exception e){
            mTxtField.setText("100");
            m = 100;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 1000)");
        }
    }//GEN-LAST:event_mTxtFieldActionPerformed

    private void mTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mTxtFieldFocusLost
        try{
            m = Integer.parseInt(mTxtField.getText());
            if (m < 1 || m > 1000){
                throw (new Exception());
            }
        }
        catch(Exception e){
            mTxtField.setText("100");
            m = 100;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 1000)");
        }
    }//GEN-LAST:event_mTxtFieldFocusLost

    private void kTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kTxtFieldActionPerformed
        try{
            k = Integer.parseInt(kTxtField.getText());
            if (k < 1 || k > 100){
                throw (new Exception());
            }
        }
        catch(Exception e){
            kTxtField.setText("10");
            k = 10;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 100)");
        }
    }//GEN-LAST:event_kTxtFieldActionPerformed

    private void kTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kTxtFieldFocusLost
        try{
            k = Integer.parseInt(kTxtField.getText());
            if (k < 1 || k > 100){
                throw (new Exception());
            }
        }
        catch(Exception e){
            kTxtField.setText("10");
            k = 10;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 100)");
        }
    }//GEN-LAST:event_kTxtFieldFocusLost

    private void nClusterTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nClusterTxtFieldActionPerformed
        try{
            nClusters = Integer.parseInt(nClusterTxtField.getText());
            if (nClusters < 1 || nClusters > 20){
                throw (new Exception());
            }
        }
        catch(Exception e){
            nClusterTxtField.setText("1");
            nClusters = 1;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 20)");
        }
    }//GEN-LAST:event_nClusterTxtFieldActionPerformed

    private void nClusterTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nClusterTxtFieldFocusLost
        try{
            nClusters = Integer.parseInt(nClusterTxtField.getText());
            if (nClusters < 1 || nClusters > 20){
                throw (new Exception());
            }
        }
        catch(Exception e){
            nClusterTxtField.setText("1");
            nClusters = 1;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 20)");
        }
    }//GEN-LAST:event_nClusterTxtFieldFocusLost

    private void mClusterTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClusterTxtFieldActionPerformed
        try{
            mClusters = Integer.parseInt(mClusterTxtField.getText());
            if (mClusters < 1 || mClusters > 20){
                throw (new Exception());
            }
        }
        catch(Exception e){
            mClusterTxtField.setText("1");
            mClusters = 1;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 20)");
        }
    }//GEN-LAST:event_mClusterTxtFieldActionPerformed

    private void mClusterTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mClusterTxtFieldFocusLost
        try{
            mClusters = Integer.parseInt(mClusterTxtField.getText());
            if (mClusters < 1 || mClusters > 20){
                throw (new Exception());
            }
        }
        catch(Exception e){
            mClusterTxtField.setText("1");
            mClusters = 1;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 1 to 20)");
        }
    }//GEN-LAST:event_mClusterTxtFieldFocusLost

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
            java.util.logging.Logger.getLogger(ElectionGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElectionGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElectionGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElectionGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElectionGUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createElectionBtn;
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
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
