package com.example.pole_chudes;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final String[] pointVariants = {"0", "50", "100", "150", "200", "250", "300",
            "350", "400", "450", "500", "x2"};
    private int num;
    private Label letters[];
    private Player players[];
    private Label scales[];
    private int thisPlayer;
    private int thisPoint;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private Question thisQuestion;
    private Player winner;
    @FXML
    public Label points;
    @FXML
    public Label question;
    @FXML
    public GridPane fieldAnswer;
    @FXML
    public Label let1;
    @FXML
    public Label let2;
    @FXML
    public Label let3;
    @FXML
    public Label let4;
    @FXML
    public Label let5;
    @FXML
    public Label let6;
    @FXML
    public Label let7;
    @FXML
    public Label let8;
    @FXML
    public Label let9;
    @FXML
    public Label let10;
    @FXML
    public Label let11;
    @FXML
    public Label let12;
    @FXML
    public Label let13;
    @FXML
    public Label let14;
    @FXML
    public Label let15;
    @FXML
    public Label scale1;
    @FXML
    public Label scale2;
    @FXML
    public Label scale3;
    @FXML
    public Label name1;
    @FXML
    public Label name2;
    @FXML
    public Label name3;

    @FXML
    public void startGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
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
    public void newPoint(ActionEvent event) throws IOException {
        if (points != null) {
            Random rand = new Random();
            thisPoint = Integer.parseInt(pointVariants[rand.nextInt(pointVariants.length - 1)]);
            points.setText(String.valueOf(thisPoint));
            if (thisPoint != 0) {
                TextInputDialog textInputDialog = new TextInputDialog();
                textInputDialog.setTitle("Поле чудес");
                textInputDialog.setHeaderText("Введите букву:");
                textInputDialog.setContentText("Ваша буква:");
                Optional<String> res = textInputDialog.showAndWait();
                String ans = res.get();
                while (ans.isEmpty()) {
                    textInputDialog = new TextInputDialog();
                    textInputDialog.setTitle("Поле чудес");
                    textInputDialog.setHeaderText("Вводите хотя бы одну букву:");
                    textInputDialog.setContentText("Ваша буква:");
                    res = textInputDialog.showAndWait();
                    ans = res.get();
                }
                while (ans.length() > 1  || !thisQuestion.checkLetter(ans)) {
                    textInputDialog = new TextInputDialog();
                    textInputDialog.setTitle("Поле чудес");
                    if (ans.length() > 1)
                        textInputDialog.setHeaderText("Вводите только одну букву:");
                    else
                        textInputDialog.setHeaderText("Такая буква уже была, введите другую букву:");
                    textInputDialog.setContentText("Ваша буква:");
                    res = textInputDialog.showAndWait();
                    ans = res.get();
                    while (ans.isEmpty()) {
                        textInputDialog = new TextInputDialog();
                        textInputDialog.setTitle("Поле чудес");
                        textInputDialog.setHeaderText("Вводите хотя бы одну букву:");
                        textInputDialog.setContentText("Ваша буква:");
                        res = textInputDialog.showAndWait();
                        ans = res.get();
                    }
                }
                if (players[thisPlayer].giveAnswer(thisQuestion, ans, thisPoint)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Поле чудес");
                    alert.setHeaderText(null);
                    alert.setContentText("Есть такая буква!");
                    alert.showAndWait();
                    int k = 0;
                    for (int i = 15 - num - 1; i >= (15 - num) - thisQuestion.getAnswer().length(); i--) {
                        if (thisQuestion.getGuessedText().charAt(k) != '*') {
                            fieldAnswer.getChildren().get(2 * 15 + i).setStyle("-fx-background-color: white");
                            letters[15 - i - 1].setText(String.valueOf(thisQuestion.getAnswer().charAt(k)));
                        }
                        k += 1;
                    }
                    scales[thisPlayer].setText(String.valueOf(players[thisPlayer].getPoints()));
                    winner = thisQuestion.determiningWinner(players);
                    if (winner != null) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Поле чудес");
                        alert.setHeaderText(null);
                        alert.setContentText("Игра окончена! Победитель: " + winner.getName() +
                                " со счетом " + winner.getPoints());
                        alert.showAndWait();
                        Platform.exit();
                        System.exit(0);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Поле чудес");
                    alert.setHeaderText(null);
                    alert.setContentText("Нет такой буквы!");
                    alert.showAndWait();
                    scales[thisPlayer].setTextFill(Color.web("rgb(1, 31, 71)"));
                    if (thisPlayer == 2)
                        thisPlayer = 0;
                    else
                        thisPlayer += 1;
                    scales[thisPlayer].setTextFill(Color.web("rgb(255, 0, 0)"));
                }
            }
            else {
                scales[thisPlayer].setTextFill(Color.web("rgb(1, 31, 71)"));
                if (thisPlayer == 2)
                    thisPlayer = 0;
                else
                    thisPlayer += 1;
                scales[thisPlayer].setTextFill(Color.web("rgb(255, 0, 0)"));
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Question[] allQuestion = new Question[11];
        Player player1 = new Player("Михаил");
        Player player2 = new Player("Лариса");
        Player player3 = new Player("Я");
        players = new Player[] {player1, player2, player3};
        scales = new Label[] {scale1, scale2, scale3};
        thisPlayer = 0;
        letters = new Label[]{let1, let2, let3, let4, let5, let6, let7, let8, let9, let10, let11, let12, let13,
                let14, let15};
        addQuestions(allQuestion);
        if (question != null) {
            Random rand = new Random();
            scales[thisPlayer].setTextFill(Color.web("rgb(255, 0, 0)"));
            thisQuestion = allQuestion[rand.nextInt(allQuestion.length)];
            question.setText(thisQuestion.getQuestion());
            num = (15 - thisQuestion.getAnswer().length()) / 2;
            if(fieldAnswer != null && num >= 0) {
                for (int i = 15 - num - 1; i >= (15 - num) - thisQuestion.getAnswer().length(); i--) {
                    fieldAnswer.getChildren().get(2*15 + i).setStyle("-fx-background-color: #011f47");
                }
            }
            if (name1 != null && name2 != null && name3 != null) {
                name1.setText(player1.getName());
                name2.setText(player2.getName());
                name3.setText(player3.getName());
            }
        }
    }
}