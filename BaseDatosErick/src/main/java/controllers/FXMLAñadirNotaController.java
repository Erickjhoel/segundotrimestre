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
public class FXMLAñadirNotaController implements Initializable {
private FXMLMenuController controllerNota;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setControllerNota(FXMLMenuController controllerNota) {
        this.controllerNota = controllerNota;
    }
    
}
