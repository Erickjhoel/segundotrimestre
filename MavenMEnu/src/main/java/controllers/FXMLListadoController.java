/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import modeloMerchadona.Cajera;
import modeloMerchadona.Reponedor;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLListadoController implements Initializable {

    private FXMLMENUController controllerLista;
    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<Reponedor> fxListReponedor;
    @FXML
    private ListView<Cajera> fxListCajera;

    public void ListaDatosEmple() {
        fxListReponedor.getItems().clear();
        fxListReponedor.getItems().addAll(
                this.controllerLista.getMerchadona().listaReponedor());

        fxListCajera.getItems().clear();
        fxListCajera.getItems().addAll(
                this.controllerLista.getMerchadona().listaCajeras());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setController(FXMLMENUController controller) {
        this.controllerLista = controller;
    }
}
