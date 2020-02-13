package pro.ivashchuk.javainterviewtrainer.app.controller;

public class AnswerController {

    private JpaAnswerRepository jpaAnswerRepository;

    public AnswerController(JpaAnswerRepository jpaAnswerRepository) {
        this.jpaAnswerRepository = jpaAnswerRepository;
    }

    @GetMapping
    public String getAllAnswers (Model model) {
        List<Answer> answers = jpaAnswerRepository.findAll();
        model.addAttribute("answers", answers);
        return "all_answers";
    }

    @GetMapping("/addNewAnswer")
    public String addNewAnswer (Model model) {
        model.addAttribute("answer", new Answer());
        return "add_new_answer";
    }
}