# Atividade de Integration Tools - 34SCJ

Crie um produtor para carregar os dados do arquivo do bolsa família (referente ao período de janeiro/2019) para um Topic no Kafka e implemente 3 consumidores que irão nos ajudar a responder algumas perguntas.

  - Exibir [UF] + [somar da parcela] + [qtd de beneficiários] até o momento
  - Mostrar dados do beneficiário que tenha a maior parcela até o momento
  - Quantidade de registros lidos do Topic

# Para executar

  - Executar o docker-compose up
  - Executar o get em localhost:8080 para carregar os registros no tópico csv_topic
  - Executar observar o log do container consumer1, ficará ativo por 30s para consumir as mensagens e mostrar o cálculo.


Membros do Grupo:
  - Caio Souza Norbiato (RM333950)
  - Heuler ...
  - Rafael ...
  - Bruno ...


### Tech

Links

* [Trello](https://trello.com/b/r84eF4pp/trabalho-integra%C3%A7%C3%A3o) - Link para o trello
* [Trello](https://breakdance.github.io/breakdance/) - Link bigpicture


### Installation

Para executar o projeto

```sh
$ docker-compose up
```
