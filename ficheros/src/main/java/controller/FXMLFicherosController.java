/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.common.io.Files;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLFicherosController implements Initializable {

    private FXMLPrincipalController controllerFichero;
    public String rutaactual;
    public String comprobar;
    @FXML
    public Label fxRutaActual;
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
                cargarFiles();

                if (seleccionado.listFiles().length == 0) {// si esta vacio
                    vacio = true;
                }
                if (vacio == true) {
                    Alert b = new Alert(Alert.AlertType.INFORMATION, "El Directorio esta vacio", ButtonType.CLOSE);
                    b.showAndWait();
                }
            } else {
                comprobar = seleccionado.getPath();
                int ultimoPunto = comprobar.lastIndexOf('.');
                String extension = comprobar.substring(ultimoPunto + 1);
                switch (extension) {
                    case "pdf":
                        Alert b = new Alert(Alert.AlertType.INFORMATION, "Estoes un PDF", ButtonType.CLOSE);
                        b.showAndWait();
                        controllerFichero.setRuta(comprobar);
                        controllerFichero.pantallaCargarPDF();
                        break;
                    case "txt":
                        Alert c = new Alert(Alert.AlertType.INFORMATION, "Esto es un Fichero de texto", ButtonType.CLOSE);
                        c.showAndWait();
                        controllerFichero.pantallaCargarTXT();
                        break;
                    case "png":
                        Alert d = new Alert(Alert.AlertType.INFORMATION, "Esto es una imagen", ButtonType.CLOSE);
                        d.showAndWait();
                        controllerFichero.setRuta(comprobar);
                        controllerFichero.pantallaCargarIma();
                        break;
                    case "jpg":
                        Alert e = new Alert(Alert.AlertType.INFORMATION, "Esto es una imagen", ButtonType.CLOSE);
                        e.showAndWait();
                        controllerFichero.setRuta(comprobar);
                        controllerFichero.pantallaCargarIma();
                        break;
                    default:

                }

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
        rutaactual = ("C:/");
        fxRutaActual.setText(rutaactual);
        fxLista.setCellFactory(list -> new ListCell<File>() {

            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item.getName());
                    if (item.isDirectory()) {
                        setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/folder.png"))));
                        setStyle("-fx-text-fill:green;");
                    } else {
                        String comprobar = item.getName();
                        int ultimoPunto = comprobar.lastIndexOf('.');
                        if (ultimoPunto == -1) {
                            setGraphic(null);
                        } else {
                            String extension = comprobar.substring(ultimoPunto + 1);
                            switch (extension) {
                                case "pdf":
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/pdf.png"))));
                                    break;
                                case "txt":
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/txt.png"))));
                                    break;
                                case "png":
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/picture.png"))));
                                    break;
                                case "jpg":
                                    setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/picture.png"))));
                                    break;
                                default:
                                    setGraphic(null);

                            }
                        }
                        setStyle("-fx-text-fill:black;");
                    }
                } else {
                    setGraphic(null);
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

    public void setControllerFichero(FXMLPrincipalController controllerFichero) {
        this.controllerFichero = controllerFichero;
    }

    @FXML
    public void eliminar(ActionEvent event) {
        File delete = fxLista.getSelectionModel().getSelectedItem();
        delete.delete();
        cargarFiles();
    }

    @FXML
    public void renombrar(ActionEvent event) {
        File rename = fxLista.getSelectionModel().getSelectedItem();
        rename.renameTo(new File("reombrado-" + rename));/////esto falta
        cargarFiles();
    }

    @FXML
    public void copiar(ActionEvent event) {
        try {
            File copiar = fxLista.getSelectionModel().getSelectedItem();
            Files.copy(copiar, new File(copiar + "-copia"));
            cargarFiles();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTextoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
