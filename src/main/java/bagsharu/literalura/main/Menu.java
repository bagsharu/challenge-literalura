package bagsharu.literalura.main;

import bagsharu.literalura.model.LivroInfo;
import bagsharu.literalura.service.ConsultaAPI;
import bagsharu.literalura.service.ConverteDados;

public class Menu {

    private ConsultaAPI consultas = new ConsultaAPI();

    public void ImprimeMenu() {

        String TEXTO_MENU = """
                
                Escolha uma opção:
                1 - Buscar um livro no Gutendex.
                
                
                """;
        System.out.println(TEXTO_MENU);
    }

    // Retorna um Record com as informações do Gutendex
    public LivroInfo buscarLivro(String livroBusca) {

        // Armazena as informações do json na variável
        var json = consultas.requestData(livroBusca);

        // Converte dados do json para Record
        var convert = new ConverteDados();
        return convert.converterDados(json,LivroInfo.class);

    }
}
