package pro.ivashchuk.javainterviewtrainer.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String questionText;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    public Question() {
    }

    public Question(Long id, String questionText, QuestionType questionType) {
        this.id = id;
        this.questionText = questionText;
        this.questionType = questionType;
    }
    public Question(String questionText) {
        this.questionText = questionText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @OneToMany(mappedBy="question")
    private Set<Answer> answers = new HashSet<>();

            private QuestionType(String displayValue) {
                this.displayValue = displayValue;
            }

            public String getDisplayValue() {
                return displayValue;
            }
        }
}
