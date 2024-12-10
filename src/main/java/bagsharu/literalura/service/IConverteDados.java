package bagsharu.literalura.service;

public interface IConverteDados {

    // Recebe um json e converte para classe (serializa)
    <T> T converterDados(String json, Class<T> classe);
}
