/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.input.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLFicherosController implements Initializable {

    private String rutaactual;
    @FXML
    private Label fxRutaActual;
    @FXML
    private ListView<File> fxLista;

    @FXML
    public void handleClickEntrar(MouseEvent event) {
        if (event.getClickCount() > 1) {
            File seleccionado
                    = fxLista.getSelectionModel().getSelectedItem();

            fxRutaActual.setText(seleccionado.getAbsolutePath());
            cargarFiles();

        }
    }

    @FXML
    public void handleVolver(ActionEvent event) {

        fxRutaActual.getParent();
        File ete = new File(rutaactual);
        fxRutaActual.setText(fxRutaActual.getText() + "\\..");
        cargarFiles();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rutaactual = ("/home/daw");
        fxRutaActual.setText(rutaactual);
        cargarFiles();
    }

    private void cargarFiles() {
        File f = new File(fxRutaActual.getText());
        fxLista.getItems().clear();
        fxLista.getItems().addAll(f.listFiles());
    }
}
