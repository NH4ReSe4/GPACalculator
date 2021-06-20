package GPA.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ResultController {

    @FXML
    private Label allCreditPoints;
    @FXML
    private Label ECUSTsGPA;
    @FXML
    private Label NBUTsGPA;
    @FXML
    private Label avGrade;

    private float totalCredits;
    private float GPAForECUST;
    private float GPAForNBUT;
    private float averageGrade;

    public void presentResults(){
        allCreditPoints.setText(String.valueOf(totalCredits));
        ECUSTsGPA.setText(GPAForECUST + "/4.0");
        NBUTsGPA.setText(GPAForNBUT + "/5.0");
        avGrade.setText(averageGrade + "");
    }

    public void setTotalCredits (float totalCredits) {
        this.totalCredits = totalCredits;
    }

    public void setGPAForECUST (float GPAForECUST) {
        this.GPAForECUST = GPAForECUST;
    }

    public void setGPAForNBUT (float GPAForNBUT) {
        this.GPAForNBUT = GPAForNBUT;
    }

    public void setAverageGrade (float averageGrade) {
        this.averageGrade = averageGrade;
    }
}
