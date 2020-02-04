package pro.ivashchuk.javainterviewtrainer.app.controller;

public class AnswerController {

    @GetMapping
    public String getAllAnswers (Model model) {
        List<Answer> answers = jpaAnswerRepository.findAll();
        model.addAttribute("answers", answers);
        return "all_answers";
    }
}