package pro.ivashchuk.javainterviewtrainer.app.controller;

public class AnswerController {

    @GetMapping
    public String getAllAnswers () {
        return "all_answers";
    }
}