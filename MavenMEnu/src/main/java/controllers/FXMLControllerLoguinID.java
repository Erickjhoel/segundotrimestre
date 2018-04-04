package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FXMLControllerLoguinID implements Initializable {
private FXMLMENUController controller;
    /**
     * Initializes the controller class.
     */
@FXML
private TextField Loguin;
        @FXML
    private void clickAltaEmpleado(ActionEvent event) throws IOException {

       

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setController(FXMLMENUController controller){
        this.controller=controller;
    }
}
