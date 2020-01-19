package br.com.fiap.mba.csvToKafka.util;

import br.com.fiap.mba.csvToKafka.pojo.BolsaFamilia;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteCSV {

    String json;

    public void converter(List<BolsaFamilia> lista) {
        lista.forEach(item -> EnviaMensagem.Enviar(geraJson(item)));
    }

    public String geraJson(BolsaFamilia item) {

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
