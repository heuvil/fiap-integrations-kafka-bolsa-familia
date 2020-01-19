package br.com.fiap.mba.csvToKafka.controller;

import java.util.List;

import br.com.fiap.mba.csvToKafka.pojo.BolsaFamilia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.mba.csvToKafka.util.CSVDataLoader;
import br.com.fiap.mba.csvToKafka.util.ConverteCSV;

@RestController
@RequestMapping("/")
public class CsvToKafkaController {

    @GetMapping(path = {""})
    public ResponseEntity<?> inicia() {
        
        CSVDataLoader loader = new CSVDataLoader();
		List<BolsaFamilia> lista = loader.loadObjectList(BolsaFamilia.class, "201901_BolsaFamilia_Pagamentos.csv");
		ConverteCSV c = new ConverteCSV();
        c.converter(lista);
        
        return ResponseEntity.ok().build();
    }

}