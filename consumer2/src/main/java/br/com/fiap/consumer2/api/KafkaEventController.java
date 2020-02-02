package br.com.fiap.consumer2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.consumer2.api.contratos.response.BeneficiarioResponse;
import br.com.fiap.consumer2.api.mapper.BeneficiarioMapper;
import br.com.fiap.consumer2.repository.BeneficiarioRepository;


@RestController
public class KafkaEventController {

    private BeneficiarioMapper mapper = BeneficiarioMapper.INSTANCE ;
    private final BeneficiarioRepository repository;

    @Autowired
    KafkaEventController(BeneficiarioRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ModelAndView index() {        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView; 
    }   

    @GetMapping("/maior")
    public BeneficiarioResponse maior() {
        return mapper.toDto(repository.findFirstOrderByValorParcelaDesc());
    }        
}