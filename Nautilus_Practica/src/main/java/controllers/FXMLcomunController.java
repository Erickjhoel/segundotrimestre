package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class FXMLcomunController implements Initializable {

    private File archivoActual;

    @FXML
    private BorderPane fxRoot;

    @FXML
    public void ponerNavegador() throws IOException {
        AnchorPane anchor;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLexplorador.fxml"));
        anchor = loader.load();
        FXMLexploradorController controller = loader.getController();
        controller.setComunController(this);  
        
        if (archivoActual != null) {
            controller.setTexto_FxLabelRutaActual(archivoActual.getParent());
            controller.cargarFiles();
        }

        fxRoot.setCenter(anchor);
    }

    @FXML
    public void ponerVisorImagenes(String path) throws IOException {
        AnchorPane anchor;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLvisorIMGs.fxml"));
        anchor = loader.load();
        FXMLvisorIMGsController controller = loader.getController();
        controller.setComunController(this); 

        controller.verImagen(path);
        fxRoot.setCenter(anchor);
    }

    @FXML
    public void ponerVisorPDF(String path) throws IOException {
        AnchorPane anchor;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLvisorPDFs.fxml"));
        anchor = loader.load();
        FXMLvisorPDFsController controller = loader.getController();
        controller.setComunController(this); 

        controller.verPDF(path);
        fxRoot.setCenter(anchor);
    }

    @FXML
    public void ponerEditorTexto() throws IOException {
        AnchorPane anchor;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLeditorTexto.fxml"));
        anchor = loader.load();
        FXMLeditorTextoController controller = loader.getController();
        controller.setComunController(this);  

        controller.verTexto();
        fxRoot.setCenter(anchor);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public File getArchivoActual() {
        return archivoActual;
    }

    public void setArchivoActual(File archivoActual) {
        this.archivoActual = archivoActual;
    }
}
