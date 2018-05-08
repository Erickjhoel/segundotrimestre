/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import RSS.Chanel;
import RSS.Configuration;
import RSS.Item;
import RSS.Rss;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
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
    @FXML
    private Label fxprimero;
    @FXML
    private Label fxsegundo;
    @FXML
    private Label fxtercero;
    @FXML
    private Label fxcuarto;
    @FXML
    private ImageView fximagen;
    private String titulo;
    private String tituloLabel;
    int pri = 0;

    ArrayList<String> lista = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image(getClass().getResourceAsStream("/images/FCB.png"));

        fximagen.setImage(image);
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
                titulo = p.channel.getTitle();
                fxTitulo.setText(titulo);

                for (Item i : p.channel.getItem()) {
                    tituloLabel = i.getTitle();
                    lista.add(tituloLabel);
                }

                Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(4), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        fxprimero.setText(lista.get((pri)%lista.size()));
                        fxsegundo.setText(lista.get((pri+1)%lista.size()));
                        fxtercero.setText(lista.get((pri+2)%lista.size()));
                        fxcuarto.setText(lista.get((pri+3)%lista.size()));
                        pri++;
                        pri=pri%lista.size();
                        
                    }
                }));
                fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
                fiveSecondsWonder.play();

            }
        } catch (JAXBException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
