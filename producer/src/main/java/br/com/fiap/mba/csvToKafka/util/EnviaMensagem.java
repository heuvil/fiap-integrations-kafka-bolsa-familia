package br.com.fiap.mba.csvToKafka.util;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class EnviaMensagem {

    private static final String TOPIC_NAME = "csv_topic";
    private static Producer<Long, String> producer = ProducerCreator.createProducer();
    private static ProducerRecord<Long, String> record;

    public static void Enviar(String mensagem){
         record = new ProducerRecord<Long, String>(EnviaMensagem.TOPIC_NAME, mensagem);

        try {
            RecordMetadata metadata = producer.send(record).get();
            System.out.println("Mensagem enviada: " + mensagem + "\nMetadata: " + metadata.toString());
        } catch (Exception e ){
            System.out.println("Erro ao enviar mensagem " + mensagem);
            e.printStackTrace();
        }
    }
}
