package br.com.fiap.consumer2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="beneficiario")
public class Beneficiario {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    

    @Column(name="mes_referencia")
    public String mesReferencia;
    
    @Column(name="mes_competencia")
    public String mesCompetencia;
    
    @Column(name="uf")
    public String uf;
    
    @Column(name="codigo_municipio_siafi")
    public String codigoMunicipioSiafi;
    
    @Column(name="nome_municipio")
    public String nomeMunicipio;
    
    @Column(name="nis_favorecido")
    public String nisFavorecido;
    
    @Column(name="nome_favorecido")
    public String nomeFavorecido;
    
    @Column(name="valor_parcela")
    public Double valorParcela;    
}