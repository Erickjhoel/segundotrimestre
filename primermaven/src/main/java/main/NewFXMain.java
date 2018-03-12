/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author daw
 */
public class NewFXMain extends Application {
    
     @Override
    public void start(Stage stage) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLETE.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/fxmlete.css");
        
        stage.setTitle("KLK");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
