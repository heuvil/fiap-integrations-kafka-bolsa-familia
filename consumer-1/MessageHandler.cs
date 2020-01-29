using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Threading;
using System.Threading.Tasks;
using Confluent.Kafka;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace consumer1
{
    public class MessageHandler : IHostedService
    {
        private readonly ILogger _logger;
        public MessageHandler(ILogger<MessageHandler> logger)
        {
            _logger = logger;
        }

        public Task StartAsync(CancellationToken cancellationToken)
        {
            var conf = new ConsumerConfig
            {
                GroupId = "test-consumer-group",
                BootstrapServers = "kafka:9092",
                AutoOffsetReset = AutoOffsetReset.Earliest
            };

            var listBolsaFamilia = new List<BolsaFamilia>();

            using (var c = new ConsumerBuilder<Ignore, string>(conf).Build())
            {
                c.Subscribe("csv_topic");
                var cts = new CancellationTokenSource();
                cts.CancelAfter(30000);

                try
                {
                    while (true)
                    {
                        var message = c.Consume(cts.Token);
                        //_logger.LogInformation($"Mensagem: {message.Value} recebida de {message.TopicPartitionOffset}");
                        Console.WriteLine($"Mensagem: {message.Value} recebida de {message.TopicPartitionOffset}");
                        var bolsaFamilia = JsonSerializer.Deserialize<BolsaFamilia>(message.Value);
                        listBolsaFamilia.Add(bolsaFamilia);
                    }
                }
                catch (OperationCanceledException)
                {
                    c.Close();
                }
                finally
                {
                    foreach (var item in listBolsaFamilia.GroupBy(x => x.uf)
                                    .Select(group => new
                                    {
                                        uf = group.First().uf,
                                        somaParcelas = group.Sum(s => s.valorParcela),
                                        quantidadePessoas = group.Count()
                                    }))
                    {
                        Console.WriteLine("Na UF: {0} Temos um total de {1} Beneficiados, e o total do pagamento é {2}", item.uf, item.quantidadePessoas, item.somaParcelas);
                    }
                }

            }




            return Task.CompletedTask;

        }

        public Task StopAsync(CancellationToken cancellationToken)
        {
            return Task.CompletedTask;
        }
    }
}