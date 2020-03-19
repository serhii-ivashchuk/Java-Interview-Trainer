package pro.ivashchuk.javainterviewtrainer.app.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answerText;

    private String answerAudioLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerAudioLink() {
        return answerAudioLink;
    }

    public void setAnswerAudioLink(String answerAudioLink) {
        this.answerAudioLink = answerAudioLink;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getQuestionId(){
        return question.getId();
    }

    public Answer() {
    }

    public Answer(String answerText) {
        this.answerText = answerText;
    }

    public Answer(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return String.format(
                "Answer id[id=%d, answerText='%s', question='%s']",
                id, answerText, question);
    }
}
