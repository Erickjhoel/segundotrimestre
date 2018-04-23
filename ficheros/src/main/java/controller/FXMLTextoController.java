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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLTextoController implements Initializable {

    private FXMLPrincipalController controllerTexto;

    @FXML
    public void eliminar() {
        File delete = new File("test.test");
            delete.delete();
    }

    @FXML
    public void renombrar() {
        File rename = new File("test.test.copia");
            rename.renameTo(new File("test.test.copia2"));
    }

    @FXML
    public void copiar() {
        try {
            Files.copy(new File("test.test"),new File("test.test.copia"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLTextoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setControllerTexto(FXMLPrincipalController controllerTexto) {
        this.controllerTexto = controllerTexto;
    }
}
