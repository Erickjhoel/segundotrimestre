/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FXMLDarAltaProductoController implements Initializable {
private FXMLMENUController controllerDarAltaProducto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setController(FXMLMENUController controller) {
        this.controllerDarAltaProducto = controller;
    }
}