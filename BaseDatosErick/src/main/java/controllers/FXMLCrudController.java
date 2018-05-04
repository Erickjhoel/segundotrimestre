/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ConexionSimpleBD;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Alumno;
import model.Asignaturas;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLCrudController implements Initializable {
    private FXMLMenuController controllerAsig;
    ConexionSimpleBD c = new    ConexionSimpleBD();
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ete= c.getAllAsignaturasJDBC();
        cargarFiles();
    }    

    public void setControllerAsig(FXMLMenuController controllerAsig) {
        this.controllerAsig = controllerAsig;
    }
    
}
