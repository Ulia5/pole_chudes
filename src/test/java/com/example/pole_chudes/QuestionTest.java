package com.example.pole_chudes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    @Test
    @DisplayName("Проверка заданных вопроса и ответа")
    void setQuestion() {
        Question question = new Question("Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?", "энциклопедия");
        String questionText = "Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?";
        String answerText = "энциклопедия";
        // Проверка соответствия возвращенных из геттеров результатов
        assertEquals(questionText, question.getQuestion());
        assertEquals(answerText, question.getAnswer());
    }

    @Test
    @DisplayName("Проверка выполнения случайного вопроса")
    void setRandomQuestions() {
        // Создание базы вопросов
        Question[] questions = new Question[11];
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
        Question thisQuestion;
        Random rand = new Random();
        // Выбор случайного вопроса и сохранение его в переменной thisQuestion
        thisQuestion = questions[rand.nextInt(questions.length)];
        boolean result = false;
        // Проверка верности выполнения случайного выбора
        for (Question question : questions) {
            if (Objects.equals(thisQuestion.getQuestion(), question.getQuestion())) {
                result = true;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка заполнения поля для ввода ответа *")
    void fillingField() {
        Question question = new Question("Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?", "энциклопедия");
        // Проверка соответствия кол-ва элеентов в ответе и в поле для ответа
        assertEquals(question.getGuessedText(), "*".repeat(question.getAnswer().length()));
    }

    @Test
    @DisplayName("Проверка правильности изменения * на буквы")
    void writingRightLetter() {
        Question question = new Question("Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?", "энциклопедия");
        question.checkingLetter("и");
        String guessed = "***и******и*";
        assertEquals(guessed, question.getGuessedText());
    }

    @Test
    @DisplayName("Создание игрока")
    void createPlayer() {
        Player player = new Player("Михаил");
        assertEquals("Михаил", player.getName());
    }

    @Test
    @DisplayName("Добавление очков игроку")
    void addPoints() {
        Player player = new Player("Михаил");
        int points = 500;
        player.addPoints(points);
        assertEquals(points, player.getPoints());
    }

    @Test
    @DisplayName("Проверка функции дачи ответа и состояния счета после этого")
    void giveAnswer() {
        Player player1 = new Player("Михаил");
        Question question = new Question("Если скорость ветра тропического шторма превышает 60 км/ч, " +
                "ему присваивают личное имя. Во времена Второй мировой войны " +
                "американские синоптики начали давать ураганам имена кого?", "теща");
        int point = 500;
        player1.giveAnswer(question, "а", point);
        point += 250;
        player1.giveAnswer(question, "т", 250);
        assertEquals(point, player1.getPoints());
    }

    @Test
    @DisplayName("Проверка невозможности ввода буквы повторно")
    void repeatLetter() {
        Question question = new Question("Если скорость ветра тропического шторма превышает 60 км/ч, " +
                "ему присваивают личное имя. Во времена Второй мировой войны " +
                "американские синоптики начали давать ураганам имена кого?", "теща");
        assertTrue(question.checkLetter("а"));
        assertFalse(question.checkLetter("а"));
    }

    @Test
    @DisplayName("Определение победителя")
    void determiningWinner() {
        Player player1 = new Player("Михаил");
        Player player2 = new Player("Лариса");
        Player players[] = new Player[] {player1, player2};
        Question question = new Question("Если скорость ветра тропического шторма превышает 60 км/ч, " +
                "ему присваивают личное имя. Во времена Второй мировой войны " +
                "американские синоптики начали давать ураганам имена кого?", "теща");
        player1.giveAnswer(question, "т", 250);
        player2.giveAnswer(question, "е", 500);
        player2.giveAnswer(question, "щ", 150);
        player1.giveAnswer(question, "а", 600);
        assertEquals(player1, question.determiningWinner(players));
    }
}