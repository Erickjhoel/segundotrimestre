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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
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
        boolean vacio = false;
        if (event.getClickCount() > 1) {
            File seleccionado = fxLista.getSelectionModel().getSelectedItem();

            if (seleccionado.isDirectory()) {//si es directorio
                vacio = false;
                fxRutaActual.setText(seleccionado + "");

                if (seleccionado.listFiles().length == 0) {// si esta vacio
                    vacio = true;
                }
                if (vacio == true) {
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "El Directorio esta vacio", ButtonType.CLOSE);
                    b.showAndWait();
                }
                cargarFiles();
            } else if (!seleccionado.isDirectory()) {
                Alert b = new Alert(Alert.AlertType.ERROR, "Esto no es un directorio", ButtonType.CLOSE);
                b.showAndWait();
            }

        }
    }

    @FXML
    public void handleVolver(ActionEvent event) {

        File ete = new File(fxRutaActual.getText());
        if (ete.getParent() == null) {
            Alert b = new Alert(Alert.AlertType.ERROR, "No se puede volver atras", ButtonType.CLOSE);
            b.showAndWait();
        } else {
            fxRutaActual.setText(ete.getParent());
            cargarFiles();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rutaactual = ("/home/daw");
        fxRutaActual.setText(rutaactual);
        fxLista.setCellFactory(list -> new ListCell<File>() {

            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item.getName());
                    if (item.isDirectory()) {
                        setStyle("-fx-text-fill:green;");
                    } else {
                        setStyle("-fx-text-fill:black;");
                    }
                }
            }
        });
        cargarFiles();
    }

    private void cargarFiles() {

        File f = new File(fxRutaActual.getText());
        if (f.isDirectory()) {
            fxLista.getItems().clear();
            fxLista.getItems().addAll(f.listFiles());
        } else {
        }
    }
}
