package main;

import controllers.FXMLexploradorController;
import controllers.FXMLcomunController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FXMain extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/fxml/FXMLcomun.fxml"));
        BorderPane root = loaderMenu.load();
        FXMLcomunController comunController = loaderMenu.getController();

        AnchorPane anchor;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLexplorador.fxml"));
        anchor = loader.load();
        root.setCenter(anchor);

        FXMLexploradorController controller = loader.getController();
        controller.setComunController(comunController);

        root.setCenter(anchor);

        Scene scene = new Scene(root);
//      scene.getStylesheets().add("/css/fxmlscene.css");
        stage.setTitle("Nautilus");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
