package GPA.View;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class is used to start other fxml files.
 */
public class GPACalculatorView extends Application{

    @Override
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GPA/View/MainWindow.fxml"));
        stage.setTitle("GPA Calculator");
        stage.setScene(new Scene(root, 910, 910));
        stage.show();
        final Group GROUP = new Group();
        final Circle CIRCLE = new Circle(20, 20, 15);
        CIRCLE.setFill(Color.DARKRED);

        final Path PATH = new Path();
        PATH.getElements().add(new MoveTo(50, 20));
        PATH.getElements().add(new LineTo(910,20));

        GROUP.getChildren().add(PATH);
        GROUP.getChildren().add(CIRCLE);
        final PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.seconds(8.0));
        pathTransition.setDelay(Duration.seconds(.5));
        pathTransition.setPath(PATH);
        pathTransition.setNode(CIRCLE);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }

    private void initializeAnimation () {

    }


}
