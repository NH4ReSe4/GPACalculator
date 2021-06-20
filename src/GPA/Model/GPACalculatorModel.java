package GPA.Model;

import java.util.regex.Pattern;

/**
 * This class is used to do some calculations.
 * @author
 */
public class GPACalculatorModel {

    private String userAccount = "";

    private String[] gradesInString = new String[20];
    private String[] creditsInString = new String[20];
    private int[] gradeValueForECUST = new  int[20];
    private int[] gradeValueForNBUT = new  int[20];
    private float[] creditsValue = new float[20];
    private float[] gradePointForECUST = new float[20];
    private float[] gradePointForNBUT = new float[20];
    private float GPAForECUST;
    private float GPAForNBUT;
    private float totalCredits;
    private float averageGrade;
    private boolean isAvailableForInputs = true;


    /**
     * It will call other two methods to check if the inputs are correct.
     * @return true if all inputs are correct.
     */
    public boolean checkInputs(){
        checkGrades();
        checkCredits();
        return isAvailableForInputs;
    }

    /**
     * It is used to check if the grade is a number that less than 100 or
     */
    private void checkGrades () {
        Pattern pattern1 = Pattern.compile("[1-9]?[0-9]?[0]?");
        Pattern pattern2 = Pattern.compile("[AaBbCcDdFf][+-]?");
        for(int i = 0; i < 20; i ++){
            if(!pattern1.matcher(gradesInString[i]).matches()){
                if(!pattern2.matcher(gradesInString[i]).matches()){
                    isAvailableForInputs = false;
                    return;
                }
            }
        }
    }

    /**
     * It is used to check if the credit is a number.
     */
    private void checkCredits(){
        Pattern pattern = Pattern.compile("[0-9]+[.]?[0-9]*");
        for(int i = 0; i < 20; i ++){
            if(!pattern.matcher(creditsInString[i]).matches()){
                isAvailableForInputs = false;
                break;
            }
        }
    }

    /**
     * This is used to calculate the final results.
     */
    public void calculateResults(){
        totalCredits = 0.0F;
        GPAForECUST = 0.0F;
        GPAForNBUT = 0.0F;
        averageGrade = 0.0F;
        convertData();
        calculateGradePoints();
        if(!isAvailableForInputs){
            return;
        }
        for(int i = 0 ; i < 20; i ++){
            GPAForECUST = GPAForECUST + (gradePointForECUST[i] * creditsValue[i]);
            GPAForNBUT = GPAForNBUT + (gradePointForNBUT[i] * creditsValue[i]);
            totalCredits = totalCredits + creditsValue[i];
            averageGrade = averageGrade + gradeValueForNBUT[i] * creditsValue[i];
        }
        if(totalCredits == 0.0F){
            GPAForECUST =  GPAForECUST / (totalCredits + 1.0F);
            GPAForNBUT = GPAForNBUT / (totalCredits + 1.0F);
            averageGrade = averageGrade / (totalCredits + 1.0F);
        }
        else{
            GPAForECUST =  GPAForECUST / totalCredits;
            GPAForNBUT = GPAForNBUT / totalCredits;
            averageGrade = averageGrade / totalCredits;
        }
        /*
            ANd the if condition is used to prevent the scenario that user didn't input anything and the division 0/0
            will make a mistake.
         */


    }

