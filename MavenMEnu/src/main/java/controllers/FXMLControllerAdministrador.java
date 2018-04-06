/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLControllerAdministrador implements Initializable {

    private FXMLMENUController controllerAdmin;
    @FXML
    private TextField fxIdAñadir;
    @FXML
    private TextField fxNombreAñadir;
    @FXML
    private TextField fxIdEliminar;
    
    @FXML
    private Button fxDarAlta;
    @FXML
    private Button fxDarBaja;
  
    /**
     * Initializes the controller class.
     */
    @FXML
    private void clickAltaEmpleado(ActionEvent event) throws IOException {

        boolean altaOk = this.controllerAdmin.getMerchadona().darAltaEmpleado("juan",2,1);

        if (altaOk) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
//            final Stage stage = (Stage) fxUser.getScene().getWindow();
//            a.initOwner(stage);
            a.showAndWait();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "El id ya existe", ButtonType.CLOSE);
            //final Stage stage = (Stage) fxUser.getScene().getWindow();
            //a.initOwner(stage);
            a.showAndWait();
        }

    }
        @FXML
//    private void clickBajaEmpleado(ActionEvent event) throws IOException {
//
//        boolean darbaja = this.controllerAdmin.getMerchadona().darBajaEmpleado(8);
//
//        if (darbaja==true) {
//            Alert a = new Alert(Alert.AlertType.INFORMATION, "Baja OK", ButtonType.CLOSE);
//            //final Stage stage = (Stage) fxUser.getScene().getWindow();
//            //a.initOwner(stage);
//            a.showAndWait();
//        } else {
//            Alert a = new Alert(Alert.AlertType.ERROR, "El id ya existe", ButtonType.CLOSE);
//            //final Stage stage = (Stage) fxUser.getScene().getWindow();
//            //a.initOwner(stage);
//            a.showAndWait();
//        }
//
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setController(FXMLMENUController controller) {
        this.controllerAdmin = controller;
    }

}
