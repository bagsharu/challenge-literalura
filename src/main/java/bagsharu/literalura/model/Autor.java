package bagsharu.literalura.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nomeAutor;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autorLivro", cascade = CascadeType.ALL)
    private List<Livro> livrosAutor;

    public Autor () {

    }

    public Autor(AutorInfo autorInfo) {

        this.nomeAutor = autorInfo.nomeAutor();
        this.anoNascimento = Integer.valueOf(autorInfo.anoNascimento());
        this.anoFalecimento = Integer.valueOf(autorInfo.anoFalecimento());
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public List<Livro> getLivrosAutor() {
        return livrosAutor;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "***** Informações Autor *****" +
                "\nNome: " + getNomeAutor() +
                "\nAno Nascimento: " + getAnoNascimento() +
                "\nAno Falecimento: " + getAnoFalecimento();
    }
}
