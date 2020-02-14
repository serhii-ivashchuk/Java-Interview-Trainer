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

    @PostMapping("/addNewAnswer")
    public String processNewAnswer(@Valid Answer answer) {
        jpaAnswerRepository.save(answer);
        return "redirect:/answers";
    }

    @GetMapping("/answer/{id}")
    public String getAnswerById(@PathVariable("id") Long id, Model model) {
        Answer answer = jpaAnswerRepository.findById(id).get();
        model.addAttribute("answer", answer);
        return "answer";
    }

    @GetMapping("/answer/{id}/delete")
    public String deleteAnswerById(@PathVariable("id") Long id) {
        Answer answer = jpaAnswerRepository.findById(id).get();
        jpaAnswerRepository.delete(answer);
        return "redirect:/answers";
    }
}