/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import constantesMerchadona.Constante;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import serviciosMerchadona.Funcionalidad;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLMENUController implements Initializable {

    private Funcionalidad merchadona;
    private AnchorPane loguin;
    
    @FXML
    private MenuBar fxMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fxMenu.setVisible(true);
            merchadona = new Funcionalidad();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_LOGUINID));
            loguin = loader.load();
            FXMLControllerLoguinID controller = loader.getController();
            controller.setController(this);
            
            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_LOGUINID));
            loguin = loader.load();
            FXMLControllerAdministrador controller = loader.getController();
            controller.setController(this);
           
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLMENUController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Funcionalidad getMerchadona() {
        return merchadona;
    }

    public void setMerchadona(Funcionalidad merchadona) {
        this.merchadona = merchadona;
    }

}
