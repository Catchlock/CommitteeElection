
import java.awt.CardLayout;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tourist
 */
public class DistributionDialog extends javax.swing.JDialog {
    private Frame parentFrame;
    private int total;
    private int xLimit;
    private int yLimit;
    private String role;
    private ArrayList<Person> individuals;
    private int clusterSize = 0;

    /**
     * Creates new form VoterDistDialog
     */
    public DistributionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DistributionDialog(java.awt.Frame parent, boolean modal, int total, int xLimit, int yLimit, Person.personType pt) {
        super(parent, modal);
        initComponents();
        parentFrame = parent;
        this.total = total;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
        if (pt == Person.personType.VOTER){
            role = "Voters";
        }
        else if (pt == Person.personType.CANDIDATE){
            role = "Candidates";
        }
        individuals = new ArrayList();
    }
    
    public void setTotal(int total){
        this.total = total;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setXLimit(int xLimit){
        this.xLimit = xLimit;
    }
    
    public int getXLimit(){
        return xLimit;
    }
    
    public void setYLimit(int yLimit){
        this.yLimit = yLimit;
    }
    
    public int getYLimit(){
        return yLimit;
    }
    
    public void setIndividuals(ArrayList<Person> individuals){
        this.individuals = individuals;
    }
    
    public ArrayList<Person> getIndividuals(){
        return individuals;
    }
    
    public void setClusterSize(int clusterSize){
        this.clusterSize = clusterSize;
    }
    
    public int getClusterSize(){
        return clusterSize;
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

        distributionType = new javax.swing.ButtonGroup();
        uniformShape = new javax.swing.ButtonGroup();
        headClusterPanel = new javax.swing.JPanel();
        clusterTitle = new javax.swing.JLabel();
        clusterTypeLabel = new javax.swing.JLabel();
        uniformRadioBtn = new javax.swing.JRadioButton();
        gaussianRadioBtn = new javax.swing.JRadioButton();
        remainingLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        bodyClusterPanel = new javax.swing.JPanel();
        uniformPanel = new javax.swing.JPanel();
        headUniformPanel = new javax.swing.JPanel();
        uniformShapeLabel = new javax.swing.JLabel();
        squareRadioBtn = new javax.swing.JRadioButton();
        DiscRadioBtn = new javax.swing.JRadioButton();
        RingRadioBtn = new javax.swing.JRadioButton();
        bodyUniformPanel = new javax.swing.JPanel();
        squarePanel = new javax.swing.JPanel();
        squareClusterSizeLabel = new javax.swing.JLabel();
        squareClusterSizeTxt = new javax.swing.JTextField();
        squareClusterCenterXLabel = new javax.swing.JLabel();
        squareClusterCenterXTxt = new javax.swing.JTextField();
        squareClusterCenterYLabel = new javax.swing.JLabel();
        squareClusterCenterYTxt = new javax.swing.JTextField();
        squareClusterWidthLabel = new javax.swing.JLabel();
        squareClusterWidthTxt = new javax.swing.JTextField();
        squareClusterHeightLabel = new javax.swing.JLabel();
        squareClusterHeightTxt = new javax.swing.JTextField();
        squareExampleImg = new javax.swing.JLabel();
        squareSubmitPanel = new javax.swing.JPanel();
        squareCancelBtn = new javax.swing.JButton();
        squareSubmitBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        discPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ringPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        gaussianPanel = new javax.swing.JPanel();
        gaussClusterSizeLabel = new javax.swing.JLabel();
        gaussClusterSizeTxt = new javax.swing.JTextField();
        gaussClusterMeanXLabel = new javax.swing.JLabel();
        gaussClusterMeanXTxt = new javax.swing.JTextField();
        gaussClusterMeanYLabel = new javax.swing.JLabel();
        gaussClusterMeanYTxt = new javax.swing.JTextField();
        gaussClusterStdDevXLabel = new javax.swing.JLabel();
        gaussClusterStdDevXTxt = new javax.swing.JTextField();
        gaussClusterStdDevYLabel = new javax.swing.JLabel();
        gaussClusterStdDevYTxt = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        gaussExampleImg = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        squareSubmitPanel1 = new javax.swing.JPanel();
        squareCancelBtn1 = new javax.swing.JButton();
        squareSubmitBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(380, 700));
        setMinimumSize(new java.awt.Dimension(380, 700));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(380, 700));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        headClusterPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {280};
        jPanel1Layout.rowHeights = new int[] {30, 20, 20, 20, 20};
        headClusterPanel.setLayout(jPanel1Layout);

        clusterTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clusterTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clusterTitle.setText("Cluster 3/12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headClusterPanel.add(clusterTitle, gridBagConstraints);

        clusterTypeLabel.setText("Select distribution type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headClusterPanel.add(clusterTypeLabel, gridBagConstraints);

        distributionType.add(uniformRadioBtn);
        uniformRadioBtn.setSelected(true);
        uniformRadioBtn.setText("Uniform");
        uniformRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniformRadioBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        headClusterPanel.add(uniformRadioBtn, gridBagConstraints);

        distributionType.add(gaussianRadioBtn);
        gaussianRadioBtn.setText("Gaussian");
        gaussianRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaussianRadioBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        headClusterPanel.add(gaussianRadioBtn, gridBagConstraints);

        remainingLabel.setText(role + " remaining: " + total);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        headClusterPanel.add(remainingLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headClusterPanel.add(jSeparator1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headClusterPanel.add(jSeparator2, gridBagConstraints);

        getContentPane().add(headClusterPanel, java.awt.BorderLayout.PAGE_START);

        bodyClusterPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bodyClusterPanel.setLayout(new java.awt.CardLayout());

        uniformPanel.setLayout(new java.awt.BorderLayout());

        headUniformPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {90, 90, 90};
        jPanel3Layout.rowHeights = new int[] {30, 30};
        headUniformPanel.setLayout(jPanel3Layout);

        uniformShapeLabel.setText("Select the shape of the uniform distribution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headUniformPanel.add(uniformShapeLabel, gridBagConstraints);

        uniformShape.add(squareRadioBtn);
        squareRadioBtn.setSelected(true);
        squareRadioBtn.setText("Rectangle");
        squareRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareRadioBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headUniformPanel.add(squareRadioBtn, gridBagConstraints);

        uniformShape.add(DiscRadioBtn);
        DiscRadioBtn.setText("Disc");
        DiscRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscRadioBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headUniformPanel.add(DiscRadioBtn, gridBagConstraints);

        uniformShape.add(RingRadioBtn);
        RingRadioBtn.setText("Ring");
        RingRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RingRadioBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headUniformPanel.add(RingRadioBtn, gridBagConstraints);

        uniformPanel.add(headUniformPanel, java.awt.BorderLayout.PAGE_START);

        bodyUniformPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bodyUniformPanel.setLayout(new java.awt.CardLayout());

        java.awt.GridBagLayout squarePanelLayout = new java.awt.GridBagLayout();
        squarePanelLayout.columnWidths = new int[] {30, 190, 130, 30};
        squarePanelLayout.rowHeights = new int[] {5, 30, 30, 30, 30, 30, 10, 195, 5, 60};
        squarePanel.setLayout(squarePanelLayout);

        squareClusterSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        squareClusterSizeLabel.setText("Cluster Size (population): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(squareClusterSizeLabel, gridBagConstraints);

        squareClusterSizeTxt.setText("0");
        squareClusterSizeTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        squareClusterSizeTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        squareClusterSizeTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        squareClusterSizeTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                squareClusterSizeTxtFocusLost(evt);
            }
        });
        squareClusterSizeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareClusterSizeTxtActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        squarePanel.add(squareClusterSizeTxt, gridBagConstraints);

        squareClusterCenterXLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        squareClusterCenterXLabel.setText("Cluster xCenter: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(squareClusterCenterXLabel, gridBagConstraints);

        squareClusterCenterXTxt.setText("0");
        squareClusterCenterXTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        squareClusterCenterXTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        squareClusterCenterXTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        squareClusterCenterXTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareClusterCenterXTxtActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        squarePanel.add(squareClusterCenterXTxt, gridBagConstraints);

        squareClusterCenterYLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        squareClusterCenterYLabel.setText("Cluster yCenter: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(squareClusterCenterYLabel, gridBagConstraints);

        squareClusterCenterYTxt.setText("0");
        squareClusterCenterYTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        squareClusterCenterYTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        squareClusterCenterYTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        squarePanel.add(squareClusterCenterYTxt, gridBagConstraints);

        squareClusterWidthLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        squareClusterWidthLabel.setText("Cluster Width: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(squareClusterWidthLabel, gridBagConstraints);

        squareClusterWidthTxt.setText("1");
        squareClusterWidthTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        squareClusterWidthTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        squareClusterWidthTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        squarePanel.add(squareClusterWidthTxt, gridBagConstraints);

        squareClusterHeightLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        squareClusterHeightLabel.setText("Cluster Height: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(squareClusterHeightLabel, gridBagConstraints);

        squareClusterHeightTxt.setText("1");
        squareClusterHeightTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        squareClusterHeightTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        squareClusterHeightTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        squarePanel.add(squareClusterHeightTxt, gridBagConstraints);

        squareExampleImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        squareExampleImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/uniformSquare.PNG"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(squareExampleImg, gridBagConstraints);

        java.awt.GridBagLayout squareSubmitPanelLayout = new java.awt.GridBagLayout();
        squareSubmitPanelLayout.columnWidths = new int[] {120, 100, 100};
        squareSubmitPanelLayout.rowHeights = new int[] {5, 40};
        squareSubmitPanel.setLayout(squareSubmitPanelLayout);

        squareCancelBtn.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squareSubmitPanel.add(squareCancelBtn, gridBagConstraints);

        squareSubmitBtn.setText("Submit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squareSubmitPanel.add(squareSubmitBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(squareSubmitPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(jSeparator3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squarePanel.add(jSeparator4, gridBagConstraints);

        bodyUniformPanel.add(squarePanel, "squarePanel");

        jLabel1.setText("Disc Options Placeholder");

        javax.swing.GroupLayout discPanelLayout = new javax.swing.GroupLayout(discPanel);
        discPanel.setLayout(discPanelLayout);
        discPanelLayout.setHorizontalGroup(
            discPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discPanelLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        discPanelLayout.setVerticalGroup(
            discPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discPanelLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        bodyUniformPanel.add(discPanel, "discPanel");

        jLabel2.setText("Ring Options Placeholder");

        javax.swing.GroupLayout ringPanelLayout = new javax.swing.GroupLayout(ringPanel);
        ringPanel.setLayout(ringPanelLayout);
        ringPanelLayout.setHorizontalGroup(
            ringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ringPanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        ringPanelLayout.setVerticalGroup(
            ringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ringPanelLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        bodyUniformPanel.add(ringPanel, "ringPanel");

        uniformPanel.add(bodyUniformPanel, java.awt.BorderLayout.CENTER);

        bodyClusterPanel.add(uniformPanel, "uniformCard");

        java.awt.GridBagLayout gaussianPanelLayout = new java.awt.GridBagLayout();
        gaussianPanelLayout.columnWidths = new int[] {30, 190, 130, 30};
        gaussianPanelLayout.rowHeights = new int[] {35, 30, 30, 30, 30, 30, 40, 195, 5, 60};
        gaussianPanel.setLayout(gaussianPanelLayout);

        gaussClusterSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gaussClusterSizeLabel.setText("Cluster Size (population): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(gaussClusterSizeLabel, gridBagConstraints);

        gaussClusterSizeTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        gaussClusterSizeTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        gaussClusterSizeTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gaussianPanel.add(gaussClusterSizeTxt, gridBagConstraints);

        gaussClusterMeanXLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gaussClusterMeanXLabel.setText("Mean Value - x Axis: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(gaussClusterMeanXLabel, gridBagConstraints);

        gaussClusterMeanXTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        gaussClusterMeanXTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        gaussClusterMeanXTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gaussianPanel.add(gaussClusterMeanXTxt, gridBagConstraints);

        gaussClusterMeanYLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gaussClusterMeanYLabel.setText("Mean Value - y Axis: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(gaussClusterMeanYLabel, gridBagConstraints);

        gaussClusterMeanYTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        gaussClusterMeanYTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        gaussClusterMeanYTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gaussianPanel.add(gaussClusterMeanYTxt, gridBagConstraints);

        gaussClusterStdDevXLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gaussClusterStdDevXLabel.setText("Standard Deviation - x Axis: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(gaussClusterStdDevXLabel, gridBagConstraints);

        gaussClusterStdDevXTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        gaussClusterStdDevXTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        gaussClusterStdDevXTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gaussianPanel.add(gaussClusterStdDevXTxt, gridBagConstraints);

        gaussClusterStdDevYLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gaussClusterStdDevYLabel.setText("Standard Deviation - y Axis: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(gaussClusterStdDevYLabel, gridBagConstraints);

        gaussClusterStdDevYTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        gaussClusterStdDevYTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        gaussClusterStdDevYTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gaussianPanel.add(gaussClusterStdDevYTxt, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(jSeparator5, gridBagConstraints);

        gaussExampleImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gaussExampleImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MultivariateNormal.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(gaussExampleImg, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(jSeparator6, gridBagConstraints);

        java.awt.GridBagLayout squareSubmitPanel1Layout = new java.awt.GridBagLayout();
        squareSubmitPanel1Layout.columnWidths = new int[] {120, 100, 100};
        squareSubmitPanel1Layout.rowHeights = new int[] {5, 40};
        squareSubmitPanel1.setLayout(squareSubmitPanel1Layout);

        squareCancelBtn1.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squareSubmitPanel1.add(squareCancelBtn1, gridBagConstraints);

        squareSubmitBtn1.setText("Submit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        squareSubmitPanel1.add(squareSubmitBtn1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(squareSubmitPanel1, gridBagConstraints);

        bodyClusterPanel.add(gaussianPanel, "gaussianCard");

        getContentPane().add(bodyClusterPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uniformRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniformRadioBtnActionPerformed
        ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "uniformCard");
    }//GEN-LAST:event_uniformRadioBtnActionPerformed

    private void gaussianRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaussianRadioBtnActionPerformed
        ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "gaussianCard");
    }//GEN-LAST:event_gaussianRadioBtnActionPerformed

    private void squareRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareRadioBtnActionPerformed
        ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "squarePanel");
    }//GEN-LAST:event_squareRadioBtnActionPerformed

    private void DiscRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscRadioBtnActionPerformed
        ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "discPanel");
    }//GEN-LAST:event_DiscRadioBtnActionPerformed

    private void RingRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RingRadioBtnActionPerformed
        ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "ringPanel");
    }//GEN-LAST:event_RingRadioBtnActionPerformed

    private void squareClusterSizeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareClusterSizeTxtActionPerformed
        try{
            clusterSize = Integer.parseInt(squareClusterSizeTxt.getText());
            if (clusterSize < 0 || clusterSize > total){
                throw (new Exception());
            }
        }
        catch(Exception e){
            squareClusterSizeTxt.setText("0");
            clusterSize = 0;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 0 to " + total +")");
        }
    }//GEN-LAST:event_squareClusterSizeTxtActionPerformed

    private void squareClusterSizeTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_squareClusterSizeTxtFocusLost
        try{
            clusterSize = Integer.parseInt(squareClusterSizeTxt.getText());
            if (clusterSize < 0 || clusterSize > total){
                throw (new Exception());
            }
        }
        catch(Exception e){
            squareClusterSizeTxt.setText("0");
            clusterSize = 0;
            JOptionPane.showMessageDialog(this, "Enter a valid integer (from 0 to " + total +")");
        }
    }//GEN-LAST:event_squareClusterSizeTxtFocusLost

    private void squareClusterCenterXTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareClusterCenterXTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_squareClusterCenterXTxtActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Metal".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DistributionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DistributionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DistributionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DistributionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DistributionDialog dialog = new DistributionDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DiscRadioBtn;
    private javax.swing.JRadioButton RingRadioBtn;
    private javax.swing.JPanel bodyClusterPanel;
    private javax.swing.JPanel bodyUniformPanel;
    private javax.swing.JLabel clusterTitle;
    private javax.swing.JLabel clusterTypeLabel;
    private javax.swing.JPanel discPanel;
    private javax.swing.ButtonGroup distributionType;
    private javax.swing.JLabel gaussClusterMeanXLabel;
    private javax.swing.JTextField gaussClusterMeanXTxt;
    private javax.swing.JLabel gaussClusterMeanYLabel;
    private javax.swing.JTextField gaussClusterMeanYTxt;
    private javax.swing.JLabel gaussClusterSizeLabel;
    private javax.swing.JTextField gaussClusterSizeTxt;
    private javax.swing.JLabel gaussClusterStdDevXLabel;
    private javax.swing.JTextField gaussClusterStdDevXTxt;
    private javax.swing.JLabel gaussClusterStdDevYLabel;
    private javax.swing.JTextField gaussClusterStdDevYTxt;
    private javax.swing.JLabel gaussExampleImg;
    private javax.swing.JPanel gaussianPanel;
    private javax.swing.JRadioButton gaussianRadioBtn;
    private javax.swing.JPanel headClusterPanel;
    private javax.swing.JPanel headUniformPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JPanel ringPanel;
    private javax.swing.JButton squareCancelBtn;
    private javax.swing.JButton squareCancelBtn1;
    private javax.swing.JLabel squareClusterCenterXLabel;
    private javax.swing.JTextField squareClusterCenterXTxt;
    private javax.swing.JLabel squareClusterCenterYLabel;
    private javax.swing.JTextField squareClusterCenterYTxt;
    private javax.swing.JLabel squareClusterHeightLabel;
    private javax.swing.JTextField squareClusterHeightTxt;
    private javax.swing.JLabel squareClusterSizeLabel;
    private javax.swing.JTextField squareClusterSizeTxt;
    private javax.swing.JLabel squareClusterWidthLabel;
    private javax.swing.JTextField squareClusterWidthTxt;
    private javax.swing.JLabel squareExampleImg;
    private javax.swing.JPanel squarePanel;
    private javax.swing.JRadioButton squareRadioBtn;
    private javax.swing.JButton squareSubmitBtn;
    private javax.swing.JButton squareSubmitBtn1;
    private javax.swing.JPanel squareSubmitPanel;
    private javax.swing.JPanel squareSubmitPanel1;
    private javax.swing.JPanel uniformPanel;
    private javax.swing.JRadioButton uniformRadioBtn;
    private javax.swing.ButtonGroup uniformShape;
    private javax.swing.JLabel uniformShapeLabel;
    // End of variables declaration//GEN-END:variables
}
