package com.example.pole_chudes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final String[] pointVariants = {"0", "50", "100", "150", "200", "250", "300",
            "350", "400", "450", "500", "x2"};
    @FXML
    public Label points;
    @FXML
    public Label question;

    @FXML
    public void startGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String thisQuestion = "Пельмени издавна заготавливают в форме ушек. Что символизируют такие пельмени?";
        if (question != null) {
            question.setText(thisQuestion);
            System.out.println(question.getText().length());
        }
    }

    @FXML
    public void newPoint(ActionEvent event) {
        if (points != null) {
            Random rand = new Random();
            points.setText(pointVariants[rand.nextInt(pointVariants.length)]);
        }
    }
}