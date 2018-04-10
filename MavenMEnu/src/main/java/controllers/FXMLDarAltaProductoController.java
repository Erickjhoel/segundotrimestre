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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FXMLDarAltaProductoController implements Initializable {

    private FXMLMENUController controllerDarAltaProducto;
    private String nombre;
    private double precio;
    private String opcion;
    @FXML
    private TextField fxNombreProducto;
    @FXML
    private TextField fxNombreProductoEliminar;
    @FXML
    private TextField fxPrecio;

    @FXML
    private RadioButton fxopcion1;

    /**
     * Initializes the controller class.
     *
     */
    @FXML
    private void clickAltaEmpleado(ActionEvent event) throws IOException {

        nombre = fxNombreProducto.getText();

        precio = Integer.parseInt(fxPrecio.getText());

        String PERECEDERO = null;

        int oopcionfinal;
        opcion = fxopcion1.getText();
        if (opcion == PERECEDERO) {//radio button devuelve string con el nombre que tenga
            oopcionfinal = 2;
        } else {
            oopcionfinal = 1;
        }

        boolean altaOk = this.controllerDarAltaProducto.getMerchadona().darAltaProducto(nombre, precio, oopcionfinal);

        if (altaOk) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Alta OK", ButtonType.CLOSE);
//            final Stage stage = (Stage) fxUser.getScene().getWindow();
//            a.initOwner(stage);
            a.showAndWait();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "El id ya existe", ButtonType.CLOSE);
            //final Stage stage = (Stage) fxUser.getScene().getWindow();
            //a.initOwner(stage);
            a.showAndWait();
        }

    }

    @FXML
    private void clickBajaEmpleado(ActionEvent event) throws IOException {

        nombre = fxNombreProductoEliminar.getText();
        boolean darbaja = this.controllerDarAltaProducto.getMerchadona().darBajaProducto(nombre);

        if (darbaja) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Baja OK", ButtonType.CLOSE);
            //final Stage stage = (Stage) fxUser.getScene().getWindow();
            //a.initOwner(stage);
            a.showAndWait();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "El id ya existe", ButtonType.CLOSE);
            //final Stage stage = (Stage) fxUser.getScene().getWindow();
            //a.initOwner(stage);
            a.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setController(FXMLMENUController controller) {
        this.controllerDarAltaProducto = controller;
    }
}
