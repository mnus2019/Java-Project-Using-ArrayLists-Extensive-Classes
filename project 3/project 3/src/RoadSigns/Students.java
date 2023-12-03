
package RoadSigns;
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class            Students 
* File             Students .java
* Description      Derived class from abstract class RoadSignsGUI that
*                  represent a Students class with names index  plus methods 
*                  evaluate if the user has selected a name to continue 
*                  taking the quiz. 
* Environment      PC, Windows 10, NetBeans IDE 17, JDK 20
* Date             6/7/2023
* History Log  
* @author          <i>Minassie Ghebremicael</i>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Students {

 
//-------------------------------------------------------------------------
// private data members represent Students class instance variables
//   namesIndex, nameSelected 
//-------------------------------------------------------------------------
    
private int namesIndex;
private boolean nameSelected;
 
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Constructor            Students
* Description            Default constructor for the Students class.
* @author                <i>Minassie Ghebremicael</i>
* @see                   java.awt.Toolkit
* Date                   5/7/2023
* History Log 
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public Students ()
{
this.namesIndex = 0;
this.nameSelected = false;

}
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Constructor              Validation
* Description              Overloaded constructor for the Students class.
* @param                   selectedNameIndex int
* @author                  <i>Minassie Ghebremicael</i>
* Date                     6/7/2023
* History Log 
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public Students (int selectedNameIndex)
{
namesIndex = selectedNameIndex;

}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Method                isNameSelected()
* Description           A method to determine if the user has selected a name 
*                       in order to continue taking the road signs quiz.
* @author               <i>Minassie Ghebremicael</i>
* @return               nameSelected Boolean
* Date                  5/7/2023
* History Log 
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public boolean isNameSelected(){
    
   if(namesIndex < 0)
   {
     nameSelected = false;  
   }
   else 
   {
      nameSelected = true;  
   }
    return nameSelected;   
}
   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             getNamesIndex()
    * Description        Return namesIndex value .
    * @return            namesIndex int 
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getNamesIndex() {
        return namesIndex;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             setNamesIndex()
    * Description        Assign namesIndex value.
    * @param             namesIndex Boolean value 
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setNamesIndex(int namesIndex) {
        this.namesIndex = namesIndex;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             isValidName()
    * Description        Return nameSelected Boolean value.
    * @return            nameSelected Boolean 
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean isValidName() {
        return nameSelected;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             setValidName()
    * Description        Assign nameSelected value.
    * @param             validName Boolean
    * @author            <i>Minassie Ghebremicael</i>
    * Date               6/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setValidName(boolean validName) {
        this.nameSelected = validName;
    }
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method             toString()
    * Description        Return all and the students names index and
    *                    nameSelected.
    * @return            String value
    * @author            <i>Minassie Ghebremicael</i>
    * Date               5/7/2023
    * History Log 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString() {
        return "Students{" + "namesIndex=" + namesIndex +
                ", nameSelected=" + nameSelected + '}';
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
        final Students other = (Students) obj;
        if (this.namesIndex != other.namesIndex) {
            return false;
        }
        return this.nameSelected == other.nameSelected;
    }
  
    
}
