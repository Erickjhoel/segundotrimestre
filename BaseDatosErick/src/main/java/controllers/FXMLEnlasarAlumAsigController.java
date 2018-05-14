/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import model.Alumno;
import model.Asignaturas;
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
    private ListView<Asignaturas> fxListaAsign;

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
        Alumno nuevo =fxListaAlum.getSelectionModel().getSelectedItem();
        Asignaturas nueva =fxListaAsign.getSelectionModel().getSelectedItem();
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Se ha añadido el alumno a la asignatura", ButtonType.CLOSE);
        b.showAndWait();
        notis.getInsertAlum(nuevo, nueva);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alum=new AlumnosServicios();
        asig=new AsignaturasServicios();
        notis=new NotasServicios();
        cargarFiles();
    }

    public void setControllerEnlace(FXMLMenuController controllerEnlace) {
        this.controllerEnlace = controllerEnlace;
    }

}
