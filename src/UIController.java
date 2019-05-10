import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class UIController extends Application {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private Scene ui_MainPage;
    @FXML
    private ChoiceBox <FXCollections>  attackType;

    @FXML
    private ChoiceBox <FXCollections> DOSattacks;

    @FXML
    private ChoiceBox <FXCollections> DDOSattacks;

    @FXML
    private TextField url;

    @FXML
    private TextField port;

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


    public void clickGoButton()
    {

        //System.out.println(url.getText());
        //System.out.println(port.getText());

        if(attackType.getSelectionModel().getSelectedIndex() == 0)
        {
            System.out.println("DOS Attack is chosen");
        }
        if(attackType.getSelectionModel().getSelectedIndex() == 1)
        {
            System.out.println("DDOS Attack is chosen");
        }


    }

    public void getValueOfAttackTypeBox()
    {

        if(attackType.getSelectionModel().getSelectedIndex() == 0)
        {
            DOSattacks.setVisible(true);
            DDOSattacks.setVisible(false);
        }
        if(attackType.getSelectionModel().getSelectedIndex() == 1)
        {
            DDOSattacks.setVisible(true);
            DOSattacks.setVisible(false);
        }

    }

}






