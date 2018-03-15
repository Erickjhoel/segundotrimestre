/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.security.ntlm.Client;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLETEController implements Initializable {

    List<Cliente> clientes;
    private int indice = 0;

    @FXML
    private TextField fxcajatexto;
    @FXML
    private TextField fxcajatextoedad;

    @FXML
    private Button fxBotonHola;
    @FXML
    private Button fxExterminar;
    @FXML
    private Button fxBotonIzquierda;
    @FXML
    private Button fxBotonDerecha;

    private String nombre;
    private int edad;

    @FXML
    public void handleCapturarunEvento(ActionEvent event) throws IOException {

        nombre = fxcajatexto.getText();
        edad = Integer.parseInt(fxcajatextoedad.getText());
        Cliente ete = new Cliente(nombre, edad);
        clientes.add(ete);
//        fxcajatextoedad.setText(edad);
//        Alert a= new Alert(Alert.AlertType.INFORMATION,texto, ButtonType.CLOSE);
//        a.showAndWait();
    }

    @FXML
    public void handleExterminarEvento(ActionEvent event) throws IOException {
        if(indice==clientes.size()){
            indice=clientes.size()-1;
            clientes.remove(indice);
        }
         clientes.remove(indice);
    }

    @FXML
    public void handleCapturarunEventoIzquierda(ActionEvent event) throws IOException {
        indice--;
        if (indice >=0) {
            fxcajatexto.setText(clientes.get(indice).getNombre());
            fxcajatextoedad.setText("" + clientes.get(indice).getEdad());
            fxBotonDerecha.setDisable(false);
        } else {
            fxBotonIzquierda.setDisable(true);
        }
    }

    @FXML
    public void handleCapturarunEventoDerecha(ActionEvent event) throws IOException {
        indice++;
        if (indice < clientes.size()) {
            fxcajatexto.setText(clientes.get(indice).getNombre());
            fxcajatextoedad.setText("" + clientes.get(indice).getEdad());
            fxBotonIzquierda.setDisable(false);
        } else {
            fxBotonDerecha.setDisable(true);
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clientes = new LinkedList<>();
        clientes.add(new Cliente("pepe", 5));
        clientes.add(new Cliente("javier", 50));
        clientes.add(new Cliente("juan", 100));
        clientes.add(new Cliente("jacinto", 500));
        clientes.add(new Cliente("aurelio", 250));
        clientes.add(new Cliente("amador", 2));
        clientes.add(new Cliente("teodoro", 3));
    }

}
