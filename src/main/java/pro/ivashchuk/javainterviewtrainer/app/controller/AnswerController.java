package pro.ivashchuk.javainterviewtrainer.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.javainterviewtrainer.app.domain.Answer;
import pro.ivashchuk.javainterviewtrainer.app.repository.JpaAnswerRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/answers")
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