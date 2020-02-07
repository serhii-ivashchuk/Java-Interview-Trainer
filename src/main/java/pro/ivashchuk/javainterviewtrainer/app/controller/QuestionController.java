package pro.ivashchuk.javainterviewtrainer.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.ivashchuk.javainterviewtrainer.app.domain.Question;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @GetMapping
    public String getAllQuestions(Model model){
        List<Question> questions = jpaQuestionRepository.findAll();
        model.addAttribute("questions", questions);
        return "all_questions";
    }

    @GetMapping("/addNewQuestion")
    public String addNewQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "add_new_question";
    }
}
