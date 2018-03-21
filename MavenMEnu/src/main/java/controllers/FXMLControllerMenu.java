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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import serviciosMerchadona.Funcionalidad;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLControllerMenu implements Initializable {

    private Funcionalidad merchadona;
    @FXML
    private BorderPane fxRoot;

    @FXML
    public void handleEscena1(ActionEvent event) throws IOException {
        AnchorPane anchor;
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/FXML2.fxml"));
        anchor = loader.load();
        FXMLControllerAdministrador controller = loader.getController();
        controller.setController(this);
        fxRoot.setCenter(anchor);
    }

    @FXML
    public void handleEscena2(ActionEvent event) throws IOException {
        AnchorPane anchor;
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/FXML3.fxml"));
        anchor = loader.load();
        //FXMLSceneController controller = loader.getController();
        fxRoot.setCenter(anchor);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public Funcionalidad getMerchadona() {
        return merchadona;
    }

}
