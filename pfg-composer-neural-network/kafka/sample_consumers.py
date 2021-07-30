from kafka import KafkaConsumer

consumer = KafkaConsumer('melodia.composer.neural-network.train.input')

for message in consumer:
    print(message)
