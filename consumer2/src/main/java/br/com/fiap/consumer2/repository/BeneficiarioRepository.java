package br.com.fiap.consumer2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.consumer2.models.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {
    Beneficiario findFirstOrderByValorParcelaDesc();
}