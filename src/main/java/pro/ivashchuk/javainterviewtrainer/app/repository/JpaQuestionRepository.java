package pro.ivashchuk.javainterviewtrainer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.javainterviewtrainer.app.domain.Question;

public interface JpaQuestionRepository extends JpaRepository<Question, Long> {
}
