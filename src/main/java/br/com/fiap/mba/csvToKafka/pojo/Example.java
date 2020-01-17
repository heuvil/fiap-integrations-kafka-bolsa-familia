package br.com.fiap.mba.csvToKafka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Example {

    private String dataInicio;
    private int numero1;
    private int numero2;
    private String cor;
    private String fimDeLinha;

}
