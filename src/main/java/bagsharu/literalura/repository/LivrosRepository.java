package bagsharu.literalura.repository;

import bagsharu.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByTituloLivroContains(String titulo);

    List<Livro> findByLinguagemLivroContains(String idioma);
}
