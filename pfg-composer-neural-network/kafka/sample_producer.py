from kafka import KafkaProducer

producer = KafkaProducer(bootstrap_servers='127.0.0.1:9092')

producer.send(topic='sample', value=b'Hello, World!', partition=0, key=b'1')
producer.flush()
