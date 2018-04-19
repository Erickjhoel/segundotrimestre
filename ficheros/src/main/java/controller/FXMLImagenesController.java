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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    public void volverAtras(MouseEvent event) {
//        File ete = new File(fxRutaActual.getText());
//        if (ete.getParent() == null) {
//            Alert b = new Alert(Alert.AlertType.ERROR, "No se puede volver atras", ButtonType.CLOSE);
//            b.showAndWait();
//        } else {
//            fxRutaActual.setText(ete.getParent());
//            cargarFiles();
//        }

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setControllerImagenes(FXMLPrincipalController controllerFichero) {
        this.controllerImagen = controllerFichero;
    }
}
