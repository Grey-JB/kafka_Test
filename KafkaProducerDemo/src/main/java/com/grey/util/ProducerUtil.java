package com.grey.util;

import java.util.Properties;

public class ProducerUtil {
	private static Properties properties;

	public static Properties getProperties() {
		properties = new Properties();
		properties.put("bootstrap.servers", "127.0.0.1:9092");
		properties.put("acks", "all");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("linger.ms", 1);
		properties.put("buffer.memory", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		return properties;
	}
}
