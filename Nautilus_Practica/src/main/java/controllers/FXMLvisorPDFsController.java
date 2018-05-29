package controllers;

import com.qoppa.pdf.PDFException;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLvisorPDFsController implements Initializable {

    private FXMLcomunController comunController;

    @FXML
    private PDFViewer fxPdfViewer;

    @FXML
    public void verPDF(String path) throws FileNotFoundException {

        try {
            fxPdfViewer.loadPDF(new FileInputStream(path));
        } catch (Exception ex) {
            Logger.getLogger(FXMLvisorPDFsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void clickVolverAlNavegador(ActionEvent event) throws IOException {
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
