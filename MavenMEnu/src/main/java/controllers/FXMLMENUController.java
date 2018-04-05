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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import serviciosMerchadona.Merchadona;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLMENUController implements Initializable {

    private Merchadona merchadona;
    private AnchorPane loguin;
    private int empleadoID;
    
    @FXML
    private MenuBar fxMenu;
@FXML
    private BorderPane fxRoot;
    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    public void handleScene1(ActionEvent event) throws IOException {

        fxRoot.setCenter(loguin);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxRoot.setCenter(loguin);
        try {
            fxMenu.setVisible(true);
            merchadona = new Merchadona();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_LOGUINID));
            loguin= loader.load();
            FXMLControllerLoguinID controller = loader.getController();
            controller.setController(this);

            
        } catch (IOException ex) {
            Logger.getLogger(FXMLMENUController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Merchadona getMerchadona() {
        return merchadona;
    }

    public void setMerchadona(Merchadona merchadona) {
        this.merchadona = merchadona;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }
    

}
