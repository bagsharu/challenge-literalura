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

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livrosAutor;

    public Autor () {

    }

    public Autor(AutorInfo autorInfo) {

        this.nomeAutor = autorInfo.nomeAutor();
        this.anoNascimento = Integer.valueOf(autorInfo.anoNascimento());
        this.anoFalecimento = Integer.valueOf(autorInfo.anoFalecimento());
    }

}
