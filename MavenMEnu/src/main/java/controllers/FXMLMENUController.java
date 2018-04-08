/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import constantesMerchadona.Constante;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import serviciosMerchadona.Merchadona;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLMENUController implements Initializable {

    private Merchadona merchadona;
    private FXMLListadoController listaEmpleados;
    private FXMLListadoProductosController listaProductos;
    private AnchorPane adminAltaEmpleado;
    private AnchorPane adminAltaProducto;
    private AnchorPane adminListado;
    private AnchorPane adminListadoProductos;
    private AnchorPane cajero;
    private AnchorPane reponedor;
    private int empleadoID;
    @FXML
    private Menu fxAdmin;
    @FXML
    private Menu fxCajero;
    @FXML
    private Menu fxReponedor;
    @FXML
    private MenuBar fxMenu;
    @FXML
    private BorderPane fxRoot;

    /**
     * Initializes the controller class.
     *
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    public void handleScene1(ActionEvent event) throws IOException {
        fxRoot.setCenter(adminAltaEmpleado);
    }

    @FXML
    public void handleScene2(ActionEvent event) throws IOException {
        fxRoot.setCenter(adminAltaProducto);
    }

    @FXML
    public void handleScene3(ActionEvent event) throws IOException {
        fxRoot.setCenter(adminListado);
        listaEmpleados.ListaDatosEmple();
        
    }
    @FXML
    public void handleScene4(ActionEvent event) throws IOException {
        fxRoot.setCenter(adminListadoProductos);
        listaProductos.ListaDatosProduc();
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            merchadona = new Merchadona();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_ADMIN_ALTA_EMPLEADO));
            adminAltaEmpleado = loader.load();
            FXMLControllerDarAltaEmpleado controllerAdmin = loader.getController();
            controllerAdmin.setController(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_ADMIN_ALTA_PRODUCTO));
            adminAltaProducto = loader.load();
            FXMLDarAltaProductoController controllerAdmin2 = loader.getController();
            controllerAdmin2.setController(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_LISTADO_PRODUCTOS));
            adminListadoProductos = loader.load();
            listaProductos = loader.getController();
            listaProductos.setController(this);
            
            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_LISTADO));
            adminListado = loader.load();
            listaEmpleados = loader.getController();
            listaEmpleados.setController(this);

            loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_REPONEDOR));
            reponedor = loader.load();
            FXMLControllerReponedor controllerReponedor = loader.getController();
            controllerReponedor.setController(this);

        } catch (IOException ex) {
            Logger.getLogger(FXMLMENUController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxMenu.setVisible(false);//desactiva el menu

    }

    public Merchadona getMerchadona() {
        return merchadona;
    }

    public void setMerchadona(Merchadona merchadona) {
        this.merchadona = merchadona;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public void habilitaMenuAdmin() {
        fxMenu.setVisible(true);
        fxAdmin.setVisible(true);
        fxCajero.setVisible(false);
        fxReponedor.setVisible(false);
    }

    public void habilitarCajero() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(Constante.PANTALLA_CAJERA));
            cajero = loader.load();
            
            FXMLCajeroController controllerCajero = loader.getController();
            controllerCajero.setController(this);
            fxRoot.setCenter(cajero);

        } catch (IOException ex) {
            Logger.getLogger(FXMLMENUController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxRoot.setCenter(cajero);
        fxAdmin.setVisible(false);
        fxReponedor.setVisible(false);
        fxMenu.setVisible(true);
        fxCajero.setVisible(true);
    }
        
    

    public void habilitarReponedor() {
        fxRoot.setCenter(reponedor);
        fxAdmin.setVisible(false);
        fxMenu.setVisible(true);
        fxReponedor.setVisible(true);
    }

}
