/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import RSS.Configuration;
import RSS.Item;
import RSS.Rss;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import main.NewFXMain;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class FXMLNoticiasController implements Initializable {

    private FXMLNoticiasController controller;
    @FXML
    private Label fxTitulo;
    private String titulo;
 
    @FXML
    private ImageView fximagen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CargarRSS();
    }

    public void setController(FXMLNoticiasController controller) {
        this.controller = controller;
    }

    public void CargarRSS() {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);

            Unmarshaller um = jaxbContext.createUnmarshaller();

            Configuration c = new Configuration();
            for (String url : c.getUrls()) {

                Rss p = (Rss) um.unmarshal(new URL(url));
                titulo=p.channel.getTitle();
                fxTitulo.setText(titulo);

//                for (Item i : p.channel.getItem()) {
//                    tituloPri=i.getTitle();
//                    fxTituloPri.setText(tituloPri);
//                }
            }
        } catch (JAXBException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
