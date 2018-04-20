/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLImagenesController implements Initializable {

    private FXMLPrincipalController controllerImagen;
    private FXMLFicherosController controlerseleccionado;
    @FXML
    ImageView fxImage;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void volverAtras(ActionEvent event) {
     controlerseleccionado.handleVolver(event);
    }
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image
          = new Image(getClass().getResourceAsStream(controlerseleccionado.rutaactual));
        fxImage.setImage(image);
    }

    public void setControllerImagenes(FXMLPrincipalController controllerFichero) {
        this.controllerImagen = controllerFichero;
    }
}
