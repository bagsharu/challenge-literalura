package bagsharu.literalura.main;

import bagsharu.literalura.service.ConsultaAPI;

public class Menu {

    private ConsultaAPI consultas = new ConsultaAPI();

    public void ImprimeMenu() {

        String TEXTO_MENU = """
                
                Escolha uma opção:
                1 - Buscar um livro no Gutendex.
                
                
                """;
        System.out.println(TEXTO_MENU);
    }
}
