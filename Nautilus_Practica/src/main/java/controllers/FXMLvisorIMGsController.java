package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FXMLvisorIMGsController implements Initializable {

    private FXMLcomunController comunController;

    @FXML
    private ImageView fxImagen;

    @FXML
    public void verImagen(String path) throws FileNotFoundException {       
        Image image = new Image(new FileInputStream(path));
        fxImagen.setImage(image);
    }

    public void clickVolverAlNavegador() throws IOException {  
        this.comunController.ponerNavegador();             
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public FXMLcomunController getComunController() {
        return comunController;
    }

    public void setComunController(FXMLcomunController comunController) {
        this.comunController = comunController;
    }

}