    /**
     * This is used to convert the data that collected from user into integer data type.
     */
    private void convertData() {
        for(int i = 0; i < 20; i ++){
            creditsValue[i] = Float.parseFloat(creditsInString[i]);
        }
        for (int i = 0; i < 20; i ++)
        {
            switch (gradesInString[i]){
                case "A":
                    gradeValueForECUST[i] = 95;
                    gradeValueForNBUT [i] = 95;
                    break;
                case "A-":
                    gradeValueForECUST[i] = 88;
                    gradeValueForNBUT [i] = 87;
                    break;
                case "B+":
                    gradeValueForECUST[i] = 83;
                    gradeValueForNBUT [i] = 83;
                    break;
                case "B":
                    gradeValueForECUST[i] = 80;
                    gradeValueForNBUT[i] = 85;
                    break;
                case "B-":
                    gradeValueForECUST[i] = 76;
                    gradeValueForNBUT [i] = 76;
                    break;
                case "C+":
                    gradeValueForECUST[i] = 73;
                    gradeValueForNBUT [i] = 73;
                    break;
                case "C":
                    gradeValueForECUST[i] = 68;
                    gradeValueForNBUT[i] = 75;
                    break;
                case "C-":
                    gradeValueForECUST[i] = 64;
                    gradeValueForNBUT [i] = 64;
                    break;
                case "D":
                    gradeValueForECUST[i] = 61;
                    gradeValueForNBUT[i] = 65;
                    break;
                case "F":
                    gradeValueForECUST[i] = 58;
                    gradeValueForNBUT[i] = 45;
                    break;
                default:
                    gradeValueForECUST[i] = Integer.parseInt(gradesInString[i]);
                    gradeValueForNBUT[i] = Integer.parseInt(gradesInString[i]);
            }
        }

    }

    /**
     * This will call other methods to translate the user's grade into corresponding grade points.
     */
    private void calculateGradePoints(){
        calculateGradePointsForECUST();
        calculateGradePointsForNBUT();
    }

    /**
     * This is used to translate the user's grade into corresponding grade points(e.g. 100 -> 4.0) for ECUST version.
     */
    private void calculateGradePointsForECUST () {
        for(int i = 0; i < 20 ; i++){
            if(gradeValueForECUST[i] > 100){
                isAvailableForInputs = false;
                return;
            }
            else if(gradeValueForECUST[i] >= 90){
                gradePointForECUST[i] = 4.0F;
            }
            else if(gradeValueForECUST[i] >= 85){
                gradePointForECUST[i] = 3.7F;
            }
            else if(gradeValueForECUST[i] >= 82){
                gradePointForECUST[i] = 3.3F;
            }
            else if(gradeValueForECUST[i] >= 78){
                gradePointForECUST[i] = 3.0F;
            }
            else if(gradeValueForECUST[i] >= 75){
                gradePointForECUST[i] = 2.7F;
            }
            else if(gradeValueForECUST[i] >= 71){
                gradePointForECUST[i] = 2.3F;
            }
            else if(gradeValueForECUST[i] >= 66){
                gradePointForECUST[i] = 1.8F;
            }
            else if(gradeValueForECUST[i] >= 62){
                gradePointForECUST[i] = 1.4F;
            }
            else if(gradeValueForECUST[i] >= 60){
                gradePointForECUST[i] = 1.0F;
            }
            else {
                gradePointForECUST[i] = 0.0F;
            }
        }
    }

    /**
     * This is used to translate the user's grade into corresponding grade points(e.g. 100 -> 5.0) for NBUT version.
     */
    private void calculateGradePointsForNBUT () {
        for(int i = 0; i < 20; i ++){
            if(gradeValueForNBUT[i] > 100){
                isAvailableForInputs = false;
                return;
            }
            else if(gradeValueForNBUT[i] >= 60){
                gradePointForNBUT[i] = gradeValueForNBUT[i] * 0.1F - 5;
            }
            else{
                gradePointForNBUT[i] = 0;
            }
        }
    }


    public float getGPAForECUST () {
        return GPAForECUST;
    }

    public float getGPAForNBUT () {
        return GPAForNBUT;
    }

    public float getTotalCredits () {
        return totalCredits;
    }

    public void setGradesInString (String[] gradesInString) {
        this.gradesInString = gradesInString;
    }

    public void setCreditsInString (String[] creditsInString) {
        this.creditsInString = creditsInString;
    }

    public boolean isAvailableForInputs () {
        return isAvailableForInputs;
    }

    public float getAverageGrade () {
        return averageGrade;
    }
}
