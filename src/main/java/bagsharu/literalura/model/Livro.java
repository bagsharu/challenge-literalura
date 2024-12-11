package bagsharu.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tituloLivro;
    private String linguagemLivro;
    private String autorLivro;
    private Integer downloadTotal;

    public Livro() {

    }

    public Livro(LivroInfo livroInfo) {

        this.tituloLivro = livroInfo.tituloLivro();
        this.autorLivro = livroInfo.autorLivro().get(0).nomeAutor();
        this.linguagemLivro = livroInfo.linguagemLivro().get(0);
        this.downloadTotal = livroInfo.downloadTotal();
    }

    public Long getId() {
        return id;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public String getLinguagemLivro() {
        return linguagemLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public Integer getDownloadTotal() {
        return downloadTotal;
    }
}
