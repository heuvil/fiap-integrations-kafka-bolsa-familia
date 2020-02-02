package br.com.fiap.consumer2.services;

import org.springframework.stereotype.Service;

import br.com.fiap.consumer2.config.KafkaConsumerConfig;
import br.com.fiap.consumer2.models.Beneficiario;
import br.com.fiap.consumer2.repository.BeneficiarioRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class CsvTopicListener {
    private final BeneficiarioRepository repository;

    @Autowired
    CsvTopicListener(final BeneficiarioRepository repository){
        this.repository = repository;
    }

    @KafkaListener(topicPattern = KafkaConsumerConfig.TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void process(String message) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Beneficiario beneficiario = mapper.readValue(message, Beneficiario.class);
        repository.save(beneficiario);
    }

}