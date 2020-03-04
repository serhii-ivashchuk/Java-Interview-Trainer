package pro.ivashchuk.javainterviewtrainer.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.javainterviewtrainer.app.domain.Question;
import pro.ivashchuk.javainterviewtrainer.app.repository.JpaQuestionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private JpaQuestionRepository jpaQuestionRepository;

    public QuestionController(JpaQuestionRepository jpaQuestionRepository) {
        this.jpaQuestionRepository = jpaQuestionRepository;
    }

    @GetMapping
    public String getAllQuestions(Model model) {
        List<Question> questions = jpaQuestionRepository.findAll();
        model.addAttribute("questions", questions);
        return "all_questions";
    }

    @GetMapping("/addNewQuestion")
    public String getAddNewQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "add_new_question";
    }

    @PostMapping("/addNewQuestion")
    public String postProcessNewQuestion(@Valid Question question) {
        jpaQuestionRepository.save(question);
        return "redirect:/questions";
    }

    @GetMapping("/question/{id}")
    public String getQuestionById(@PathVariable("id") Long id, Model model) {
        Question question = jpaQuestionRepository.findById(id).get();
        model.addAttribute("question", question);
        return "question";
    }

    @GetMapping("/question/{id}/delete")
    public String deleteQuestionById(@PathVariable("id") Long id) {
        Question question = jpaQuestionRepository.findById(id).get();
        jpaQuestionRepository.delete(question);
        return "redirect:/questions";
    }
}
