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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Alumno;
import model.Asignaturas;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLCrudController implements Initializable {

    private FXMLMenuController controllerAsig;
    ConexionSimpleBD c = new ConexionSimpleBD();
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
    private ListView<Asignaturas> fxLista;

    List<Asignaturas> ete;

    private void cargarFiles() {
        fxLista.getItems().clear();
        fxLista.getItems().addAll(ete);
    }

    @FXML
    private void insertar(ActionEvent event) throws IOException {
    }

    @FXML
    private void eliminar(ActionEvent event) throws IOException {
        Asignaturas eliminar= fxLista.getSelectionModel().getSelectedItem();
        c.DeleteAsignaturaJDBC(eliminar);
        fxLista.refresh();
        
    }

    @FXML
    private void actualizar(ActionEvent event) throws IOException {//PREGUNTAR PORQUE VERGA SE ACTUALIZA TODA LA TABLA
        Asignaturas modificable = fxLista.getSelectionModel().getSelectedItem();
        modificable.setNombre(fxnombre.getText());
        modificable.setCurso(fxcurso.getText());
        modificable.setCiclo(fxciclo.getText());
        c.updateAsignaturaJDBC(modificable);
        fxLista.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ete = c.getAllAsignaturasJDBC();
        cargarFiles();
    }

    public void setControllerAsig(FXMLMenuController controllerAsig) {
        this.controllerAsig = controllerAsig;
    }

}
