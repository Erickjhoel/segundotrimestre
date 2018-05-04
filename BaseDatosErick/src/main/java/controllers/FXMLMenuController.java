/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import constantes.Constante;
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

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLMenuController implements Initializable {

    private AnchorPane alumnis;
    private AnchorPane asignaturis;
    @FXML
    private BorderPane fxRoot;
    @FXML
    private MenuBar fxMenu;

    /**
     * Initializes the controller class.
     */

    @FXML
    public void handleScene1(ActionEvent event) throws IOException {
        fxRoot.setCenter(alumnis);
    }

    @FXML
    public void handleScene2(ActionEvent event) throws IOException {
        fxRoot.setCenter(asignaturis);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_ALUMNO));
            alumnis = loader.load();
            FXMLCrudAlumnosController controlleralum = loader.getController();
            controlleralum.setControllerAlum(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_ASIGNATURA));
            asignaturis = loader.load();
            FXMLCrudController controllerasig = loader.getController();
            controllerasig.setControllerAsig(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxMenu.setVisible(true);
    }

}
