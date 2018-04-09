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
import javafx.scene.control.TextField;
import modeloMerchadona.Cajera;
import modeloMerchadona.Producto;
import modeloMerchadona.Reponedor;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLCajeroController implements Initializable {

    private FXMLMENUController controllerCajero;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private ListView<Producto> fxlistaventa;

    public void Listavender() {
        fxlistaventa.getItems().clear();
        fxlistaventa.getItems().addAll(
                this.controllerCajero.getMerchadona().listaProductos2());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setController(FXMLMENUController controller) {
        this.controllerCajero = controller;
    }
}
