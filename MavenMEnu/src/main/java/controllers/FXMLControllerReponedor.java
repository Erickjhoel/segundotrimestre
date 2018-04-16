/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modeloMerchadona.Producto;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLControllerReponedor implements Initializable {

    private FXMLMENUController controllerReponedor;
    @FXML
    private TextField fxcantidadRep;
    private int cantidad;
    private int id;

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<Producto> fxlistareponer;
    @FXML
    private void clickAddCesta(ActionEvent event) {
        id = this.controllerReponedor.getEmpleadoID();
        cantidad = Integer.parseInt(fxcantidadRep.getText());
        Producto p = fxlistareponer.getSelectionModel().getSelectedItem();
        this.controllerReponedor.getMerchadona().reponerProducto(id, cantidad, p);
        Listavender();
    }

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
