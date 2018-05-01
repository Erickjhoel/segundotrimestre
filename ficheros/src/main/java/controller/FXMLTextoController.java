/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.common.io.CharSink;
import com.google.common.io.CharStreams;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLTextoController implements Initializable {
    private FXMLPrincipalController controllerTexto;

    @FXML
    TextArea  fxtexto;
   
    @FXML
    public void volverAtrasTexto(ActionEvent event) {
        controllerTexto.pantallaVolverPrincipal();
    }
//      public void cargarTexto() throws FileNotFoundException {
//                  String texto =controllerTexto.getRuta();
//        try {
//            CharStreams.toString(new FileReader(path));
//            Files.asCharSource(path, Charset.defaultCharset()).read();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLTextoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setControllerTexto(FXMLPrincipalController controllerTexto) {
        this.controllerTexto = controllerTexto;
    }
}
