package bagsharu.literalura.main;

import java.util.Scanner;

public class Principal {

    private final String URL_BASE = "https://gutendex.com/books";

    private Scanner scanner = new Scanner(System.in);
    private Menu controleMenu = new Menu();


    public void IniciarMenu() {
        int control = -1;

        while (control != 0) {

            controleMenu.ImprimeMenu();
            control = scanner.nextInt();

            switch (control) {
                case (1):
                    System.out.println("Teste");
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
