package br.com.fiap.mba.csvToKafka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BolsaFamilia {
    private String mesReferencia;
    private String mesCompetencia;
    private String uf;
    private String codigoMunicipioSiafi;
    private String nomeMunicipio;
    private String nisFavorecido;
    private String nomeFavorecido;
    private BigDecimal valorParcela;
}
