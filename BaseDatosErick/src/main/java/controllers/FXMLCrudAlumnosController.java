/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ConexionSimpleBD;
import java.awt.event.MouseEvent;
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
import javafx.scene.control.ToggleGroup;
import model.Alumno;
import model.Asignaturas;

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
    @FXML
    private ToggleGroup fxtipo;

    List<Alumno> ete;

    private void cargarFiles() {
        fxLista.getItems().clear();
        fxLista.getItems().addAll(ete);
    }

    @FXML
    private void borrar(ActionEvent event) throws IOException {
        Alumno eliminar = fxLista.getSelectionModel().getSelectedItem();
        int id= eliminar.getId();
        c.DeleteAlumnoJDBC(eliminar,id);
        fxLista.refresh();
    }

    @FXML
    private void actualizar(ActionEvent event) throws IOException {
        Date fecha;
        String tipo;
        String mayor = "Mayor";
        Alumno modificado = fxLista.getSelectionModel().getSelectedItem();//alumno seleccionado
        modificado.setNombre(fxnombre.getText());
        fecha = java.sql.Date.valueOf(fxfecha.getValue());//date /localdate
        modificado.setFecha_nacimiento(fecha);
        boolean opcion;
        tipo = ((RadioButton) fxtipo.getSelectedToggle()).getText();
        if (tipo.equals(mayor)) {
            opcion = true;
        } else {
            opcion=false;
        }
        modificado.setMayor_edad(opcion);
        c.updateAlumnoJDBC(modificado);
        fxLista.refresh();
    }

    @FXML
    private void insertar(ActionEvent event) throws IOException {
        String tipo;
        String nombre;
        Date fecha;
        String mayor="Mayor";
        nombre=fxnombre.getText();
        fecha=java.sql.Date.valueOf(fxfecha.getValue());
        boolean opcion;
        tipo = ((RadioButton) fxtipo.getSelectedToggle()).getText();
        if (tipo.equals(mayor)) {
            opcion = true;
        } else {
            opcion=false;
        }
        
        Alumno nuevo= new Alumno();
        nuevo.setNombre(nombre);
        nuevo.setFecha_nacimiento(fecha);
        nuevo.setMayor_edad(opcion);
        c.insertAlumnoJDBC(nuevo);
        fxLista.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ete = c.getAllAlumnoJDBC();//hace la selec* form alumnos
        cargarFiles();

    }

    public void setControllerAlum(FXMLMenuController controllerAlum) {
        this.controllerAlum = controllerAlum;
    }

}
