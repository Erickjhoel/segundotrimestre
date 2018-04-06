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
import javafx.scene.control.Menu;
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
    private AnchorPane admin;
    private AnchorPane cajero;
    private int empleadoID;
    @FXML
    private Menu fxAdmin;
    @FXML
    private Menu fxCajero;
    @FXML
    private MenuBar fxMenu;
    @FXML
    private BorderPane fxRoot;

    /**
     * Initializes the controller class.
     *
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    public void handleScene1(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            merchadona = new Merchadona();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_LOGUINID));
            loguin = loader.load();
            FXMLControllerLoguinID controller = loader.getController();
            controller.setController(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_ADMIN));
            admin = loader.load();
            FXMLControllerAdministrador controllerAdmin = loader.getController();
            controllerAdmin.setController(this);
            
            
            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_CAJERA));
            cajero = loader.load();
            FXMLCajeroController controllerCajero = loader.getController();
            controllerCajero.setController(this);

        } catch (IOException ex) {
            Logger.getLogger(FXMLMENUController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxMenu.setVisible(false);//desactiva el menu
        fxRoot.setCenter(loguin);//solo coloca la pantalla de loguin

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

    public void habilitaMenuAdmin() {
        fxRoot.setCenter(admin);
        fxMenu.setVisible(true);
        fxAdmin.setVisible(true);
    }
    public void habilitarCajero(){
        fxRoot.setCenter(cajero);
        fxMenu.setVisible(true);
        fxCajero.setVisible(true);
    }

}
