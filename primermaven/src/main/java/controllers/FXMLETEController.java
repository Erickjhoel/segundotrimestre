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
    private int indice=0;
    
    @FXML
    private TextField fxcajatexto;
    @FXML
    private TextField fxcajatextoedad;

    @FXML
    private Button fxBotonHola;
    private Button fxBotonIzquierda;
    private Button fxBotonDerecha;
    private String texto = "OLIS";
    private int edad;

    @FXML
    public void handleCapturarunEvento(ActionEvent event) throws IOException {
        indice++;
        fxcajatexto.setText(texto);
//        fxcajatextoedad.setText(edad);
//        Alert a= new Alert(Alert.AlertType.INFORMATION,texto, ButtonType.CLOSE);
//        a.showAndWait();
    }
    @FXML
    public void handleCapturarunEventoIzquierda(ActionEvent event) throws IOException {
    indice--;
    fxcajatexto.setText(clientes.get(indice).getNombre());
    fxcajatextoedad.setText(""+clientes.get(indice).getEdad());
    }
    @FXML
    public void handleCapturarunEventoDerecha(ActionEvent event) throws IOException {
        indice++;
    fxcajatexto.setText(clientes.get(indice).getNombre());
    fxcajatextoedad.setText(""+clientes.get(indice).getEdad());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clientes= new LinkedList<>();
        clientes.add(new Cliente("pepe", 5));
        clientes.add(new Cliente("javier", 50));
        clientes.add(new Cliente("juan", 100));
    }

}
