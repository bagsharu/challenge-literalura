package bagsharu.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroInfo(@JsonAlias("title") String tituloLivro,
                        @JsonAlias("languages") List<String> linguagemLivro,
                        @JsonAlias("authors") List<AutorInfo> autorLivro,
                        @JsonAlias("download_count") Integer downloadTotal) {
}

@JsonIgnoreProperties(ignoreUnknown = true)
record AutorInfo(@JsonAlias("name") String nomeAutor,
                        @JsonAlias("birth_year") String anoNascimento,
                        @JsonAlias("death_year") String anoFalecimento){

}
