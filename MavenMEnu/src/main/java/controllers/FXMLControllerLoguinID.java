package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FXMLControllerLoguinID implements Initializable {

    private FXMLMENUController controllerLoguin;
    /**
     * Initializes the controller class.
     */

    @FXML
    private TextField fxLoguin;

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "HOLA", ButtonType.CLOSE);
        //final Stage stage = (Stage) fxUser.getScene().getWindow();
        //a.initOwner(stage);
        a.showAndWait();
        Alert b = new Alert(Alert.AlertType.ERROR, "El numero no es valido", ButtonType.CLOSE);

        int empleadoID = Integer.parseInt(fxLoguin.getText());

        //Empleado emp = this.controller.getMerchadona().login(empleadoID);
        switch (this.controllerLoguin.getMerchadona().tipoEmpleado(empleadoID)) {
            case 1:
                this.controllerLoguin.habilitaMenuAdmin();
                break;
            case 2:
                this.controllerLoguin.habilitarCajero();
                break;
            case 3:this.controllerLoguin.habilitarReponedor();
                break;
            case 0:
                a.setContentText("id de usuario no valido");
                a.showAndWait();
                break;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setController(FXMLMENUController controller) {
        this.controllerLoguin = controller;
    }
}
