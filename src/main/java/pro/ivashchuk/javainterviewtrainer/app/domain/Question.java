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

        enum QuestionType {
            BEHAVIORAL("Behavioral"),
            TECHNICAL("Technical");
            private final String displayValue;

            private QuestionType(String displayValue) {
                this.displayValue = displayValue;
            }

            public String getDisplayValue() {
                return displayValue;
            }
        }
}
