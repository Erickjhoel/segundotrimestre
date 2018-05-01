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

    private FXMLImagenesController imagenCargar;
    private FXMLPDFController pdfCargar;
    @FXML
    private BorderPane fxRoot;

    private AnchorPane imagenes;
    private AnchorPane pdf;
    private AnchorPane fichero;
    private AnchorPane texto;
    private String ruta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxRoot.setCenter(fichero);

    }

    public void pantallaCargarIma() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_IMAGENES));
            imagenes = loader.load();
            imagenCargar = loader.getController();
            imagenCargar.setControllerImagenes(this);
            imagenCargar.cargarImagen();
            fxRoot.setCenter(imagenes);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pantallaCargarPDF() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_PDF));
            pdf = loader.load();
            pdfCargar = loader.getController();
            pdfCargar.setControllerpdf(this);
            pdfCargar.cargarPDF();
            fxRoot.setCenter(pdf);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pantallaVolverPrincipal() {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_FICHERO));
            fichero = loader.load();
            FXMLFicherosController controllerFichero = loader.getController();
            controllerFichero.setControllerFichero(this);
            fxRoot.setCenter(fichero);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void pantallaCargarTXT() {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_TEXTO));
            texto = loader.load();
            FXMLTextoController controllerTexto = loader.getController();
            controllerTexto.setControllerTexto(this);
            fxRoot.setCenter(texto);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
