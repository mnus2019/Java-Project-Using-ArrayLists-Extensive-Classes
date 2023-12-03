package RoadSigns;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        RoadSignGUI.java
 * Description  A class representing the GUI used in a Road Signs quiz 
 *              application.
 * Project      3 RoadSignGUI Quiz 
 * Platform     JDK 20; NetBeans IDE 17; PC Windows 10
 * Course       CS 141
 * Hours        8 hours and 45 minutes
 * Date         6/7/2023
 * History Log  
 * @author	<>Minassie Ghebrmicael<>
 * @version 	1.0.0
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class RoadSignGUI extends javax.swing.JFrame
{
     // class instance variables
    private int maxQuestions;   //maximum number of questions
    //maxQuestions =  Integer.parseInt(numberJTextField.getText());
    // replace next line with read from external file
    private String studentsfileName = "src/RoadSigns/Students.txt";
    private String signsfileName = "src/RoadSigns/RoadSigns.txt";
      //road signs names
    private ArrayList<String> signsList =  new ArrayList<>(); 
    private ArrayList<String> students = new ArrayList<>(); 
    //parallel boolean array tracks displayed road signs and prevent duplication
    private ArrayList<Boolean> signsUsed;   // = new boolean(signsList.size())
    // to be used for efficient random number generator
    private int [] numbers;   
    private int currentIndex;  // contains the index of the current road signs
    private int countCorrect;  //number of correct answers
    private int numberOfQuestions = 0;  //number of questions 
    private int numberOfSigns ;  //number of road signs 
    private int numberOfStudents ;  //number of students 
    private String emptyQuestions; //used to check for empty number of questions
    // tracks the number of road signs that have been displayed
    private int count = 0;
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  RoadSignGUI()-default constructor
     * Description  Create an instance of the GUI form, set the default
     *              JButton to be submitJButton, set icon image, center form,
     *              read Road signs from external file.
     * Date         6/7/2023
     * History Log   
     * @author      <>Minassie Ghebrmicael<>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public RoadSignGUI()
    {
        initComponents();
          //set icon on the form title
        this.setIconImage(Toolkit.getDefaultToolkit().
              getImage("src\\Image\\Small_Slippery.jpg")); 
        //center the form at start        
        this.setLocationRelativeTo(null); 
        readRoadSignsFromFile(signsfileName);
        readFromStudentsFile(studentsfileName);
        //Arrays.sort(artists);//sort the array replace this with insertion sort
        fillComboBox(signsList);  //populate the comboBox
        displayRoadSign();  //display first sign randomly
        displayStudents();
        // enable and disable the necessary Jbuttons on start
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false);
        openJMenuItem.setEnabled(true);  
        submitJButton.setEnabled(false);
        // call date method
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
        Date date = new Date(); // get current date in milliseconds since1/1/1970
         // set title and date to the form at the title bar
        this.setTitle("Road Signs Quiz--" + dateFormat.format(date) );
        
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       readRoadSignsFromFile()
     * Description  Reads road signs from a file RoadSigns.txt and fill 
     *              RoadSignsJComboBox.  
     * Date         6/7/2023
     * History Log  
     * @author      <>Minassie Ghebrmicael<>
     * @param       fileName String
     * @see         java.io.File
     * @see         java.util.Scanner
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void readRoadSignsFromFile(String fileName)
    {   numberOfSigns = 0;
        try
       { signsList.clear(); //clear ArrayList of road signs
         roadSignJComboBox.removeAllItems();  //clear roadSignJComboBox
         File file = new File(fileName);
         Scanner fileScanner = new Scanner(file);
         // read from file and count how many are there to size the ArrayList
         while(fileScanner.hasNextLine())
         {
             fileScanner.nextLine();
             numberOfSigns++;
         }
         fileScanner.close();
         //create parellel ArrayList
         signsUsed = new ArrayList<>();
         numbers = new int[numberOfSigns];
         // populate ArrayList
         fileScanner = new Scanner(file);   // reset the fileScanner
         for(int i = 0; i < numberOfSigns ; i++)
         {
             signsList.add(fileScanner.nextLine());
             signsUsed.add(false);
             numbers[i] = 0;
             
         }
       }
       catch(FileNotFoundException exp)
       {
            // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,fileName +
         "does not exist " ,"File Input Error ",
           JOptionPane.ERROR_MESSAGE);
          //Bring JFileChooser to select file in current directory
          JFileChooser chooser = new JFileChooser
        ("src/RoadSigns");
          //Filter only txt file
          FileNameExtensionFilter filter = new FileNameExtensionFilter(
          "Txt Files", "txt");
          chooser.setFileFilter(filter);
          int choice = chooser.showOpenDialog(null);
          if(choice == JFileChooser.APPROVE_OPTION)
          {
              File chosenFile = chooser.getSelectedFile();
              fileName = "src/RoadSigns/" + chosenFile.getName();
              readRoadSignsFromFile(fileName);
          
          }
          else
          {
              // exp. printStackTrace();
              System.exit(0);
          }
          
       }
       catch(Exception exp)
       {
             // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,
         "Unable to read from file  " ,"File Input Error ",
           JOptionPane.ERROR_MESSAGE);  
       }
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       fillComboBox
     * Description  Fill RoadSignsJComboBox with sign descriptions
     * Date         6/7/2023
     * History Log  
     * @author      <>Minassie Ghebrmicael<>
     * @param       ArrayList<String> roadSign
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @SuppressWarnings("unchecked")
    private void fillComboBox(ArrayList<String> roadSign)
    {
        roadSignJComboBox.removeAllItems();
       for(String sign : roadSign)
       {
           roadSignJComboBox.addItem(sign);
       }
       
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayRoadSigns
     * Description  Choose a random and unused sign and display it in the 
     *              roadSignJLabel.
     * Date         6/7/2023
     * History Log  
     * @author      <>Minassie Ghebrmicael<>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void displayRoadSign()
    {
        
       currentIndex = getUniqueRandomNumber();
       // create the path for the file
       String sign = roadSignJComboBox.getItemAt(currentIndex).toString();
       String signPath = "src/Image/" + sign + ".jpg";
       // set the roadSignJLabel to display the art
       roadSignJLabel.setIcon(new ImageIcon(signPath));
       //roadSignJLabel.setToolTipText(sign);
      
    } 
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       readFromStudentsFile
     * Description  Reads student names from a text file that is comma delimited
     *              and create an instance of the Students class with the
     *              data read.
     * @param       studentFile String
     * @see         java.util.StringTokenizer
     * Date         6/7/2023
     * History Log  
     * @author      <i>Minassie Ghebremicael</i>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public void readFromStudentsFile(String studentFile)
    {   numberOfStudents = 0;
        students.clear();   //clear ArrayList of students
        studentsJList.removeAll();  // empty JList
        try
        {
         File file = new File(studentFile);
         Scanner fileStudentScanner= new Scanner(file);
         // read from file and count how many are there to size the arrays
         while(fileStudentScanner.hasNextLine())
         {
             fileStudentScanner.nextLine();
             numberOfStudents++;
           
          }
         fileStudentScanner.close();
         //create parellel arrays
         // populate array
         fileStudentScanner = new Scanner(file);  //reset the fileScanner
         for(int i = 0; i < numberOfStudents ; i++)
         {
             students.add(fileStudentScanner.nextLine());
         }
      
       }
       catch(FileNotFoundException exp)
       {
            // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,studentFile  +
         "does not exist " ,"File Input Error ",
           JOptionPane.ERROR_MESSAGE);
          //Bring JFileChooser to select file in current directory
          JFileChooser chooser = new JFileChooser
        ("src/RoadSigns");
          //Filter only txt file
          FileNameExtensionFilter filter = new FileNameExtensionFilter(
          "Txt Files", "txt");
          chooser.setFileFilter(filter);
          int choice = chooser.showOpenDialog(null);
          if(choice == JFileChooser.APPROVE_OPTION)
          {
              File chosenFile = chooser.getSelectedFile();
              studentFile = "src/RoadSigns/" + chosenFile.getName();
              System.out.println("file = " + studentFile );
              readRoadSignsFromFile(studentFile );
          
          }
          else
          {
              System.exit(0);
          }
          
       }
       catch(Exception exp)
       {
             // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,
         "Unable to read from file  " ,"File Input Error ",
           JOptionPane.ERROR_MESSAGE);  
       }
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayStudents()
     * Description  Displays students in studentsJList.
     * Date         6/7/2023
     * History Log  
     * @author      <i>Minassie Ghebremicael</i>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void displayStudents()
    {   // get index of current students
        int location = studentsJList.getSelectedIndex(); 
        // create array with String names only
        String[] studentsList = new String[students.size()];    
        for(int index = 0; index < students.size(); index++)
        {
            studentsList[index] = students.get(index);
        }
        // populate JList with students
        studentsJList.setListData(studentsList);   
        if(location < 0)
           studentsJList.setSelectedIndex(0);  // select first student
        else
            studentsJList.setSelectedIndex(location);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getUniqueRandomNumber
     * Description  Return an unused random number by a blind repetition of
     *              random generation and checking for unused road sign quiz.
     * Date         6/7/2023
     * History Log  
     * @return      random int
     * @author      <>Minassie Ghebrmicael<>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private int getUniqueRandomNumber()
    {
        Random generator = new Random();
       int randomNumber = 0;
       // generate random number until unsed road sign is found
       do
       {
           //generate a number between 0 and signsList.size() - 1
           randomNumber = generator.nextInt(signsList.size());
                    
       }while(signsUsed.get(randomNumber));
           // indicate that sign has been used
           signsUsed.set(randomNumber,true);
           return randomNumber;
    } 
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roadSignJLabel = new javax.swing.JLabel();
        controlJPanel = new javax.swing.JPanel();
        submitJButton = new javax.swing.JButton();
        nextJButton = new javax.swing.JButton();
        playJButton = new javax.swing.JButton();
        selectJPanel = new javax.swing.JPanel();
        selectJLabel = new javax.swing.JLabel();
        roadSignJComboBox = new javax.swing.JComboBox();
        resultJLabel = new javax.swing.JLabel();
        quizJLabel = new javax.swing.JLabel();
        questionsJLabel = new javax.swing.JLabel();
        numberJTextField = new javax.swing.JTextField();
        studentsJScrollPane = new javax.swing.JScrollPane();
        studentsJList = new javax.swing.JList<>();
        roadSignJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        printFormJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        exitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Road Sign Quiz");
        setResizable(false);

        roadSignJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        roadSignJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roadSignJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Men At Work.jpg"))); // NOI18N
        roadSignJLabel.setFocusable(false);

        controlJPanel.setLayout(new java.awt.GridLayout(3, 1, 3, 5));

        submitJButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        submitJButton.setMnemonic('S');
        submitJButton.setText("Submit");
        submitJButton.setToolTipText("Click to submit your answer");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(submitJButton);

        nextJButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        nextJButton.setMnemonic('N');
        nextJButton.setText("Next Road Sign");
        nextJButton.setToolTipText("Click to see next road sign");
        nextJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(nextJButton);

        playJButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        playJButton.setMnemonic('P');
        playJButton.setText("Play Again");
        playJButton.setToolTipText("Play all over again!");
        playJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(playJButton);

        selectJPanel.setLayout(new java.awt.GridLayout(3, 1, 3, 5));

        selectJLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        selectJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectJLabel.setText("Select Sign Description");
        selectJLabel.setToolTipText("Tis guides user to select a road sign from the JComboBox");
        selectJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectJPanel.add(selectJLabel);

        roadSignJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        roadSignJComboBox.setToolTipText("Select sign description to match road sign");
        selectJPanel.add(roadSignJComboBox);

        resultJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        resultJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectJPanel.add(resultJLabel);

        quizJLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        quizJLabel.setForeground(new java.awt.Color(0, 102, 102));
        quizJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quizJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Small_Slippery.jpg"))); // NOI18N
        quizJLabel.setText(" Road Sign Quiz");
        quizJLabel.setToolTipText("Road sign heaading");

        questionsJLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        questionsJLabel.setText("Questions:");
        questionsJLabel.setToolTipText("This implies the user to input values for the number of question for the road sign quiz");

        numberJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        numberJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numberJTextField.setToolTipText("Enter the number of questions for the road sign quiz in range [1,16]");
        numberJTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                numberJTextFieldMouseEntered(evt);
            }
        });
        numberJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberJTextFieldActionPerformed(evt);
            }
        });
        numberJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberJTextFieldKeyTyped(evt);
            }
        });

        studentsJScrollPane.setToolTipText("This shows the list of all students taking the road sign quiz");
        studentsJScrollPane.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        studentsJList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        studentsJList.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        studentsJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsJListMouseClicked(evt);
            }
        });
        studentsJScrollPane.setViewportView(studentsJList);

        fileJMenu.setText("File");
        fileJMenu.setToolTipText("File menu contains (Open: helps open new set of road sign quiz, Clear:helps to restart the game, Print: This will print the GUI, Exit: closes the application)");
        fileJMenu.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        openJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        openJMenuItem.setMnemonic('N');
        openJMenuItem.setText("New");
        openJMenuItem.setToolTipText("Open a new set of road signs");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openJMenuItem);

        clearJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        clearJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("This helps user clear the road sign, the results box and restart all over again");
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        printJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print Form as GUI");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        printFormJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        printFormJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        printFormJMenuItem.setMnemonic('P');
        printFormJMenuItem.setText("Print Form");
        printFormJMenuItem.setToolTipText("Print Form as GUI");
        printFormJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printFormJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printFormJMenuItem);
        fileJMenu.add(fileJSeparator);

        exitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        exitJMenuItem.setMnemonic('X');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.setToolTipText("This will end application");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        roadSignJMenuBar.add(fileJMenu);

        helpJMenu.setText("Help");
        helpJMenu.setToolTipText("This contains the about menu to display information about the road sign quiz");
        helpJMenu.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        aboutJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("Redirect user to the about road sign form ");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        roadSignJMenuBar.add(helpJMenu);

        setJMenuBar(roadSignJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(roadSignJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(quizJLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(questionsJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentsJScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(quizJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentsJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roadSignJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       submitJButtonActionPerformed
     * Description  Event handler to check if the user's answer is correct. The
     *              correct answer is held in class instance variable 
     *              currentIndex.
     * Date         6/7/2023
     * History Log  
     * @param       evt ActionEvent
     * @author      <>Minassie Ghebrmicael<>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
       
         count++;
         
        
       if(roadSignJComboBox.getSelectedIndex() == currentIndex)
       {
           countCorrect++;
           resultJLabel.setText("Correct! " + countCorrect + "/" + count);
       }
       else    // if an incorrect answer is given
       {
           resultJLabel.setText("Incorrect " + countCorrect + "/" + count);
          
       }
       //Inform user if quiz is over and unable/disable appropriate buttons
       if(count == maxQuestions)
       {
           resultJLabel.setText(countCorrect + "/" + maxQuestions + 
                   " Correct!");
           nextJButton.setEnabled(false);
           submitJButton.setEnabled(false);
           playJButton.setEnabled(true);
           roadSignJComboBox.setEnabled(false);
           openJMenuItem.setEnabled(true);
       }
       else //if less than maxQuestions have been displayed
       {
           nextJButton.setEnabled(true);
           submitJButton.setEnabled(false);
           playJButton.setEnabled(false);             
       }
    }//GEN-LAST:event_submitJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       nextJButtonActionPerformed
     * Description  Event handler to select next unused sign randomly by 
     *              calling the displayRoadSign() method.
     * Date         6/7/2023
     * History Log  
     * @param       evt ActionEvent
     * @author      <>Minassie Ghebrmicael<>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void nextJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJButtonActionPerformed
        displayRoadSign();  //display next flag
        //reset GUI components to intial states
        roadSignJComboBox.setSelectedIndex(0);
        submitJButton.setEnabled(true);
        resultJLabel.setEnabled(true);
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false); 
    }//GEN-LAST:event_nextJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       playJButtonActionPerformed
     * Description  Event handler to start the game all over again.
     * Date         6/7/2023
     * History Log  
     * @param       evt ActionEvent
     * @author      <>Minassie Ghebrmicael<>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void playJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playJButtonActionPerformed
      // Start game all over
       countCorrect  = 0;
       count = 0;
       numberJTextField.setText("");
       studentsJList.setEnabled(true);
       resultJLabel.setText("");
       emptyQuestions = numberJTextField.getText();
       if(emptyQuestions.equals(""))
       {
       resultJLabel.setEnabled(true);
       numberJTextField.setEnabled(true);
       submitJButton.setEnabled(false);
       nextJButton.setEnabled(false);
       playJButton.setEnabled(false);
       roadSignJComboBox.setEnabled(true);
       roadSignJComboBox.setSelectedIndex(0);
        }
       else
       {
          // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,
         "Must select a name\n" ,"Please select a name ",
           JOptionPane.ERROR_MESSAGE); 
          submitJButton.setEnabled(true);
       }
       //reset boolean array to false and number array to 0's
       for(int i = 0; i < signsList.size(); i++)
       {
           signsUsed.set(i, false);
           numbers[i] = 0;
       }
       displayRoadSign();  // redisplay new road sign
   
       
    }//GEN-LAST:event_playJButtonActionPerformed

   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       aboutJMenuItemActionPerformed()
     * Description  Create an About form and show it. 
     * Date         6/7/2023
     * History Log    
     * @param       evt java.awt.event.ActionEvent
     * @author      <>Minassie Ghebrmicael<>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aboutJMenuItemActionPerformed
    {//GEN-HEADEREND:event_aboutJMenuItemActionPerformed
        // show About form
        About aboutWindow = new About(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       exitJMenuItemActionPerformed()
     * Description  Closes the application. 
     * Date         6/7/2023
     * History Log   
     * @param       evt java.awt.event.ActionEvent
     * @author      <>Minassie Ghebrmicael<>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJMenuItemActionPerformed
    {//GEN-HEADEREND:event_exitJMenuItemActionPerformed
        // Closes the application.
        System.exit(0);
    }//GEN-LAST:event_exitJMenuItemActionPerformed
       /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       numberJTextFieldKeyTyped()
     * Description  Accepts only digits, backspace and delete key. 
     * Date         6/7/2023
     * History Log   
     * @param       evt java.awt.event.KeyEvent
     * @author      <>Minassie Ghebrmicael<>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void numberJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberJTextFieldKeyTyped
        //allow oly digits, period, and backspace
        char c = evt.getKeyChar();
        
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                || ( c == KeyEvent.VK_DELETE))))
        {
            getToolkit().beep();
            evt.consume();
            
        }

    }//GEN-LAST:event_numberJTextFieldKeyTyped

    private void numberJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberJTextFieldActionPerformed
     
        try
       {   emptyQuestions = numberJTextField.getText();
           maxQuestions = Integer.parseInt(numberJTextField.getText());
           System.out.println("numberJTextField == " + numberOfSigns);
           Validation myValidation = new Validation(maxQuestions,
                   (signsList.size()-1),emptyQuestions);
           boolean isValidQuestions = myValidation.isValidInput();
           
            if(isValidQuestions)
                throw new NumberFormatException();
            numberJTextField.setEnabled(false);
            roadSignJComboBox.setEnabled(true);
            displayRoadSign();
            //displayStudents();
            submitJButton.setEnabled(false);
            openJMenuItem.setEnabled(false);
            playJButton.setEnabled(false);
            nextJButton.setEnabled(false);
            
        }
        catch(NumberFormatException exp)
                {
                   // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,
         "Input must be in the range  [1, " + (signsList.size()- 1) + "]." 
                  ,"Input" + " Error", JOptionPane.ERROR_MESSAGE);
         numberJTextField.selectAll(); 
         numberJTextField.requestFocus();   
                }
    }//GEN-LAST:event_numberJTextFieldActionPerformed
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       printFormJMenuItemActionPerformed()
     * Description  Event handler to the form as GUI.
     *              calls the PrintUtilities.printComponent method.
     * Date         6/7/2023
     * History Log    
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Minassie Ghebremicael</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printFormJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printFormJMenuItemActionPerformed
       // print the form as a GUI
        PrintUtilities.printComponent(this); 
    }//GEN-LAST:event_printFormJMenuItemActionPerformed
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       printJMenuItemActionPerformed()
     * Description  Print displayJLabel.
     * Date         6/7/2023
     * History Log    
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Minassie Ghebremicael</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // print content f the JTextArea
        JTextArea studentInfo = new JTextArea();
        String studentsName = studentsJList.getSelectedValue();
        String quizResult = resultJLabel.getText();
        StringBuffer output = new StringBuffer();
        output.append("Student Name: " + studentsName + 
                "\nNumber of Question Taken: " + maxQuestions + "\n" +
                 "Quiz Result: " + quizResult  );
        studentInfo.setText(output.toString());
       try 
       {
           studentInfo.print();
       }
       catch(PrinterException ex)
       {
               // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,
         "Road sign can not be printed" ,"Print Error",
           JOptionPane.ERROR_MESSAGE);   
       }
    }//GEN-LAST:event_printJMenuItemActionPerformed
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       numberJTextFieldMouseEntered()
     * Description  Event handler to set questions text box ToolTip.This helps 
     *              instruct the user to enter the correct number of questions.
      * @param       evt MouseEvent
     * @see         java.awt.event.MouthEvent
     * @author      <i>Minassie Ghebremicael</i>
     * Date         5/16/2023
     * History Log   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void numberJTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numberJTextFieldMouseEntered
        //set the correct numberJTextField ToolTip
        //duides the user to enter the correct number of question  
        numberJTextField.setToolTipText("Please Enter the number of questions"
                + " in range of " + "[1, " + (signsList.size()-1) + "]");
    }//GEN-LAST:event_numberJTextFieldMouseEntered
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       studentsJListMouseClicked()
     * Description  Event handler to select and  show appropriate tab.
     * @param       evt MouseEvent
     * @see         java.awt.event.MouthEvent
     * @author      <i>Minassie Ghebremicael</i>
     * Date         6/7/2023
     * History Log   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void studentsJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsJListMouseClicked
         //select appropraite tab
        int studentNamesIndex = studentsJList.getSelectedIndex();
        Students myStudents = new Students(studentNamesIndex);
        boolean selectedStudent = myStudents.isNameSelected();
         // show alert message on a dialog box  
        int responseName = JOptionPane.showConfirmDialog(null,
         "Please select a name to continue" ,
         " Alert Name",
          JOptionPane.INFORMATION_MESSAGE);
        if(responseName == JOptionPane.YES_NO_OPTION)
        {
        if(selectedStudent)
        {   submitJButton.setEnabled(true);
            studentsJList.setEnabled(false);
            System.out.println("name selected");
           
        }
        else
        {
         // show error message on a dialog box  
          JOptionPane.showMessageDialog(null,
         "Must select a name\n" ,"Please select a name ",
           JOptionPane.ERROR_MESSAGE); 
        }
        }
    }//GEN-LAST:event_studentsJListMouseClicked
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       openJMenuItemActionPerformed()
     * Description  method used to open a new set of files to JList
     *              and JComboBox.
     * @see         evt java.awt.event.ActionEvent
     * @author      <i>Minassie Ghebremicael</i>
     * Date         6/7/2023
     * History Log   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void openJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser(
                "src/roadSigns/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Txt Files",
                "txt");
        chooser.setFileFilter(filter);
        String sourceExtention = "src/roadSigns/";
        int choice = chooser.showOpenDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION)
        {
          File choosenFile = chooser.getSelectedFile();
          String newFileName  = "src/roadSigns/"  + choosenFile.getName();
          System.out.println("newFileName ==  " + newFileName );
          if((newFileName.equals(sourceExtention +"Students.txt" )) ||
                  (newFileName.equals(sourceExtention + "Students_1.txt")))
          {
              readFromStudentsFile(newFileName);  
              displayStudents();
                                      
          }
          else
          {
              readRoadSignsFromFile(newFileName);
              fillComboBox(signsList);
          }
    
        }
    }//GEN-LAST:event_openJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       main()
     * Description  Displays splash screen and the main RoadSign GUI form.
     * Date         6/7/2023     
     * History log 
     * @param       args are the command line strings
     * @author      <>Minassie Ghebrmicael<>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[])
    {
        // Show splash screen
        Splash mySplash = new Splash(5000);     // duration = 4 seconds
        mySplash.showSplash();                  // show splash screen
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                RoadSignGUI flagQuiz = new RoadSignGUI();                
                flagQuiz.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JButton nextJButton;
    private javax.swing.JTextField numberJTextField;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JButton playJButton;
    private javax.swing.JMenuItem printFormJMenuItem;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JLabel questionsJLabel;
    private javax.swing.JLabel quizJLabel;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JComboBox roadSignJComboBox;
    private javax.swing.JLabel roadSignJLabel;
    private javax.swing.JMenuBar roadSignJMenuBar;
    private javax.swing.JLabel selectJLabel;
    private javax.swing.JPanel selectJPanel;
    private javax.swing.JList<String> studentsJList;
    private javax.swing.JScrollPane studentsJScrollPane;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}