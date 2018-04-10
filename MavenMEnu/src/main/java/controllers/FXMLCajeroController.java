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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
     @FXML
    private TextField fxcantidad;
     private int cantidad;
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
    @FXML
    private void clickVender(ActionEvent event) throws IOException {
        cantidad=Integer.parseInt(fxcantidad.getText());
        int id=this.controllerCajero.getEmpleadoID();
         Producto p = fxlistaventa.getSelectionModel().getSelectedItem();
         
         int error = this.controllerCajero.getMerchadona().venderProducto(id, id, p);
        switch (error) {
            case 1:
                Alert a = new Alert(Alert.AlertType.INFORMATION, "STOCK INSUFICIENTE", ButtonType.CLOSE);

                a.showAndWait();
                break;
            case 2:
                a = new Alert(Alert.AlertType.INFORMATION, "Producto caducado", ButtonType.CLOSE);

                a.showAndWait();
                break;
        }
        Listavender();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setController(FXMLMENUController controller) {
        this.controllerCajero = controller;
    }
}
