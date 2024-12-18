package bagsharu.literalura.repository;

import bagsharu.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNomeAutorContains(String nome);

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :ano AND a.anoFalecimento >= :ano")
    List<Autor> buscarAno(Integer ano);
}
