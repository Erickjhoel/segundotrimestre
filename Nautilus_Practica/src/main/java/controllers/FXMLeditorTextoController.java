package controllers;

import com.google.common.io.CharSink;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLeditorTextoController implements Initializable {

    private FXMLcomunController comunController;

    @FXML
    private TextArea fxCajaTexto;

    @FXML
    private Label fxLabelarchivoActual;

    @FXML
    public void verTexto() throws FileNotFoundException, IOException {
        File actual = this.comunController.getArchivoActual();
        
        fxCajaTexto.setText(CharStreams.toString(new FileReader(actual)));
        fxLabelarchivoActual.setText(actual.getName());
    }

    @FXML
    public void guardarArchivoTexto() throws IOException {
        File file = this.comunController.getArchivoActual();        
        String textoCaja = fxCajaTexto.getText(); 
        
        CharSink sink = Files.asCharSink(file, Charset.forName("UTF-8"));
        sink.write(textoCaja);
    }

    @FXML
    public void guardarArchivoTextoYSalir() throws IOException {
        guardarArchivoTexto();
        clickVolverAlNavegador();
    }

    public void clickVolverAlNavegador() throws IOException {
        this.comunController.ponerNavegador();
    }

    public FXMLcomunController getComunController() {
        return comunController;
    }

    public void setComunController(FXMLcomunController comunController) {
        this.comunController = comunController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
