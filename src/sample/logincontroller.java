package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import javafx.event.ActionEvent;
import java.io.IOException;

public class logincontroller {
    @FXML
    private TextField name;
    @FXML
    private Label click;
    @FXML
    Stage primaryStage;


    public void password(ActionEvent event) throws IOException {
        String pas = name.getText();

        if (pas.equals("anurag")) {

            click.setText("password is correct");
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
            window.setScene(new Scene(root1, 600, 500));
            window.show();


        } else {

            click.setText("enter password again");
        }


    }
}