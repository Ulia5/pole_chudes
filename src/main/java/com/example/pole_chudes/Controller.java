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

    private Question[] addQuestions (Question[] questions) {
        questions[0] = new Question("Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?", "энциклопедия");

        questions[1] = new Question("Что использовали в Китае для глажки белья вместо утюга?",
                "сковорода");

        questions[2] = new Question("Первый подобный музей появился в Париже до 1975 года. " +
                "Экскурсии по нему проводились на лодке. " +
                "Сейчас туристы осматривают его экспонаты со специальных решеток и пандусов. О каком музее идет речь?",
                "канализация");

        questions[3] = new Question("Пельмени издавна заготавливают в форме ушек. " +
                "Что символизируют такие пельмени?", "послушание");

        questions[4] = new Question("Если скорость ветра тропического шторма превышает 60 км/ч, " +
                "ему присваивают личное имя. Во времена Второй мировой войны " +
                "американские синоптики начали давать ураганам имена кого?", "теща");

        questions[5] = new Question("Чтобы отпугнуть врагов, гуси могут грозно шипеть и больно щипаться. " +
                "В Шотландии решили использовать эту особенность птиц и создали отряд гусей, " +
                "который стал охранять завод. Какой?", "алкогольный");

        questions[6] = new Question("Ювелиры часто говорят, что бриллиантам необходимо это.", "одиночество");

        questions[7] = new Question ("Английский писатель Киплинг говорил: «Женская интуиция намного точнее, " +
                "чем мужская...»", "уверенность");

        questions[8] = new Question("Соседи по улице знали Дмитрия Ивановича Менделеева как замечательного мастера " +
                "по изготовлению чего?", "чемодан");

        questions[9] = new Question("Чтобы сделать комплимент женщине в Индии, нужно сравнить ее с коровой и слоном. " +
                "Причем с коровой она должна быть схожа глазами, а со слоном — этим.", "походка");

        questions[10] = new Question("В XIV–XVI веках его носили мужчины. " +
                "С XVII века его стали носить женщины. " +
                "Названий было много: шторник, пестряк, клинник, наколоточник и др. " +
                "До нас дошло лишь одно название. Какое?", "сарафан");
        return questions;
    }

    @FXML
    public void newPoint(ActionEvent event) {
        if (points != null) {
            Random rand = new Random();
            points.setText(pointVariants[rand.nextInt(pointVariants.length)]);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Question[] allQuestion = new Question[11];
        addQuestions(allQuestion);
        Question thisQuestion;
        if (question != null) {
            Random rand = new Random();
            thisQuestion = allQuestion[rand.nextInt(allQuestion.length)];
            question.setText(thisQuestion.getQuestion());
        }
    }
}