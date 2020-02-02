package br.com.fiap.consumer2.api.contratos.response;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class BeneficiarioResponse {    
    @JsonProperty("uf")
    public String uf;
    @JsonProperty("nome_municipio")
    public String nomeMunicipio;
    @JsonProperty("nis_favorecido")
    public String nisFavorecido;
    @JsonProperty("nome_favorecido")
    public String nomeFavorecido;
    @JsonProperty("valor_parcela")
    public Integer valorParcela;    
}