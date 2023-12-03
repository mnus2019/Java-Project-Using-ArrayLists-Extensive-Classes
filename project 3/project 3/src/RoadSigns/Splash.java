package RoadSigns;
import java.awt.*;
import javax.swing.*;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        Splash.java
 * Description  A class representing the Splash screen used by the 
 *              RoadSignsGUI.java GUI used in a maintaining a famous composers
 *              database.
 * Project      Road signs Quiz project 3
 * Platform     JDK 20; NetBeans IDE 17; Windows 10
 * Course       CS 141
 * Date         6/7/2023     
 * History log  
 * @author      <>Minassie Ghebrmicael<>
 * @version 	1.0.0
 * @see     	java.awt.Color
 * @see     	java.awt.Toolkit
 * @see     	javax.swing.BorderFactory
 *****************************************************************************/
public class Splash extends JWindow
{
    // duration is integer value in milliseconds for how long the 
    // Splash screen is visible
    private final int duration;
    JProgressBar loading = new JProgressBar();  //progress bar
    private int progress;
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  Splash()
     * Description  Sets duration to provided parameter.
     * Date         6/7/2023
     * History Log    
     * @param       dur int
     * @author      <>Minassie Ghebrmicael<>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public Splash(int dur)
    {
        duration = dur;
        UIManager.put("ProgressBar.selectionForeground", 
                Color.gray.darker());
        //UIManager.put("ProgressBar.selectionBackground", Color.green);
        loading = new JProgressBar(0, 100);
        loading.setStringPainted(true);
        //loading.setForeground(Color.gray);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       showSplash()
     * Description  A method to show a title screen in the center of the screen
     *              for the amount of time given in the constructor
     * @author      <>Minassie Ghebrmicael<>
     * Date         6/7/2023
     * History Log   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public void showSplash()
    {
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.lightGray);

        // Set the window's bounds, centering the window
        int width = 1140;
        int height = 600;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width)/2;
        int y = (screen.height - height)/2;
        setBounds(x,y,width,height);

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon
            ("src/Image/SplashScreen.png"));
        JLabel copyrt = new JLabel
            ("Copyright Philosophers Inc., 2020, Philosophers Database", 
                        JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(loading, BorderLayout.SOUTH);
        Color border = new Color(50, 20, 20, 55);
        content.setBorder(BorderFactory.createLineBorder(border,
                10));

        setVisible(true);
        // Wait a little while, maybe while loading resources
        try 
        {
            //Increment the progress bar's value to 100 starting from 0
            incProgress(20);
            Thread.sleep(duration);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setVisible(false);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       incProgress()
     * Description  Create inner class ProgressThread object, up, and start the
     *              thread
     * Date         6/7/2023
     * History Log  7/18/2018
     *</pre>
     * @author      <i>Niko Culevski</i>
     * @param       amount int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void incProgress(int amount)
    {
        //Instantiate and start new thread
        ProgressThread up = new ProgressThread(amount);
        up.thread.start();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Class        ProgressThread
     * Description  Nested class that handles the progress bar
     * @author      <>Minassie Ghebrmicael<>
     * @param       amount int
     * Date         6/7/2023
     * History Log  
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    class ProgressThread 
    {
        private int amount;
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Constructor  ProgressThread()
        * Description  Sets amount to provided parameter.
        * Date         6/7/2023
        * History Log    
        * @param       amount int
        * @author      <>Minassie Ghebrmicael<>
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
        public ProgressThread(int amount)
        {
            this.amount = amount;
        }

        private Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                {
                    //Increment the progress bar until it's value hits 100
                    while (progress < 100) 
                    {
                        progress++;
                        loading.setString(String.valueOf(progress) + "%");
                        try 
                        {
                            Thread.sleep(30);
                        } 
                        catch (InterruptedException ex) 
                        {

                        }
                        loading.setValue(progress);
                    }
                }
            }
        });
    }
}