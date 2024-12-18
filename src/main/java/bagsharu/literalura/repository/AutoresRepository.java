package bagsharu.literalura.repository;

import bagsharu.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNomeAutorContains(String nome);
}
