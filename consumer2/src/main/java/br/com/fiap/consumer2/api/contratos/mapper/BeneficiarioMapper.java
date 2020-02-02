package br.com.fiap.consumer2.api.contratos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.fiap.consumer2.api.contratos.response.BeneficiarioResponse;
import br.com.fiap.consumer2.models.Beneficiario;

@Mapper 
public interface BeneficiarioMapper {
 
    BeneficiarioMapper INSTANCE = Mappers.getMapper( BeneficiarioMapper.class ); 
 
    BeneficiarioResponse toDto(Beneficiario car); 
}