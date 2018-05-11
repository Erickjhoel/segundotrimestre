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
 * @author daw
 */
public class FXMLEnlasarAlumAsigController implements Initializable {
private FXMLMenuController controllerEnlace;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setControllerEnlace(FXMLMenuController controllerEnlace) {
        this.controllerEnlace = controllerEnlace;
    }
    
}
