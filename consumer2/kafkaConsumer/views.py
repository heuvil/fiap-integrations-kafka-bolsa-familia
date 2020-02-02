from django.shortcuts import render

# Create your views here.

from django.http import HttpResponse
from consumer2 import settings

from kafka import KafkaConsumer

def index(request):
    template_name = 'kafkaConsumer/index.html'
    consumer = KafkaConsumer(
        'requests',
        bootstrap_servers=settings.KAFKA_SERVERS,
        consumer_timeout_ms=1000
    )
    #test-consumer-group
    return render(request, template_name, {consumer})
