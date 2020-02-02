package pro.ivashchuk.javainterviewtrainer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.ivashchuk.javainterviewtrainer.app.domain.Answer;

public interface JpaAnswerRepository extends JpaRepository<Answer, Long> {
}
