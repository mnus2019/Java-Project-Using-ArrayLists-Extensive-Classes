
package RoadSigns;

import java.util.Objects;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class            Validation
* File             Validation.java
* Description      Derived class from abstract class RoadSignsGUI that
*                  represent a VAlidation class with maximum and minimum limit
*                  of questions, plus methods to compute valid number of 
*                  questions are selected.
* Environment      PC, Windows 10, NetBeans IDE 17, JDK 20
* Date             5/7/2023
* History Log  
* @author          <i>Minassie Ghebremicael</i>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Validation {
 
//-------------------------------------------------------------------------
// private data members represent Validation  class instance variables
// inputQuestions, questionsLimit 
//-------------------------------------------------------------------------
    
private int inputQuestions,questionsLimit; 
private final int LEAST_QUESTIONS = 1;
private String noQuestions;
private boolean  valid;
//private Point[] points = {null,null,null}; 
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Constructor            Validation()
* Description            Default constructor for the Validation class.
* @author                <i>Niko Culevski</i>
* @see                   java.awt.Toolkit
* Date                   5/11/2023
* History Log 
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public Validation()
{
this.inputQuestions = 0;
this.questionsLimit = 0;
this.valid = false;

}
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Constructor              Validation()
* Description              Overloaded constructor for the Validation class.
* @param                   inputQuestions int
* @param                   questionsLimit int
* @param                   noQuestions String
* @author                  <i>Minassie Ghebremicael</i>
* Date                     6/7/2023
* History Log 
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public Validation(int inputQuestions, int questionsLimit, String noQuestions)
{
this.inputQuestions = inputQuestions;
this.questionsLimit = questionsLimit;
this.noQuestions = noQuestions;
}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Method                isValidInput()
* Description           A method to determine if the user input for the number
*                       of questions is valid and in range of the road signs
*                       quiz.
* @author               <i>Minassie Ghebremicael</i>
* @return               valid Boolean
* Date                  5/11/2023
* History Log 
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public boolean isValidInput(){
    valid = false;
   if((inputQuestions < LEAST_QUESTIONS) || (inputQuestions >  questionsLimit))
   {
     valid = true;  
   }
   else if(noQuestions.equals(""))
   {
      valid = true; 
   }
   else
   {
    valid = false;    
   }
    return valid;   
}

     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             getInputQuestions()
    * Description        Return inputQuestions value.
    * @return            inputQuestions int
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getInputQuestions() {
        return inputQuestions;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             setInputQuestions()
    * Description        Assigns inputQuestions value.
    * @param             inputQuestions int
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setInputQuestions(int inputQuestions) {
        this.inputQuestions = inputQuestions;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             getQuestionsLimit()
    * Description        Return questionsLimit value.
    * @return            questionsLimit int
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getQuestionsLimit() {
        return questionsLimit;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             setQuestionsLimit()
    * Description        Assigns questionsLimit value.
    * @param             questionsLimit Boolean
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setQuestionsLimit(int questionsLimit) {
        this.questionsLimit = questionsLimit;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             getNoQuestionse()
    * Description        Return string number of no questions.
    * @return            NoQuestions String
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getNoQuestions() {
        return noQuestions;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             setNoQuestions()
    * Description        Assigns noQuestions a value.
    * @param             noQuestions  String
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setNoQuestions(String noQuestions) {
        this.noQuestions = noQuestions;
    }
   
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             setValid()
    * Description        set valid to Boolean value.
    * @param             valid Boolean
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             toString()
    * Description        Return all values inputQuestions,questionsLimit,
    *                    noQuestions.
    * @return            String value
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
   

    @Override
    public String toString() {
        return "Validation{" + "inputQuestions=" + inputQuestions + 
          ", questionsLimit=" + questionsLimit + ", LEAST_QUESTIONS=" +
           LEAST_QUESTIONS + ", noQuestions=" + noQuestions + 
                ", valid=" + valid + '}';
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             equals()
    * Description        checks if the assigned variables are equal or getting
    *                    to their respective values designed by the program.
    * @return            Boolean value
    * @author            <i>Minassie Ghebremicael</i>
    * Date               5/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Validation other = (Validation) obj;
        if (this.inputQuestions != other.inputQuestions) {
            return false;
        }
        if (this.questionsLimit != other.questionsLimit) {
            return false;
        }
        if (this.LEAST_QUESTIONS != other.LEAST_QUESTIONS) {
            return false;
        }
        if (this.valid != other.valid) {
            return false;
        }
        return Objects.equals(this.noQuestions, other.noQuestions);
    }
    
}
