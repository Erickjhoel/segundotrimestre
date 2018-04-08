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
import modeloMerchadona.Perecedero;
import modeloMerchadona.Producto;
import modeloMerchadona.Reponedor;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FXMLListadoProductosController implements Initializable {
 private FXMLMENUController controllerListaProd;
    /**
     * Initializes the controller class.
     */
 @FXML
    private ListView<Producto> listaProductos;
    @FXML
    private ListView<Perecedero> listaPerecedero;

    public void ListaDatosProduc() {
         listaProductos.getItems().clear();
        listaProductos.getItems().addAll(
                this.controllerListaProd.getMerchadona().listaProductos());

        listaPerecedero.getItems().clear();
        listaPerecedero.getItems().addAll(
                this.controllerListaProd.getMerchadona().listaProductosPerecederos());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
     public void setController(FXMLMENUController controller) {
        this.controllerListaProd = controller;
    }
}
