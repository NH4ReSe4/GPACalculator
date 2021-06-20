package GPA.controller;

import GPA.Model.GPACalculatorModel;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * The Controller class is used to manage user's interaction
 * and pass these interactions to Model class and View class.
 * @author Yuhan Cheng
 */
public class GPACalculatorController  {

    /*
        The bellowing 20 variables is represent the 20 grade textFields in the main window.
     */
    @FXML
    private TextField grade1;
    @FXML
    private TextField grade2;
    @FXML
    private TextField grade3;
    @FXML
    private TextField grade4;
    @FXML
    private TextField grade5;
    @FXML
    private TextField grade6;
    @FXML
    private TextField grade7;
    @FXML
    private TextField grade8;
    @FXML
    private TextField grade9;
    @FXML
    private TextField grade10;
    @FXML
    private TextField grade11;
    @FXML
    private TextField grade12;
    @FXML
    private TextField grade13;
    @FXML
    private TextField grade14;
    @FXML
    private TextField grade15;
    @FXML
    private TextField grade16;
    @FXML
    private TextField grade17;
    @FXML
    private TextField grade18;
    @FXML
    private TextField grade19;
    @FXML
    private TextField grade20;

    /*
        The bellowing 20 variables is represent the 20 credit textFields in the main window.
     */
    @FXML
    private TextField credit1;
    @FXML
    private TextField credit2;
    @FXML
    private TextField credit3;
    @FXML
    private TextField credit4;
    @FXML
    private TextField credit5;
    @FXML
    private TextField credit6;
    @FXML
    private TextField credit7;
    @FXML
    private TextField credit8;
    @FXML
    private TextField credit9;
    @FXML
    private TextField credit10;
    @FXML
    private TextField credit11;
    @FXML
    private TextField credit12;
    @FXML
    private TextField credit13;
    @FXML
    private TextField credit14;
    @FXML
    private TextField credit15;
    @FXML
    private TextField credit16;
    @FXML
    private TextField credit17;
    @FXML
    private TextField credit18;
    @FXML
    private TextField credit19;
    @FXML
    private TextField credit20;


    /*
        The bellowing 20 variables is represent the 20 course name textFields in the main window.
     */
    @FXML
    private TextField courseName1;
    @FXML
    private TextField courseName2;
    @FXML
    private TextField courseName3;
    @FXML
    private TextField courseName4;
    @FXML
    private TextField courseName5;
    @FXML
    private TextField courseName6;
    @FXML
    private TextField courseName7;
    @FXML
    private TextField courseName8;
    @FXML
    private TextField courseName9;
    @FXML
    private TextField courseName10;
    @FXML
    private TextField courseName11;
    @FXML
    private TextField courseName12;
    @FXML
    private TextField courseName13;
    @FXML
    private TextField courseName14;
    @FXML
    private TextField courseName15;
    @FXML
    private TextField courseName16;
    @FXML
    private TextField courseName17;
    @FXML
    private TextField courseName18;
    @FXML
    private TextField courseName19;
    @FXML
    private TextField courseName20;

    @FXML
    private Label titleInTheMainWindow;

    private ArrayList<TextField> grades = new ArrayList<>();
    private ArrayList<TextField> credits = new ArrayList<>();
    private float GPAForECUST = 0.0F;
    private float GPAForNBUT = 0.0F;
    private float totalCredits = 0.0F;
    private float averageGrade = 0.0F;
    private ResultController resultController = new ResultController();
    private ArrayList<TextField> courseNames = new ArrayList<>();
    private GPACalculatorModel model = new GPACalculatorModel();

