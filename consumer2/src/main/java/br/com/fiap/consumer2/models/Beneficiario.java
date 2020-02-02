package br.com.fiap.consumer2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Beneficiario {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    @JsonProperty("mesReferencia")
    public String mesReferencia;
    @JsonProperty("mesCompetencia")
    public String mesCompetencia;
    @JsonProperty("uf")
    public String uf;
    @JsonProperty("codigoMunicipioSiafi")
    public String codigoMunicipioSiafi;
    @JsonProperty("nomeMunicipio")
    public String nomeMunicipio;
    @JsonProperty("nisFavorecido")
    public String nisFavorecido;
    @JsonProperty("nomeFavorecido")
    public String nomeFavorecido;
    @JsonProperty("valorParcela")
    public Integer valorParcela;    
}