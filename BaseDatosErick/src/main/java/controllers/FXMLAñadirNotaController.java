/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Alumno;
import model.Asignatura;
import model.Notas;
import servicios.AlumnosServicios;
import servicios.AsignaturasServicios;
import servicios.NotasServicios;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLAñadirNotaController implements Initializable {

    private FXMLMenuController controllerNota;
    private AlumnosServicios alum;
    private AsignaturasServicios asig;
    private NotasServicios notis;
    @FXML
    private ComboBox<Asignatura> comboAsignaturas;
    @FXML
    private TextField fxnotacambio;
    @FXML
    private ListView<Alumno> fxListaAlumnos;
    private ListView<Notas> fxnotas;

    /**
     * Initializes the controller class.
     */
    private void cargarBox() {
        for (Asignatura ete : asig.getAllAsignatura()) {
            comboAsignaturas.getItems().add(ete);
        }
    }

    @FXML
    private void cambiar(ActionEvent event) throws IOException {
        Asignatura cambio = comboAsignaturas.getSelectionModel().getSelectedItem();
        notis.getCambiarBox(cambio);
        fxListaAlumnos.getItems().addAll(notis.getCambiarBox(cambio));
    }

    @FXML
    private void introducil(ActionEvent event) throws IOException {
        Alumno modificable = fxListaAlumnos.getSelectionModel().getSelectedItem();
        Notas cambiar= fxnotas.getSelectionModel().getSelectedItem();
        cambiar.setNota(fxnotacambio.getLength());
        notis.CambiaNota(cambiar);
        Alert b = new Alert(Alert.AlertType.INFORMATION, "Asignatura Actualizada", ButtonType.CLOSE);
        b.showAndWait();
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        asig = new AsignaturasServicios();
        alum = new AlumnosServicios();
        notis = new NotasServicios();
        fxnotas= new ListView<>();
        cargarBox();
    }

    public void setControllerNota(FXMLMenuController controllerNota) {
        this.controllerNota = controllerNota;
    }

}
