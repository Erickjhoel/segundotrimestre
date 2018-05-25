/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import model.Alumno;
import model.Asignatura;
import servicios.AlumnosServicios;
import servicios.AsignaturasServicios;
import servicios.NotasServicios;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLEnlasarAlumAsigController implements Initializable {

    private FXMLMenuController controllerEnlace;
    private AlumnosServicios alum;
    private AsignaturasServicios asig;
    private NotasServicios notis;

    @FXML
    private ListView<Alumno> fxListaAlum;
    @FXML
    private ListView<Asignatura> fxListaAsign;

    /**
     * Initializes the controller class.
     */
    private void cargarFiles() {
        fxListaAlum.getItems().clear();
        fxListaAlum.getItems().addAll(alum.getAllAlumnos());

        fxListaAsign.getItems().clear();
        fxListaAsign.getItems().addAll(asig.getAllAsignatura());
    }

    @FXML
    private void Añadil(ActionEvent event) throws IOException {
        Alumno nuevo = fxListaAlum.getSelectionModel().getSelectedItem();
        Asignatura nueva = fxListaAsign.getSelectionModel().getSelectedItem();
        notis.getInsertAlum(nuevo, nueva);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Se ha añadido el alumno a la asignatura", ButtonType.CLOSE);
        b.showAndWait();
    }

    @FXML
    private void EliminarAlumno(ActionEvent event) throws IOException {
        Alumno eliminal = fxListaAlum.getSelectionModel().getSelectedItem();

        Alert seguridad = new Alert(Alert.AlertType.CONFIRMATION, "Esta seguro que quiere eliminar al alumno");
        Optional<ButtonType> result = seguridad.showAndWait();
        if (result.get() == ButtonType.OK) {
            notis.getEliminarAlum(eliminal);
            fxListaAlum.getItems().remove(eliminal);
            Alert b = new Alert(Alert.AlertType.INFORMATION, "Se ha eliminado el alumno ", ButtonType.CLOSE);
            b.showAndWait();
        } else {
            Alert c = new Alert(Alert.AlertType.INFORMATION, "El alumno no se ha eliminado ", ButtonType.CLOSE);
            c.showAndWait();
        }

        fxListaAlum.refresh();

    }
    

    @FXML
    private void EliminarAsignatura(ActionEvent event) throws IOException {
        Asignatura eliminal = fxListaAsign.getSelectionModel().getSelectedItem();
        Alert seguridad = new Alert(Alert.AlertType.CONFIRMATION, "Esta seguro que quiere eliminar esta asignatura");
        Optional<ButtonType> result = seguridad.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                notis.getEliminarAsig(eliminal);
                fxListaAsign.getItems().remove(eliminal);
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Se ha eliminado la asignatura ", ButtonType.CLOSE);
                b.showAndWait();
            } catch (Exception ex) {
                Logger.getLogger(FXMLEnlasarAlumAsigController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert c = new Alert(Alert.AlertType.INFORMATION, "La asignatura no se ha eliminado ", ButtonType.CLOSE);
            c.showAndWait();
        }

        fxListaAlum.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alum = new AlumnosServicios();
        asig = new AsignaturasServicios();
        notis = new NotasServicios();
        cargarFiles();
    }

    public void setControllerEnlace(FXMLMenuController controllerEnlace) {
        this.controllerEnlace = controllerEnlace;
    }

}
