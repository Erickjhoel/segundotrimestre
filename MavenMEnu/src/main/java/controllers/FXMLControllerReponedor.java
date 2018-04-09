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
import modeloMerchadona.Producto;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLControllerReponedor implements Initializable {
private FXMLMENUController controllerReponedor;
   

    /**
     * Initializes the controller class.
     */
@FXML
    private ListView<Producto> fxlistareponer;

    public void Listavender() {
        fxlistareponer.getItems().clear();
        fxlistareponer.getItems().addAll(
                this.controllerReponedor.getMerchadona().listaProductos2());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void setController(FXMLMENUController controller) {
        this.controllerReponedor = controller;
    }
    
}
