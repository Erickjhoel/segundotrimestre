/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLImagenesController implements Initializable {

    private FXMLPrincipalController controllerImagen;
    @FXML
    ImageView fxImage;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void handleClickEntrar(MouseEvent event) {
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setControllerImagenes(FXMLPrincipalController controllerFichero) {
        this.controllerImagen = controllerFichero;
    }
}
