package com.grey.controller;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.grey.dao.CountDao;
import com.grey.po.Count;

public class Consumer {
	/**
	 * 消费者启动类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "127.0.0.1:9092");
		properties.put("group.id", "group-1");
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("auto.offset.reset", "earliest");
		properties.put("session.timeout.ms", "30000");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
		kafkaConsumer.subscribe(Arrays.asList("topic-c"));
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, value = %s", record.offset(), record.value());
				String value = record.value();
				String[] split = value.split("#");
				if (split.length >= 4) {
					String sys = split[0];
					String broser = split[1];
					String ipAddress = split[2];
					String time = split[3];
					Count count = new Count();
					count.setSys(sys);
					count.setBroser(broser);
					count.setIpAddress(ipAddress);
					count.setTime(time);
					CountDao dao = new CountDao();
					dao.add(count);
					System.out.println(count.toString());
				}
				System.out.println();
			}
		}

	}
}