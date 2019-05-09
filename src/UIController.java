import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
public class UIController extends Application {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_MainPage;

    public static void main(String[]args)
    {
        System.out.print("Hello Ezqler");
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        ui_MainPage = initializeScene("ui_mainPage.fxml");
        primaryStage.setScene(ui_MainPage);
        primaryStage.show();
    }

    public Scene initializeScene(String fxmlName) throws java.io.IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = (Parent)loader.load();
        return new Scene(root, WIDTH,HEIGHT);
    }

}






