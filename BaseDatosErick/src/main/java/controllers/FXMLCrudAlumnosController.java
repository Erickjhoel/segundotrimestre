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
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Alumno;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLCrudAlumnosController implements Initializable {

    private FXMLMenuController controllerAlum;
    ConexionSimpleBD c = new ConexionSimpleBD();
    /**
     * Initializes the controller class.
     */

    @FXML
    private ListView<Alumno> fxLista;
    @FXML
    private TextField fxnombre;
    @FXML
    private DatePicker fxfecha;
    @FXML
    private RadioButton fxedad;

    List<Alumno> ete;

    private void cargarFiles() {
        fxLista.getItems().clear();
        fxLista.getItems().addAll(ete);
    }

    @FXML
    private void borrar(ActionEvent event) throws IOException {
    }

    @FXML
    private void actualizar(ActionEvent event) throws IOException {
        Date fecha;
        Alumno modificado =fxLista.getSelectionModel().getSelectedItem();
        modificado.setNombre(fxnombre.getText());
        fecha=java.sql.Date.valueOf(fxfecha.getValue());
        modificado.setFecha_nacimiento(fecha);
        
        c.updateAlumnoJDBC(modificado);
    }

    @FXML
    private void insertar(ActionEvent event) throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ete = c.getAllAlumnoJDBC();
        cargarFiles();
    }

    public void setControllerAlum(FXMLMenuController controllerAlum) {
        this.controllerAlum = controllerAlum;
    }

}
