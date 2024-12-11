package bagsharu.literalura.main;

import bagsharu.literalura.model.Livro;
import bagsharu.literalura.model.LivroInfo;

import java.util.Scanner;

public class Principal {

    private final String URL_BASE = "https://gutendex.com/books?search=";

    private Scanner scanner = new Scanner(System.in);
    private Menu controleMenu = new Menu();


    public void IniciarMenu() {
        int control = -1;

        while (control != 0) {

            controleMenu.ImprimeMenu();
            control = scanner.nextInt();
            scanner.nextLine();

            switch (control) {
                case (1):
                    System.out.println("Qual livro deseja buscar?");
                    var busca = scanner.nextLine();
                    var URL = URL_BASE + busca;

                    LivroInfo livroBusca = controleMenu.buscarLivro(URL);
                    Livro livro = new Livro(livroBusca);

                    repository.add(livro);
                    break;
                case (0):
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
        }

    }

}
