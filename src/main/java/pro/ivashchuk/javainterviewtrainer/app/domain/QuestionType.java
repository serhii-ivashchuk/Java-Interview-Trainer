package pro.ivashchuk.javainterviewtrainer.app.domain;

public enum QuestionType {
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
