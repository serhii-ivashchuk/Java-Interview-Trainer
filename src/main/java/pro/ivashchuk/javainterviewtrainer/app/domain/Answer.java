package pro.ivashchuk.javainterviewtrainer.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
