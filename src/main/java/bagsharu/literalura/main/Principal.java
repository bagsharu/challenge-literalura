package bagsharu.literalura.main;

import bagsharu.literalura.model.Gutendex;
import bagsharu.literalura.model.Livro;
import bagsharu.literalura.model.LivroInfo;
import bagsharu.literalura.repository.LivrosRepository;
import bagsharu.literalura.service.ConsultaAPI;
import bagsharu.literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private LivrosRepository repository;

    private Scanner scanner = new Scanner(System.in);

    private ConsultaAPI consultas = new ConsultaAPI();
    private ConverteDados converter = new ConverteDados();

    public Principal(LivrosRepository repository) {
        this.repository = repository;
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
                
                
                """;
        System.out.println(TEXTO_MENU);
    }

    //
    public void BuscarTitulo () {
        System.out.println("Insira o título do livro que deseja buscar:");

        String buscarTitulo = scanner.nextLine();

        var json = consultas.requestData(buscarTitulo.replace(" ", "%20"));
        //System.out.println("json: " + json);
        var dados = converter.converterDados(json, Gutendex.class);
        //System.out.println("dados" + dados);

    }

    }
