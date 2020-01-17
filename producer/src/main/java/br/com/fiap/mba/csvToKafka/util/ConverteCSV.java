package br.com.fiap.mba.csvToKafka.util;

import br.com.fiap.mba.csvToKafka.pojo.Example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteCSV {

    String json;

    public void converter(List<Example> lista) {
        lista.forEach(item -> EnviaMensagem.Enviar(geraJson(item)));
    }

    public String geraJson(Example item) {

        ObjectMapper mapper = new ObjectMapper();
        String result = "";

        try {
            result = mapper.writeValueAsString(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
