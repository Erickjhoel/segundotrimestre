/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

import constantes.Constante;
import controller.FXMLFicherosController;
import controller.FXMLPrincipalController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author daw
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loaderMenu = new FXMLLoader(
          getClass().getResource(Constante.PANTALLA_PRINCIPAL)); //colocar en constantes la ruta*****************
        BorderPane root = loaderMenu.load();
        FXMLPrincipalController menuController = loaderMenu.getController();
          
        AnchorPane anchor;
                    //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(
          getClass().getResource(Constante.PANTALLA_FICHERO));
        anchor = loader.load();
        FXMLFicherosController controller = loader.getController();
        controller.setControllerFichero(menuController);//hay que crear public void... de controller en loguin
        
        root.setCenter(anchor);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/fxmlprincipal.css");
        
        primaryStage.setTitle("JavaFX and Maven");
        primaryStage.setScene(scene);
        primaryStage.getProperties().put("hostServices", this.getHostServices());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
