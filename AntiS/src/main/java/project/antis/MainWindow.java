package project.antis;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.stage.StageStyle;

import java.awt.*;

public class MainWindow extends Application {

    public  void start(Stage stage) throws Exception{
        double x = -500; // Coordonnée X
        double y = 125;

        Scene scene = new Scene( FXMLLoader.load(getClass().getResource("View.fxml")));


        // Configurer le nouveau stage pour la deuxième page
        scene.setFill(Color.TRANSPARENT);
        stage.setX(x);
        stage.setY(y);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Antis");
        stage.show();
    }

    public void run() {
        launch();

    }
}
