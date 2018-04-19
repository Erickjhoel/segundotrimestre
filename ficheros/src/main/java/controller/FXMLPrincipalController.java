/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constantes.Constante;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private BorderPane fxRoot;

    private AnchorPane imagenes;
    private AnchorPane pdf;
    private AnchorPane fichero;
    private AnchorPane texto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_IMAGENES));
            imagenes = loader.load();
            FXMLImagenesController controllerImagenes = loader.getController();
            controllerImagenes.setControllerImagenes(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_PDF));
            pdf = loader.load();
            FXMLPDFController controllerPdf = loader.getController();
            controllerPdf.setControllerpdf(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_FICHERO));
            fichero = loader.load();
            FXMLFicherosController controllerFichero = loader.getController();
            controllerFichero.setControllerFichero(this);
            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_TEXTO));
            texto = loader.load();
            FXMLTextoController controllerTexto = loader.getController();
            controllerTexto.setControllerTexto(this);

        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
               fxRoot.setCenter(fichero);
        }
    }

    public void pantallaImagen() {
        fxRoot.setCenter(imagenes);
    }
    public void pantallaPdf() {
        fxRoot.setCenter(pdf);
    }
    public void pantallaTexto() {
        fxRoot.setCenter(texto);
    }
}
