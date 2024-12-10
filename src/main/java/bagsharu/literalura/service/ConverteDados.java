package bagsharu.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T converterDados(String json, Class<T> classe) {

        try {
            return mapper.readValue(json,classe);
        } catch (JsonProcessingException e) {
            System.out.println("Não foi possível localizar.");
            throw new RuntimeException(e);
        }
    }
}
