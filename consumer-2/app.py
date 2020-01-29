import json
from kafka import KafkaConsumer


def read_json_message(v):
    try:
        return json.loads(v.decode('utf-8'))
    except json.decoder.JSONDecodeError:
        print('Unable to decode: %s', v)
    return None


consumer = KafkaConsumer(bootstrap_servers='localhost:9092', auto_offset_reset='latest',
                         value_deserializer=read_json_message)
consumer.subscribe(['teste'])

for message in consumer:
    print(message)