    /**
     * This is used to build twenty grade variables into a array so that it will
     * be more convenient to do some operations than before.
     */
    private void buildGradeArray (){
        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade3);
        grades.add(grade4);
        grades.add(grade5);
        grades.add(grade6);
        grades.add(grade7);
        grades.add(grade8);
        grades.add(grade9);
        grades.add(grade10);
        grades.add(grade11);
        grades.add(grade12);
        grades.add(grade13);
        grades.add(grade14);
        grades.add(grade15);
        grades.add(grade16);
        grades.add(grade17);
        grades.add(grade18);
        grades.add(grade19);
        grades.add(grade20);
    }

    /**
     * This is used to build twenty credit variables into a array so that it will
     * be more convenient to do some operations than before.
     */
    private void buildCreditArray(){
        credits.add(credit1);
        credits.add(credit2);
        credits.add(credit3);
        credits.add(credit4);
        credits.add(credit5);
        credits.add(credit6);
        credits.add(credit7);
        credits.add(credit8);
        credits.add(credit9);
        credits.add(credit10);
        credits.add(credit11);
        credits.add(credit12);
        credits.add(credit13);
        credits.add(credit14);
        credits.add(credit15);
        credits.add(credit16);
        credits.add(credit17);
        credits.add(credit18);
        credits.add(credit19);
        credits.add(credit20);
    }

    /**
     * This is used to build twenty course name variables into a array so that it will
     * be more convenient to do some operations than before.
     */
    private void buildCourseNameArray(){
        courseNames.add(courseName1);
        courseNames.add(courseName2);
        courseNames.add(courseName3);
        courseNames.add(courseName4);
        courseNames.add(courseName5);
        courseNames.add(courseName6);
        courseNames.add(courseName7);
        courseNames.add(courseName8);
        courseNames.add(courseName9);
        courseNames.add(courseName10);
        courseNames.add(courseName11);
        courseNames.add(courseName12);
        courseNames.add(courseName13);
        courseNames.add(courseName14);
        courseNames.add(courseName15);
        courseNames.add(courseName16);
        courseNames.add(courseName17);
        courseNames.add(courseName18);
        courseNames.add(courseName19);
        courseNames.add(courseName20);
    }

    /**
     * This is used to implement the function after user click the courseName label.
     * After user click the courseName label, twenty courseName textField become editable.
     */
    @FXML
    private void clickCourseName(){
        if(courseNames.isEmpty()){
            buildCourseNameArray();
        }
        for (TextField courseName:courseNames) {
            courseName.setEditable(true);
        }
    }

    /**
     * This is used to implement the function after user click the submit button.
     * After user click the submit button, the calculator will calculate the results
     * and present them in a new window.
     */
    @FXML
    private void clickSubmitButton(){
        initializeArrays();
        transportData();
        if(model.checkInputs()){
            model.calculateResults();
        }

        if(model.isAvailableForInputs()){
            try {
                presentResults();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                presentErrorMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This is used to pop the result window.
     * @throws IOException If there exist some mistakes.
     */
    private void presentResults () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GPA/View/ResultWindow.fxml"));
        Parent resultScreen = loader.load();
        Stage resultScreenStage = new Stage();
        resultScreenStage.setTitle("Results");
        resultScreenStage.setScene(new Scene(resultScreen, 550, 240));
        resultScreenStage.show();
        resultController =loader.getController();
        transportDataToResultController();
        resultController.presentResults();
    }

    /**
     * This is used to transport main data to another class to show to the user.
     */
    private void transportDataToResultController () {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);

        GPAForECUST = Float.valueOf(numberFormat.format(model.getGPAForECUST()));
        GPAForNBUT = Float.valueOf(numberFormat.format(model.getGPAForNBUT()));
        totalCredits = model.getTotalCredits();
        averageGrade = Float.valueOf(numberFormat.format(model.getAverageGrade()));

        resultController.setTotalCredits(totalCredits);
        resultController.setGPAForECUST(GPAForECUST);
        resultController.setGPAForNBUT(GPAForNBUT);
        resultController.setAverageGrade(averageGrade);
    }

    /**
     * This is used to call other methods to construct the array structure.
     */
    private void initializeArrays () {
        if (grades.isEmpty()) {
            buildGradeArray();
        }
        if (credits.isEmpty()) {
            buildCreditArray();
        }
    }

    /**
     * This is used to transport grades and credits into the Model class to do the calculation.
     */
    private void transportData () {
        String[] gradesInString = new String[20];
        String[] creditsInString = new String[20];
        for(int i = 0; i < 20; i ++){
            gradesInString[i] = grades.get(i).getText().trim().toUpperCase();
            creditsInString[i] = credits.get(i).getText().trim();
        }

        model.setCreditsInString(creditsInString);
        model.setGradesInString(gradesInString);
    }

    /**
     * This is used to pop the error window to suggest user that he or she may make some mistakes about the inputs.
     * @throws IOException If there exist some mistakes.
     */
    @FXML
    private void presentErrorMessage () throws IOException {
        Parent errorScreen = FXMLLoader.load(getClass().getResource("/GPA/View/ErrorWindow.fxml"));
        Stage errorScreenStage = new Stage();
        errorScreenStage.setTitle("Error");
        errorScreenStage.setScene(new Scene(errorScreen, 400, 150));
        errorScreenStage.show();
    }

    /**
     * This is used to implement the operation after user click the clear button
     * After user clicking the clear button, grades, credits and courseNames(if they are editable) will be cleaned.
     */
    @FXML
    private void clickClearButton(){
        initializeArrays();
        clearGrades();
        clearCredits();

        if(!courseNames.isEmpty()){
            clearCourseName();
        }
    }

    /**
     * This is used to set all courseName textFields to "" if it is editable.
     */
    private void clearCourseName () {
        for (TextField courseName:courseNames) {
            courseName.setText("");
        }
    }


    /**
     * This is used to set all credit textFields to 0.
     */
    private void clearCredits () {
        for (TextField credit:credits) {
            credit.setText("0");
        }
    }

    /**
     * This is used to set all grade textFields to 0.
     */
    private void clearGrades () {
        for (TextField grade:grades) {
            grade.setText("0");
        }
    }


    /**
     * After clicking the help button, the application will pop a new window to show
     * some useful hints.
     * @throws IOException If there exist some mistakes.
     */
    @FXML
    private void clickHelpButton() throws IOException {
        Parent helpScreen = FXMLLoader.load(getClass().getResource("/GPA/View/HelpWindow.fxml"));
        Stage helpScreenStage = new Stage();
        helpScreenStage.setTitle("Help");
        helpScreenStage.setScene(new Scene(helpScreen, 850, 455));
        helpScreenStage.show();
    }

    /**
     * This is used to show the animation if user click the "CPA Calculator"
     */
    @FXML
    private void extraScene(){
        Stage stage = new Stage();
        Group group = new Group();
        Scene scene = new Scene(group, 1000, 200, Color.ANTIQUEWHITE);
        stage.setScene(scene);
        stage.setTitle("Extra Scene");
        stage.show();
        Circle circle = new Circle(20, 20, 15);
        circle.setFill(Color.DARKRED);

        Path path = new Path();
        path.getElements().add(new MoveTo(50, 100));
        path.getElements().add(new LineTo(910,100));

        group.getChildren().add(path);
        group.getChildren().add(circle);
        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.seconds(3.0));
        pathTransition.setDelay(Duration.seconds(0.2));
        pathTransition.setPath(path);
        pathTransition.setNode(circle);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }

}
