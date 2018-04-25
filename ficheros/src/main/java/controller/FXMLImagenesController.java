/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLImagenesController implements Initializable {
    private FXMLFicherosController controllerRuta;
    private FXMLPrincipalController controllerImagen;
    @FXML
    ImageView fxImage;
    @FXML
    public Label fxRutaImagen;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void volverAtrasImagen(ActionEvent event) {
        controllerImagen.pantallaVolverPrincipal();
    }

    public void cargarImagen() throws FileNotFoundException {
        String path=controllerImagen.getRuta();
        Image image = new Image(new FileInputStream(path));
        fxImage.setImage(image);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        fxRutaImagen=controllerRuta.fxRutaActual;
    }
    
    
    public void setControllerImagenes(FXMLPrincipalController controller) {
        this.controllerImagen = controller;
    }
}
