package controllers;

import com.google.common.io.Files;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLexploradorController implements Initializable {

    private FXMLcomunController comunController;

    @FXML
    private ListView<File> fxListViewNavegador;

    @FXML
    private Label fxLabelRutaActual;

    private String rutaInicial;

    @FXML
    public void handleMouseClick(MouseEvent event) {
        try {
            if (event.getClickCount() > 1) {
                File seleccionado = fxListViewNavegador.getSelectionModel().getSelectedItem();

                if (seleccionado.isDirectory()) {
                    fxLabelRutaActual.setText(seleccionado.getAbsolutePath());
                    cargarFiles();

                } else {
                    String nombre = seleccionado.getName();  
                    int ultmopunto = nombre.lastIndexOf('.');
                    String extension = nombre.substring(ultmopunto + 1);  

                    if (extension.equals("jpeg") || extension.equals("jpg") || extension.equals("bmp") || extension.equals("png")) {

                        this.comunController.setArchivoActual(seleccionado);
                        this.comunController.ponerVisorImagenes(seleccionado.getAbsolutePath());

                    } else if (extension.equals("pdf")) {
                        this.comunController.setArchivoActual(seleccionado);
                        this.comunController.ponerVisorPDF(seleccionado.getAbsolutePath());

                    } else if (extension.equals("txt") || extension.equals("rtf")) {
                        this.comunController.setArchivoActual(seleccionado);
                        this.comunController.ponerEditorTexto();   // probar con el fichero guardado en el comunController
                    }
                }
            }

        } catch (Exception error) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "No se puede", ButtonType.CLOSE);
            a.showAndWait();

            File file = new File(fxLabelRutaActual.getText());  
            fxLabelRutaActual.setText(file.getParent()); 
            cargarFiles();
        }
    }

    @FXML
    public void crearFicheroTexto() throws IOException {
        String ruta = fxLabelRutaActual.getText();

        TextInputDialog dialog = new TextInputDialog("fichero.txt");
        dialog.setTitle("Crear fichero de texto");

        dialog.setHeaderText("Nombre del fichero:");

        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()) {
            File file = new File(ruta + "\\" + resultado.get());

            file.createNewFile();
            cargarFiles();
        }
    }

    @FXML
    public void copiarFichero() throws IOException {
        File seleccionado = fxListViewNavegador.getSelectionModel().getSelectedItem();
        this.comunController.setArchivoActual(seleccionado);

    }

    @FXML
    public void pegarFichero() throws IOException {
        File copiado = this.comunController.getArchivoActual();
        
        String rutaParaPegar = this.fxLabelRutaActual.getText();
        String nombreOriginal = copiado.getName();

        int ultmopunto = nombreOriginal.lastIndexOf('.');
        String nombreSinExtension = nombreOriginal.substring(0, ultmopunto);  
        String extension = nombreOriginal.substring(ultmopunto); 

        String nombreCopia = nombreSinExtension + "_Copia" + extension;
        File paraPegar = new File(rutaParaPegar + "\\" + nombreCopia);
                
        Files.copy(new File(copiado.getAbsolutePath()), new File(paraPegar.getAbsolutePath()));

        cargarFiles();
    }

    @FXML
    public void renombrarFichero() {
        File seleccionado = fxListViewNavegador.getSelectionModel().getSelectedItem();

        TextInputDialog dialog = new TextInputDialog(seleccionado.getName());
        dialog.setTitle("Renombrar");

        if (seleccionado.isDirectory()) {
            dialog.setHeaderText("Nuevo nombre del directorio:");
        } else {
            dialog.setHeaderText("Nuevo nombre del fichero:");
        }

        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()) {
            File newfile = new File(seleccionado.getParent() + "\\" + resultado.get());
            seleccionado.renameTo(newfile);

            cargarFiles();
        }
    }

    @FXML
    public void borrarFichero() {
        File seleccionado = fxListViewNavegador.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);

            alert.setTitle("Borrar");
            alert.setContentText("¿Estás seguro de que quierres borrarlo?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                seleccionado.delete();
                cargarFiles();  
            }
        }
    }

    @FXML
    public void clicSubirDirectorio(ActionEvent event) {
        File f = new File(fxLabelRutaActual.getText()); 

        if (f.getParent() != null) {
            fxLabelRutaActual.setText(f.getParent()); 
            cargarFiles();
            
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Ya estás en la raíz");
            a.showAndWait();
        }
    }

    @FXML
    public void clicVolverALaRaiz(ActionEvent event) {
        File f = new File(fxLabelRutaActual.getText()); 

        while (f.getParent() != null) { 
            f = new File(fxLabelRutaActual.getText());
            fxLabelRutaActual.setText(f.getParent());
        }

        fxListViewNavegador.getItems().clear();
        fxListViewNavegador.getItems().addAll(f.listFiles());  
    }

    public void cargarFiles() {
        File f = new File(fxLabelRutaActual.getText());
        fxListViewNavegador.getItems().clear();
        fxListViewNavegador.getItems().addAll(f.listFiles());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rutaInicial = "C:\\";
        fxLabelRutaActual.setText(rutaInicial);

        // dar estilo a las celdas
        fxListViewNavegador.setCellFactory(list -> new ListCell<File>() {

            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null) {
                    setText(item.getName()); 

                    if (item.isDirectory()) {
                        setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/carpeta.png"))));
                    } else {
                        String nombre = item.getName();  
                        
                        int ultmopunto = nombre.lastIndexOf('.');

                        String extension = nombre.substring(ultmopunto + 1); 

                        switch (extension) {
                            case "pdf":
                                setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/pdf.png"))));
                                break;
                            case "jpeg":
                            case "jpg":
                            case "bmp":
                            case "png":
                                setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/imagen.png"))));
                                break;
                            case "txt":
                            case "doc":
                            case "docx":
                            case "odt":
                            case "rtf":
                                setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/documento.png"))));
                                break;
                            default:
                                break;
                        }
                    }

                } else {
                    setText("");
                    setGraphic(null);  
                }
            }
        }
        );

        cargarFiles();
    }

    public void setComunController(FXMLcomunController comunController) {
        this.comunController = comunController;
    }

    public void setTexto_FxLabelRutaActual(String ruta) {
        this.fxLabelRutaActual.setText(ruta);
    }

}

//    @FXML
//    public void clicEntrarEnDirectorio(ActionEvent event) {
//        File seleccionado = fxListViewNavegador.getSelectionModel().getSelectedItem();  // meter en un file lo seleccionamos
//        // comprobar que es un directorio
//        if (seleccionado.isDirectory()) {
//            fxLabelRutaActual.setText(seleccionado.getAbsolutePath());   // poner en el label la ruta a la que hemos entrado
//            cargarFiles();
//        } else {
//            Alert a = new Alert(Alert.AlertType.ERROR, "No es un directorio");
//            a.showAndWait();
//        }
    //    }
