package bagsharu.literalura.main;

import bagsharu.literalura.model.*;
import bagsharu.literalura.repository.LivrosRepository;
import bagsharu.literalura.service.ConsultaAPI;
import bagsharu.literalura.service.ConverteDados;

import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private LivrosRepository Livrorepository;

    private Scanner scanner = new Scanner(System.in);

    private ConsultaAPI consultas = new ConsultaAPI();
    private ConverteDados converter = new ConverteDados();

    public Principal(LivrosRepository repository) {
        this.Livrorepository = repository;
    }

        public void IniciarMenu() {
            int control = -1;

            while (control != 0) {

                ImprimeMenu();
                control = scanner.nextInt();
                scanner.nextLine();

                switch (control) {
                    case (1):
                        BuscarTitulo();
                        break;
                    case (0):
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Operação inválida.");
                }
            }

        }

    public void ImprimeMenu() {

        String TEXTO_MENU = """
                
                Escolha uma opção:
                1 - Buscar um livro no Gutendex.
                2 - Listar Livros no banco de daods.
                3 - Listar Autores no banco de dados.
                4 - Procurar Autor por Ano.
                5 - Procurar Livro por Idioma.
                
                0 - Sair
                
                """;
        System.out.println(TEXTO_MENU);
    }

    // Busca um livro pela API Gutendex
    public void BuscarTitulo () {

        // Recebe da entrada do usuário o titulo
        System.out.println("Insira o título do livro que deseja buscar:");
        String buscarTitulo = scanner.nextLine();

        // Recebe dados da APi a partir do titulo informado
        var json = consultas.requestData(buscarTitulo.replace(" ", "%20"));
        //System.out.println("json: " + json);
        var dados = converter.converterDados(json, Gutendex.class);
        System.out.println("dados" + dados);

        // Validação das informacoes recebidas
        if (dados.livrosBusca().isEmpty()) {
            System.out.println("Título não encontrado.");
        } else {
            // Recebe o primeiro livro do array "results"
            LivroInfo livroInfo = dados.livrosBusca().get(0);
            System.out.println("Dados do título: " + livroInfo);

            // Recebe o primeiro autor do array "results"
            AutorInfo autorInfo = dados.livrosBusca().get(0).autorLivro().get(0);


            // Instancia um objeto de Livro e Autor com todas as informacoes da API
            Livro livro = new Livro(livroInfo);
            System.out.println(livro);

            Autor autor = new Autor(autorInfo);
            System.out.println(autor);

            SalvarDados(livro,autor);
        }
    }

    // Salva dados no banco de dados
    public void SalvarDados(Livro livro, Autor autor) {

        Optional<Livro> livroBusca = Livrorepository.findByTituloLivroContains(livro.getTituloLivro());

        if (livroBusca.isPresent()){
            System.out.println("Este livro já está registrado!");
        } else {
            try {
                Livrorepository.save(livro);
                System.out.println("Livro registrado com sucesso");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }



    }
