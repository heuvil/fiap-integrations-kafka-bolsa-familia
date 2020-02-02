package br.com.fiap.consumer2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.consumer2.api.contratos.mapper.BeneficiarioMapper;
import br.com.fiap.consumer2.api.contratos.response.BeneficiarioResponse;
import br.com.fiap.consumer2.models.Beneficiario;
import br.com.fiap.consumer2.repository.BeneficiarioRepository;


@RestController
@RequestMapping("beneficiarios")
public class BeneficiariosController {

    private BeneficiarioMapper mapper = BeneficiarioMapper.INSTANCE ;
    private final BeneficiarioRepository repository;

    @Autowired
    BeneficiariosController(BeneficiarioRepository repository){
        this.repository = repository;
    }

    @GetMapping("/maior")
    public BeneficiarioResponse maior() {
        Sort sort = Sort.by(Direction.DESC, "valorParcela");
        return mapper.toDto(repository.findAll(sort)
                            .stream()
                            .findFirst()
                            .map(b->b)
                            .orElse(null));
        
    }        
}