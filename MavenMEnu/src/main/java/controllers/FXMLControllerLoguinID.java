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
private FXMLMENUController controllerLoguin;
    /**
     * Initializes the controller class.
     */

@FXML
    private TextField fxLoguin;
        @FXML
    private void clickAltaEmpleado(ActionEvent event) throws IOException {

       int empleadoID = Integer.parseInt(fxLoguin.getText());//parseas el tecto metido
        this.controllerLoguin.getMerchadona().login(empleadoID);

        this.controllerLoguin.setEmpleadoID(empleadoID);

        switch (this.controllerLoguin.getMerchadona().tipoEmpleado(empleadoID)) {
            case 1:
                this.controllerLoguin.;
                break;
            case 2:

                break;
            case 3:
                break;

        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setController(FXMLMENUController controller){
        this.controllerLoguin=controller;
    }
}
