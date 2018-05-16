/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ConexionSimpleBD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Alumno;
import model.Asignatura;
import servicios.AsignaturasServicios;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLCrudController implements Initializable {

    private FXMLMenuController controllerAsig;
    private AsignaturasServicios servicios;
    @FXML
    private TextField fxnombre;
    @FXML
    private TextField fxcurso;
    @FXML
    private TextField fxciclo;
    /**
     * Initializes the controller class.
     */

    @FXML
    private ListView<Asignatura> fxLista;

    private void cargarFiles() {
        fxLista.getItems().clear();
        fxLista.getItems().addAll(servicios.getAllAsignatura());
    }

    @FXML
    private void insertar(ActionEvent event) throws IOException {
        String nombre;
        String curso;
        String ciclo;
        nombre=fxnombre.getText();
        curso=fxcurso.getText();
        ciclo=fxciclo.getText();
        Asignatura nueva= new Asignatura();
        nueva.setNombre(nombre);
        nueva.setCurso(curso);
        nueva.setCiclo(ciclo);
        fxLista.getItems().add(nueva);
        servicios.getInsertAsignatura(nueva);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Asignatura Insertada", ButtonType.CLOSE);
                        b.showAndWait();
        fxLista.refresh();
    }

    @FXML
    private void eliminar(ActionEvent event) throws IOException {
        Asignatura eliminar= fxLista.getSelectionModel().getSelectedItem();
        int id= eliminar.getId();
        fxLista.getItems().remove(eliminar);
        servicios.getBorrarAsignatura(id);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Asignatura Eliminada", ButtonType.CLOSE);
                        b.showAndWait();
        fxLista.refresh();
        
    }

    @FXML
    private void actualizar(ActionEvent event) throws IOException {//PREGUNTAR PORQUE VERGA SE ACTUALIZA TODA LA TABLA
        Asignatura modificable = fxLista.getSelectionModel().getSelectedItem();
        modificable.setNombre(fxnombre.getText());
        modificable.setCurso(fxcurso.getText());
        modificable.setCiclo(fxciclo.getText());
        servicios.getActualizarAsignatura(modificable);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Asignatura Actualizada", ButtonType.CLOSE);
                        b.showAndWait();
        fxLista.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicios = new AsignaturasServicios();
        cargarFiles();
    }

    public void setControllerAsig(FXMLMenuController controllerAsig) {
        this.controllerAsig = controllerAsig;
    }

}
