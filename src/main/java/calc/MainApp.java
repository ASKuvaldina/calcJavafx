package calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(final Stage stage) throws Exception{
        String fxmlFile = "/calcUI.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        stage.setTitle("Калькулятор");
        stage.setMaxHeight(350);
        stage.setMaxWidth(450);
        stage.setResizable(true);

        Scene sceneCalc = new Scene(root);
        stage.setScene(sceneCalc);
        

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
