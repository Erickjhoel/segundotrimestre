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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Alumno;
import model.Asignaturas;
import servicios.AlumnosServicios;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLCrudAlumnosController implements Initializable {

    private FXMLMenuController controllerAlum;
    private AlumnosServicios servicios;
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

    

    private void cargarFiles() {
        fxLista.getItems().clear();
        fxLista.getItems().addAll(servicios.getAllAlumnos());
    }

    @FXML
    private void borrar(ActionEvent event) throws IOException {//se elimina por id , se pasa la id
        Alumno eliminar = fxLista.getSelectionModel().getSelectedItem();
        int id= eliminar.getId();//EL ID DEL ALUMNNO A ELIMINAR
//        ete.remove(eliminar);//es una lista intermedia hay que añadirlo al fxList
        fxLista.getItems().remove(eliminar);
        servicios.getBorrarAlum(id);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Alumno eliminado", ButtonType.CLOSE);
                        b.showAndWait();
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
        tipo = ((RadioButton) fxtipo.getSelectedToggle()).getText();//para el radio button
        //esto sirve igual que el( si el tipo.equals(mayor) opcion=true else mayor = false)///////
        opcion = tipo.equals(mayor);
        //////////////////////////////////////////////////////////////////////////////////////////
        modificado.setMayor_edad(opcion);
        servicios.getActualizarAlum(modificado);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Alumno Actualizado", ButtonType.CLOSE);
                        b.showAndWait();
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
        //esto sirve igual que el( si el tipo.equals(mayor) opcion=true else mayor = false)///////
        opcion = tipo.equals(mayor);
        //////////////////////////////////////////////////////////////////////////////////////////
        Alumno nuevo= new Alumno();
        nuevo.setNombre(nombre);
        nuevo.setFecha_nacimiento(fecha);
        nuevo.setMayor_edad(opcion);
//        ete.add(nuevo);//es una lista intermedia hay que añadirlo al fxList
        fxLista.getItems().add(nuevo);
        servicios.getInsertAlum(nuevo);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Alumno Insertado", ButtonType.CLOSE);
                        b.showAndWait();
        fxLista.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        servicios=new AlumnosServicios();
        cargarFiles();

    }

    public void setControllerAlum(FXMLMenuController controllerAlum) {
        this.controllerAlum = controllerAlum;
    }

}
