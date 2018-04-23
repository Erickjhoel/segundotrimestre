/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.qoppa.pdf.PDFException;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLPDFController implements Initializable {

    private FXMLPrincipalController controllerpdf;

    @FXML
    private PDFViewer fxPdfViewer;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void volverAtras(ActionEvent event) {
        controllerpdf.pantallaVolverPrincipal();
    }

    public void cargarPDF() throws FileNotFoundException {
        try {
            String path = controllerpdf.getRuta();
            fxPdfViewer.loadPDF(new FileInputStream(path));

        } catch (PDFException ex) {
            Logger.getLogger(FXMLPDFController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLPDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setControllerpdf(FXMLPrincipalController controllerpdf) {
        this.controllerpdf = controllerpdf;
    }

}
