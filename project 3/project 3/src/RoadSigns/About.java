package RoadSigns;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        About.java
 * Description  About form for road sign quiz information
 * Project      Philosophers Database
 * Platform     JDK 20; NetBeans IDE 17; Windows 10
 * Course       CS 141, EdCC
 * Hours        2 hours and 45 minutes
 * Date         6/7/2023
 * History log  
 * @author	<i>MInassie Ghebremicael</i>
 * @version 	1.0.0
 * @see     	javax.swing.JDialog
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class About extends javax.swing.JDialog
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  JDialog to allow to select modal or modulus form
     * Description  Create the form as designed, center it, set the icon, 
     *              closeJButton as default.
     * Date         6/7/2023
     * History log  
     * @author      <i>MInassie Ghebremicael</i>
     * @param       parent java.awt.Frame
     * @param       modal Boolean
     * @see         javax.swing.JDialog
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public About(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        //set closeJButton as default
        this.getRootPane().setDefaultButton(closeJButton);
        //center form
        this.setLocationRelativeTo(null);       
        setDate();
    }
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method              setDate()
    * Description         set a format for current date.Displays title on 
    *                     title bar and date it in the respective JLabel field.
    * @author             <i>Minassie Ghebremicael</i>
    * @see                java.text.DateFormat
    * @see                java.text.SimpleDateFormat
    * @see                java.util.Date
    * Date                6/7/2023
    * History Log   
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    private void setDate()
    {   // create an Object
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date(); // get current date in milliseconds since1/1/1970
        // sets current date to JLabel
        dateJLabel.setText("Date: " + dateFormat.format(now));
        // set title and date to the form at the title bar
        this.setTitle("Road Signs Quiz" );
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();
        authorJLabel = new javax.swing.JLabel();
        versionJLabel = new javax.swing.JLabel();
        copyrightJLabel = new javax.swing.JLabel();
        dateJLabel = new javax.swing.JLabel();
        infoJScrollPane = new javax.swing.JScrollPane();
        infoJTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Artists About");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Small_Slippery.jpg"))); // NOI18N
        titleJLabel.setText("  Road Sign Quiz Information ");
        titleJLabel.setToolTipText("Heading for the about form");

        closeJButton.setBackground(new java.awt.Color(204, 255, 204));
        closeJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        closeJButton.setMnemonic('C');
        closeJButton.setText("Close");
        closeJButton.setToolTipText("This will close the about form only");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        authorJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        authorJLabel.setText("Author:  Minassie Ghebremicael");
        authorJLabel.setToolTipText("This describes the authors name");

        versionJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        versionJLabel.setText("Version 1.0.0");
        versionJLabel.setToolTipText("This displays the version number");

        copyrightJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        copyrightJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyrightJLabel.setText("Copyright: Freeware");
        copyrightJLabel.setToolTipText("This show copyrights are prohibited");

        dateJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateJLabel.setText("Date:  5/7/2020");
        dateJLabel.setToolTipText("This shows the  current date");

        infoJScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        infoJTextArea.setEditable(false);
        infoJTextArea.setColumns(20);
        infoJTextArea.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        infoJTextArea.setLineWrap(true);
        infoJTextArea.setRows(5);
        infoJTextArea.setText("This program tests the user's knowledge of road signs. The application prompts the user to enter a valid number of questions, and their name. It displays an unused random sign image and asks the user to select the sign name number from the signs descriptions ComboBox. It displays number of correct answers out of total number of questions taken to the point.");
        infoJTextArea.setToolTipText("The information displayed here is designed to give a user how the road sign quiz can be played ");
        infoJTextArea.setWrapStyleWord(true);
        infoJScrollPane.setViewportView(infoJTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(versionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(authorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(copyrightJLabel)))
                            .addComponent(infoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titleJLabel)
                .addGap(12, 12, 12)
                .addComponent(infoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(authorJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versionJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyrightJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateJLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       closeJButtonActionPerformed
     * Description  Closes the About form only
     * Date         6/7/2023
     * History log  
     * @author      <i>MInassie Ghebremicael</i>
     * @param       evt java.awt.event.ActionEvent
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeJButtonActionPerformed
    {//GEN-HEADEREND:event_closeJButtonActionPerformed
        // Closes the About form only
        this.dispose();        
}//GEN-LAST:event_closeJButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorJLabel;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel;
    private javax.swing.JLabel dateJLabel;
    private javax.swing.JScrollPane infoJScrollPane;
    private javax.swing.JTextArea infoJTextArea;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel versionJLabel;
    // End of variables declaration//GEN-END:variables
}
