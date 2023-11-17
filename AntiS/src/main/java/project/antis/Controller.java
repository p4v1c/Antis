package project.antis;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;
import org.w3c.dom.events.Event;
import javafx.event.EventHandler;


public class Controller implements Initializable {

    @FXML
    private ImageView open;
    @FXML
    private ImageView close;
    @FXML
    private ImageView semi;
    @FXML
    private ImageView mailIcon;

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Vous pouvez ajouter votre code d'initialisation ici si nécessaire.
    }

    @FXML
    private void handleMouseEnter(MouseEvent event) {
        open.getScene().setCursor(Cursor.HAND);
    }

    @FXML
    private void handleMouseExit(MouseEvent event) {
        open.getScene().setCursor(Cursor.DEFAULT);
    }

    @FXML
    private void handleImageClick(MouseEvent event) {
        // Obtenez la scène associée à l'image
        Stage stage = (Stage) close.getScene().getWindow();
        // Fermez la fenêtre
        stage.close();
    }

    @FXML
    private void semi(MouseEvent event) {
        // Obtenez la scène associée à l'image
        Stage stage = (Stage) semi.getScene().getWindow();
        stage.setIconified(!stage.isIconified());
    }

    @FXML
    private void Open(MouseEvent event) {

    }

    @FXML
    private void onMousePressed(MouseEvent event) {
        // Capturez les coordonnées de la souris lorsque vous appuyez sur le bouton de la souris
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    private void onMouseDragged(MouseEvent event) {
        // Calculez le nouveau positionnement de la fenêtre en fonction du mouvement de la souris
        Stage stage = (Stage) open.getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    int i = 1;

    Stage secondStage = null;

    public void mailIcon(MouseEvent event) throws Exception {
        i++;
        if (i % 2 == 0) {
            if (secondStage == null) {
                // Charger la deuxième page (View2.fxml)
                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("View2.fxml"));
                Parent page2 = loader2.load();

                // Créer une nouvelle scène pour la deuxième page
                Scene scene2 = new Scene(page2);
                scene2.setFill(Color.TRANSPARENT);

                double x = 900; // Coordonnée X
                double y = 350;

                // Configurer le nouveau stage pour la deuxième page
                secondStage = new Stage();
                secondStage.setX(x);
                secondStage.setY(y);
                secondStage.setScene(scene2);
                secondStage.initStyle(StageStyle.TRANSPARENT);
                secondStage.setTitle("Antis");

                // Afficher la deuxième page sans fermer la première
                secondStage.show();
            }
        } else {
            // Fermez la fenêtre si elle est ouverte
            if (secondStage != null) {
                secondStage.close();
                secondStage = null; // Réinitialiser la référence
            }
        }
    }
}
