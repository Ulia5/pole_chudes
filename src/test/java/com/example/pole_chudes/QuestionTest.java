package com.example.pole_chudes;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    @Test
    void setQuestion() {
        Question question = new Question("Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?", "энциклопедия");
        String questionText = "Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?";
        String answerText = "энциклопедия";
        assertEquals(questionText, question.getQuestion());
        assertEquals(answerText, question.getAnswer());
    }

    @Test
    void setRandomQuestions() {
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
        thisQuestion = questions[rand.nextInt(questions.length)];
        boolean result = false;
        for (Question question : questions) {
            if (Objects.equals(thisQuestion.getQuestion(), question.getQuestion())) {
                result = true;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    void fillingField() {
        Question question = new Question("Если скорость ветра тропического шторма превышает 60 км/ч, " +
                "ему присваивают личное имя. Во времена Второй мировой войны " +
                "американские синоптики начали давать ураганам имена кого?", "теща");
        assertEquals(question.getGuessedText(), "*".repeat(question.getAnswer().length()));
    }
}