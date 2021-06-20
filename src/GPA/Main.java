package GPA;

import GPA.View.GPACalculatorView;
import javafx.application.Application;


/**
 * This class is to build the whole Application.
 * @author Yuhan Cheng
 */
public class Main{
    public static  void main (String[] args) {
        GPACalculatorView view = new GPACalculatorView();
        Application.launch(GPACalculatorView.class,args);
    }

}
