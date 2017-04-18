
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
public class DistributionDialog extends javax.swing.JDialog {
    private int total;
    private int xLimit;
    private int yLimit;
    Person.personType pt;
    private String title;
    private String footnote;
    private ArrayList<Person> individuals;
    private int clusterSize;
    private boolean cancelled = false;
    String card;

    /**
     * Creates new form VoterDistDialog
     */
    public DistributionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DistributionDialog(java.awt.Frame parent, boolean modal, int total, int xLimit, int yLimit, Person.personType pt, String title, String footnote, boolean finalCluster, String card) {
        super(parent, modal);
        this.title = title;
        this.footnote = footnote;
        initComponents();
        this.total = total;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
        this.pt = pt;
        individuals = new ArrayList();
        if (finalCluster){
            squareClusterSizeTxt.setText(String.valueOf(total));
            squareClusterSizeTxt.setEnabled(false);
            
            discClusterSizeTxt.setText(String.valueOf(total));
            discClusterSizeTxt.setEnabled(false);
            
            ringClusterSizeTxt.setText(String.valueOf(total));
            ringClusterSizeTxt.setEnabled(false);
            
            gaussClusterSizeTxt.setText(String.valueOf(total));
            gaussClusterSizeTxt.setEnabled(false);
            
            clusterSize = total;
        } else{
            clusterSize = 0;
        }
        
        if (card == "square"){
            uniformRadioBtn.setSelected(true);
            ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "uniformCard");
            squareRadioBtn.setSelected(true);
            ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "squareCard");
        }
        else if (card == "disc"){
            uniformRadioBtn.setSelected(true);
            ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "uniformCard");
            discRadioBtn.setSelected(true);
            ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "discCard");
        }
        else if (card == "ring"){
            uniformRadioBtn.setSelected(true);
            ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "uniformCard");
            ringRadioBtn.setSelected(true);
            ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "ringCard");
        }
        else if (card == "gaussian"){
            gaussianRadioBtn.setSelected(true);
            ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "gaussianCard");
        }
        
        this.getRootPane().setDefaultButton(submitBtn);
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
    
    public boolean isCancelled(){
        return cancelled;
    }
    
    public String getCard(){
        return card;
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
        discRadioBtn = new javax.swing.JRadioButton();
        ringRadioBtn = new javax.swing.JRadioButton();
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
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        discPanel = new javax.swing.JPanel();
        discClusterSizeLabel = new javax.swing.JLabel();
        discClusterSizeTxt = new javax.swing.JTextField();
        discClusterCenterXLabel = new javax.swing.JLabel();
        discClusterCenterXTxt = new javax.swing.JTextField();
        discClusterCenterYLabel = new javax.swing.JLabel();
        discClusterCenterYTxt = new javax.swing.JTextField();
        discClusterRadiusLabel = new javax.swing.JLabel();
        discClusterRadiusTxt = new javax.swing.JTextField();
        discExampleImg = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        ringPanel = new javax.swing.JPanel();
        ringClusterSizeLabel = new javax.swing.JLabel();
        ringClusterSizeTxt = new javax.swing.JTextField();
        ringClusterCenterXLabel = new javax.swing.JLabel();
        ringClusterCenterXTxt = new javax.swing.JTextField();
        ringClusterCenterYLabel = new javax.swing.JLabel();
        ringClusterCenterYTxt = new javax.swing.JTextField();
        ringClusterMinRadiusLabel = new javax.swing.JLabel();
        ringClusterMinRadiusTxt = new javax.swing.JTextField();
        ringClusterMaxRadiusLabel = new javax.swing.JLabel();
        ringClusterMaxRadiusTxt = new javax.swing.JTextField();
        ringExampleImg = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
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
        buttonPanel = new javax.swing.JPanel();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(360, 20));
        setMaximumSize(new java.awt.Dimension(380, 700));
        setMinimumSize(new java.awt.Dimension(380, 700));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(380, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        headClusterPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {280};
        jPanel1Layout.rowHeights = new int[] {30, 20, 20, 20, 20};
        headClusterPanel.setLayout(jPanel1Layout);

        clusterTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clusterTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clusterTitle.setText(title);
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

        remainingLabel.setText(footnote);
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

        uniformShape.add(discRadioBtn);
        discRadioBtn.setText("Disc");
        discRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discRadioBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headUniformPanel.add(discRadioBtn, gridBagConstraints);

        uniformShape.add(ringRadioBtn);
        ringRadioBtn.setText("Ring");
        ringRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ringRadioBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        headUniformPanel.add(ringRadioBtn, gridBagConstraints);

        uniformPanel.add(headUniformPanel, java.awt.BorderLayout.PAGE_START);

        bodyUniformPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bodyUniformPanel.setLayout(new java.awt.CardLayout());

        java.awt.GridBagLayout squarePanelLayout = new java.awt.GridBagLayout();
        squarePanelLayout.columnWidths = new int[] {30, 190, 130, 30};
        squarePanelLayout.rowHeights = new int[] {5, 30, 30, 30, 30, 30, 10, 195, 5};
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

        bodyUniformPanel.add(squarePanel, "squareCard");

        java.awt.GridBagLayout discPanelLayout = new java.awt.GridBagLayout();
        discPanelLayout.columnWidths = new int[] {30, 190, 130, 30};
        discPanelLayout.rowHeights = new int[] {5, 30, 30, 30, 30, 30, 10, 195, 5};
        discPanel.setLayout(discPanelLayout);

        discClusterSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        discClusterSizeLabel.setText("Cluster Size (population): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        discPanel.add(discClusterSizeLabel, gridBagConstraints);

        discClusterSizeTxt.setText("0");
        discClusterSizeTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        discClusterSizeTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        discClusterSizeTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        discPanel.add(discClusterSizeTxt, gridBagConstraints);

        discClusterCenterXLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        discClusterCenterXLabel.setText("Cluster xCenter: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        discPanel.add(discClusterCenterXLabel, gridBagConstraints);

        discClusterCenterXTxt.setText("0");
        discClusterCenterXTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        discClusterCenterXTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        discClusterCenterXTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        discPanel.add(discClusterCenterXTxt, gridBagConstraints);

        discClusterCenterYLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        discClusterCenterYLabel.setText("Cluster yCenter: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        discPanel.add(discClusterCenterYLabel, gridBagConstraints);

        discClusterCenterYTxt.setText("0");
        discClusterCenterYTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        discClusterCenterYTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        discClusterCenterYTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        discPanel.add(discClusterCenterYTxt, gridBagConstraints);

        discClusterRadiusLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        discClusterRadiusLabel.setText("Cluster Radius: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        discPanel.add(discClusterRadiusLabel, gridBagConstraints);

        discClusterRadiusTxt.setText("1");
        discClusterRadiusTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        discClusterRadiusTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        discClusterRadiusTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        discPanel.add(discClusterRadiusTxt, gridBagConstraints);

        discExampleImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        discExampleImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disc.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        discPanel.add(discExampleImg, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        discPanel.add(jSeparator7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        discPanel.add(jSeparator8, gridBagConstraints);

        bodyUniformPanel.add(discPanel, "discCard");

        java.awt.GridBagLayout ringPanelLayout = new java.awt.GridBagLayout();
        ringPanelLayout.columnWidths = new int[] {30, 190, 130, 30};
        ringPanelLayout.rowHeights = new int[] {5, 30, 30, 30, 30, 30, 10, 195, 5};
        ringPanel.setLayout(ringPanelLayout);

        ringClusterSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ringClusterSizeLabel.setText("Cluster Size (population): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(ringClusterSizeLabel, gridBagConstraints);

        ringClusterSizeTxt.setText("0");
        ringClusterSizeTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        ringClusterSizeTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        ringClusterSizeTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        ringPanel.add(ringClusterSizeTxt, gridBagConstraints);

        ringClusterCenterXLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ringClusterCenterXLabel.setText("Cluster xCenter: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(ringClusterCenterXLabel, gridBagConstraints);

        ringClusterCenterXTxt.setText("0");
        ringClusterCenterXTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        ringClusterCenterXTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        ringClusterCenterXTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        ringPanel.add(ringClusterCenterXTxt, gridBagConstraints);

        ringClusterCenterYLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ringClusterCenterYLabel.setText("Cluster yCenter: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(ringClusterCenterYLabel, gridBagConstraints);

        ringClusterCenterYTxt.setText("0");
        ringClusterCenterYTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        ringClusterCenterYTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        ringClusterCenterYTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        ringPanel.add(ringClusterCenterYTxt, gridBagConstraints);

        ringClusterMinRadiusLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ringClusterMinRadiusLabel.setText("Cluster Min Radius: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(ringClusterMinRadiusLabel, gridBagConstraints);

        ringClusterMinRadiusTxt.setText("1");
        ringClusterMinRadiusTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        ringClusterMinRadiusTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        ringClusterMinRadiusTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        ringPanel.add(ringClusterMinRadiusTxt, gridBagConstraints);

        ringClusterMaxRadiusLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ringClusterMaxRadiusLabel.setText("Cluster Max Radius: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(ringClusterMaxRadiusLabel, gridBagConstraints);

        ringClusterMaxRadiusTxt.setText("1");
        ringClusterMaxRadiusTxt.setMaximumSize(new java.awt.Dimension(50, 24));
        ringClusterMaxRadiusTxt.setMinimumSize(new java.awt.Dimension(50, 24));
        ringClusterMaxRadiusTxt.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        ringPanel.add(ringClusterMaxRadiusTxt, gridBagConstraints);

        ringExampleImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ringExampleImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ring.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(ringExampleImg, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(jSeparator9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        ringPanel.add(jSeparator10, gridBagConstraints);

        bodyUniformPanel.add(ringPanel, "ringCard");

        uniformPanel.add(bodyUniformPanel, java.awt.BorderLayout.CENTER);

        bodyClusterPanel.add(uniformPanel, "uniformCard");

        java.awt.GridBagLayout gaussianPanelLayout = new java.awt.GridBagLayout();
        gaussianPanelLayout.columnWidths = new int[] {30, 190, 130, 30};
        gaussianPanelLayout.rowHeights = new int[] {35, 30, 30, 30, 30, 30, 40, 195, 5, 40};
        gaussianPanel.setLayout(gaussianPanelLayout);

        gaussClusterSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gaussClusterSizeLabel.setText("Cluster Size (population): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gaussianPanel.add(gaussClusterSizeLabel, gridBagConstraints);

        gaussClusterSizeTxt.setText("0");
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

        gaussClusterMeanXTxt.setText("0");
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

        gaussClusterMeanYTxt.setText("0");
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

        gaussClusterStdDevXTxt.setText("1");
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

        gaussClusterStdDevYTxt.setText("1");
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

        bodyClusterPanel.add(gaussianPanel, "gaussianCard");

        getContentPane().add(bodyClusterPanel, java.awt.BorderLayout.CENTER);

        buttonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        java.awt.GridBagLayout buttonPanelLayout = new java.awt.GridBagLayout();
        buttonPanelLayout.columnWidths = new int[] {120, 100, 100};
        buttonPanelLayout.rowHeights = new int[] {20, 40, 15};
        buttonPanel.setLayout(buttonPanelLayout);

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        buttonPanel.add(submitBtn, gridBagConstraints);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        buttonPanel.add(cancelBtn, gridBagConstraints);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uniformRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniformRadioBtnActionPerformed
        ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "uniformCard");
    }//GEN-LAST:event_uniformRadioBtnActionPerformed

    private void gaussianRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaussianRadioBtnActionPerformed
        ((CardLayout)bodyClusterPanel.getLayout()).show(bodyClusterPanel, "gaussianCard");
    }//GEN-LAST:event_gaussianRadioBtnActionPerformed

    private void squareRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareRadioBtnActionPerformed
        ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "squareCard");
    }//GEN-LAST:event_squareRadioBtnActionPerformed

    private void discRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discRadioBtnActionPerformed
        ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "discCard");
    }//GEN-LAST:event_discRadioBtnActionPerformed

    private void ringRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ringRadioBtnActionPerformed
        ((CardLayout)bodyUniformPanel.getLayout()).show(bodyUniformPanel, "ringCard");
    }//GEN-LAST:event_ringRadioBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String eol = System.getProperty("line.separator");
        
        if (uniformRadioBtn.isSelected()){
            if (squareRadioBtn.isSelected()){
                card = "square";
                
                //Input validation
                String err = "";
                double xCenter = 0;
                double yCenter = 0;
                double width = 1;
                double height = 1;

                try{
                    int x = Integer.parseInt(squareClusterSizeTxt.getText());
                    if (x < 0 || x > total){
                        throw (new Exception());
                    }
                    clusterSize = x;
                }
                catch(Exception e){
                    squareClusterSizeTxt.setBackground(Color.cyan);
                    err = err + "Enter a valid cluster population (max " + total + ")." + eol;
                }
                
                try{
                    double x = Double.parseDouble(squareClusterCenterXTxt.getText());
                    if (x < -xLimit || x > xLimit){
                        throw (new Exception());
                    }
                    xCenter = x;
                }
                catch(Exception e){
                    squareClusterCenterXTxt.setBackground(Color.cyan);
                    err = err + "The center must be within x-Axis bounds (-" + xLimit + ", +" + xLimit + ")" + eol;
                }
                
                try{
                    double x = Double.parseDouble(squareClusterCenterYTxt.getText());
                    if (x < -yLimit || x > yLimit){
                        throw (new Exception());
                    }
                    yCenter = x;
                }
                catch(Exception e){
                    squareClusterCenterYTxt.setBackground(Color.cyan);
                    err = err + "The center must be within y-Axis bounds (-" + yLimit + ", +" + yLimit + ")" + eol;
                }
                
                try{
                    double x = Double.parseDouble(squareClusterWidthTxt.getText());
                    if (x <= 0 || x > 2*xLimit){
                        throw (new Exception());
                    }
                    width = x;
                }
                catch(Exception e){
                    squareClusterWidthTxt.setBackground(Color.cyan);
                    err = err + "Rectangle cluster width cannot be greater than x-Axis range (" + 2*xLimit + ")" + eol;
                }
                
                try{
                    double x = Double.parseDouble(squareClusterHeightTxt.getText());
                    if (x <= 0 || x > 2*yLimit){
                        throw (new Exception());
                    }
                    height = x;
                }
                catch(Exception e){
                    squareClusterHeightTxt.setBackground(Color.cyan);
                    err = err + "Rectangle cluster height cannot be greater than y-Axis range (" + 2*xLimit + ")" + eol;
                }
                
                if(err != ""){
                    JOptionPane.showMessageDialog(this, err);
                }
                else {
                    individuals = Person.squareUniformDistribution(pt, clusterSize, xCenter, yCenter, width, height, xLimit, yLimit);
                    this.setVisible(false);
                }
            }
            
            if (discRadioBtn.isSelected()){
                card = "disc";
                
                //Input validation
                String err = "";
                double xCenter = 0;
                double yCenter = 0;
                double radius = 1;

                try{
                    int x = Integer.parseInt(discClusterSizeTxt.getText());
                    if (x < 0 || x > total){
                        throw (new Exception());
                    }
                    clusterSize = x;
                }
                catch(Exception e){
                    discClusterSizeTxt.setBackground(Color.cyan);
                    err = err + "Enter a valid cluster population (max " + total + ")." + eol;
                }
                
                try{
                    double x = Double.parseDouble(discClusterCenterXTxt.getText());
                    if (x < -xLimit || x > xLimit){
                        throw (new Exception());
                    }
                    xCenter = x;
                }
                catch(Exception e){
                    discClusterCenterXTxt.setBackground(Color.cyan);
                    err = err + "The center must be within x-Axis bounds (-" + xLimit + ", +" + xLimit + ")" + eol;
                }
                
                try{
                    double x = Double.parseDouble(discClusterCenterYTxt.getText());
                    if (x < -yLimit || x > yLimit){
                        throw (new Exception());
                    }
                    yCenter = x;
                }
                catch(Exception e){
                    discClusterCenterYTxt.setBackground(Color.cyan);
                    err = err + "The center must be within y-Axis bounds (-" + yLimit + ", +" + yLimit + ")" + eol;
                }
                
                try{
                    double x = Double.parseDouble(discClusterRadiusTxt.getText());
                    if (x <= 0 || x > Math.sqrt(Math.pow(xLimit, 2) + Math.pow(yLimit, 2))){
                        throw (new Exception());
                    }
                    radius = x;
                }
                catch(Exception e){
                    discClusterRadiusTxt.setBackground(Color.cyan);
                    err = err + "Disc radius cannot be greater than half the diagonal (" + Math.sqrt(Math.pow(xLimit, 2) + Math.pow(yLimit, 2)) + ")" + eol;
                }
                
                if(err != ""){
                    JOptionPane.showMessageDialog(this, err);
                }
                else {
                    individuals = Person.discUniformDistribution(pt, clusterSize, xCenter, yCenter, radius, xLimit, yLimit);
                    this.setVisible(false);
                }
            }
            
            if (ringRadioBtn.isSelected()){
                card = "ring";
                
                //Input validation
                String err = "";
                double xCenter = 0;
                double yCenter = 0;
                double minRadius = 0;
                double maxRadius = 1;

                try{
                    int x = Integer.parseInt(ringClusterSizeTxt.getText());
                    if (x < 0 || x > total){
                        throw (new Exception());
                    }
                    clusterSize = x;
                }
                catch(Exception e){
                    ringClusterSizeTxt.setBackground(Color.cyan);
                    err = err + "Enter a valid cluster population (max " + total + ")." + eol;
                }
                
                try{
                    double x = Double.parseDouble(ringClusterCenterXTxt.getText());
                    if (x < -xLimit || x > xLimit){
                        throw (new Exception());
                    }
                    xCenter = x;
                }
                catch(Exception e){
                    ringClusterCenterXTxt.setBackground(Color.cyan);
                    err = err + "The center must be within x-Axis bounds (-" + xLimit + ", +" + xLimit + ")" + eol;
                }
                
                try{
                    double x = Double.parseDouble(ringClusterCenterYTxt.getText());
                    if (x < -yLimit || x > yLimit){
                        throw (new Exception());
                    }
                    yCenter = x;
                }
                catch(Exception e){
                    ringClusterCenterYTxt.setBackground(Color.cyan);
                    err = err + "The center must be within y-Axis bounds (-" + yLimit + ", +" + yLimit + ")" + eol;
                }
                
                try{
                    double x = Double.parseDouble(ringClusterMinRadiusTxt.getText());
                    if (x < 0 || x > xLimit || x > yLimit){
                        throw (new Exception());
                    }
                    minRadius = x;
                }
                catch(Exception e){
                    ringClusterMinRadiusTxt.setBackground(Color.cyan);
                    err = err + "Ring's minimum radius cannot be greater than the smaller of the two axis' bounds (min{" + xLimit + "," + yLimit + "})" + eol;
                }
                
                try{
                    double x = Double.parseDouble(ringClusterMaxRadiusTxt.getText());
                    if (x <= 0 || x > Math.sqrt(Math.pow(xLimit, 2) + Math.pow(yLimit, 2))){
                        throw (new Exception());
                    }
                    maxRadius = x;
                }
                catch(Exception e){
                    ringClusterMaxRadiusTxt.setBackground(Color.cyan);
                    err = err + "Ring's max radius cannot be greater than half the diagonal (" + Math.sqrt(Math.pow(xLimit, 2) + Math.pow(yLimit, 2)) + ")" + eol;
                }
                
                if(err != ""){
                    JOptionPane.showMessageDialog(this, err);
                }
                else {
                    individuals = Person.ringUniformDistribution(pt, clusterSize, xCenter, yCenter, minRadius, maxRadius, xLimit, yLimit);
                    this.setVisible(false);
                }
            }
        }
        else if (gaussianRadioBtn.isSelected()){
            card = "gaussian";

            //Input validation
            String err = "";
            double xMean = 0;
            double yMean = 0;
            double stdDevX = 1;
            double stdDevY = 1;

            try{
                int x = Integer.parseInt(gaussClusterSizeTxt.getText());
                if (x < 0 || x > total){
                    throw (new Exception());
                }
                clusterSize = x;
            }
            catch(Exception e){
                gaussClusterSizeTxt.setBackground(Color.cyan);
                err = err + "Enter a valid cluster population (max " + total + ")." + eol;
            }

            try{
                double x = Double.parseDouble(gaussClusterMeanXTxt.getText());
                if (x < -xLimit || x > xLimit){
                    throw (new Exception());
                }
                xMean = x;
            }
            catch(Exception e){
                gaussClusterMeanXTxt.setBackground(Color.cyan);
                err = err + "The mean x-value must be within x-Axis bounds (-" + xLimit + ", +" + xLimit + ")" + eol;
            }

            try{
                double x = Double.parseDouble(gaussClusterMeanYTxt.getText());
                if (x < -yLimit || x > yLimit){
                    throw (new Exception());
                }
                yMean = x;
            }
            catch(Exception e){
                gaussClusterMeanYTxt.setBackground(Color.cyan);
                err = err + "The mean y-value must be within y-Axis bounds (-" + yLimit + ", +" + yLimit + ")" + eol;
            }

            try{
                double x = Double.parseDouble(gaussClusterStdDevXTxt.getText());
                if (x <= 0 || x > xLimit){
                    throw (new Exception());
                }
                stdDevX = x;
            }
            catch(Exception e){
                gaussClusterStdDevXTxt.setBackground(Color.cyan);
                err = err + "X-Axis standard deviation must be less than the x-boundary value. (" + xLimit + ")" + eol;
            }

            try{
                double x = Double.parseDouble(gaussClusterStdDevYTxt.getText());
                if (x <= 0 || x > yLimit){
                    throw (new Exception());
                }
                stdDevY = x;
            }
            catch(Exception e){
                gaussClusterStdDevYTxt.setBackground(Color.cyan);
                err = err + "Y-Axis standard deviation must be less than the y-boundary value. (" + yLimit + ")" + eol;
            }

            if(err != ""){
                JOptionPane.showMessageDialog(this, err);
            }
            else {
                individuals = Person.gaussianDistribution(pt, clusterSize, xMean, yMean, xLimit, yLimit, stdDevX, stdDevY);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?\nAll progress towards creating this election will be lost!", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            cancelled = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?\nAll progress towards creating this election will be lost!", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            cancelled = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JPanel bodyClusterPanel;
    private javax.swing.JPanel bodyUniformPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel clusterTitle;
    private javax.swing.JLabel clusterTypeLabel;
    private javax.swing.JLabel discClusterCenterXLabel;
    private javax.swing.JTextField discClusterCenterXTxt;
    private javax.swing.JLabel discClusterCenterYLabel;
    private javax.swing.JTextField discClusterCenterYTxt;
    private javax.swing.JLabel discClusterRadiusLabel;
    private javax.swing.JTextField discClusterRadiusTxt;
    private javax.swing.JLabel discClusterSizeLabel;
    private javax.swing.JTextField discClusterSizeTxt;
    private javax.swing.JLabel discExampleImg;
    private javax.swing.JPanel discPanel;
    private javax.swing.JRadioButton discRadioBtn;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JLabel ringClusterCenterXLabel;
    private javax.swing.JTextField ringClusterCenterXTxt;
    private javax.swing.JLabel ringClusterCenterYLabel;
    private javax.swing.JTextField ringClusterCenterYTxt;
    private javax.swing.JLabel ringClusterMaxRadiusLabel;
    private javax.swing.JTextField ringClusterMaxRadiusTxt;
    private javax.swing.JLabel ringClusterMinRadiusLabel;
    private javax.swing.JTextField ringClusterMinRadiusTxt;
    private javax.swing.JLabel ringClusterSizeLabel;
    private javax.swing.JTextField ringClusterSizeTxt;
    private javax.swing.JLabel ringExampleImg;
    private javax.swing.JPanel ringPanel;
    private javax.swing.JRadioButton ringRadioBtn;
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
    private javax.swing.JButton submitBtn;
    private javax.swing.JPanel uniformPanel;
    private javax.swing.JRadioButton uniformRadioBtn;
    private javax.swing.ButtonGroup uniformShape;
    private javax.swing.JLabel uniformShapeLabel;
    // End of variables declaration//GEN-END:variables
}
