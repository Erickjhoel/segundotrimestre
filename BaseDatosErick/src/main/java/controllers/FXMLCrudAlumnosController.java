/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ConexionSimpleBD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Alumno;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLCrudAlumnosController implements Initializable {

    ConexionSimpleBD c = new ConexionSimpleBD();
    /**
     * Initializes the controller class.
     */

    @FXML
    private ListView<Alumno> fxLista;

    List<Alumno> ete;

    private void cargarFiles() {
        fxLista.getItems().clear();
        fxLista.getItems().addAll(ete);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ete = c.getAllAlumnoJDBC();
        cargarFiles();
    }

}
