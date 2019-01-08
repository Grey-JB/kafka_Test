package com.grey.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grey.util.ProducerUtil;

/**
 * 生产者-Ajax请求控制类
 * 
 * @author 江芳波
 * @mail jiangfangbo@zving.com
 * @date 2018年5月7日
 */

@RestController
public class ProducerController {
	@RequestMapping("/hello/{info}/{time}")
	public void helloName(@PathVariable String info, @PathVariable String time) {
		String[] split = info.split(":");
		String msg = null;
		if (split.length >= 3) {
			String sys = split[0];
			String broser = split[1];
			String ipAddress = split[2];
			msg = sys + "#" + broser + "#" + ipAddress + "#" + time;
		}
		KafkaProducer<String, String> producer = null;
		try {
			producer = new KafkaProducer<String, String>(ProducerUtil.getProperties());
			producer.send(new ProducerRecord<String, String>("topic-c", msg));
			System.out.println("Sent:" + msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}

	}
}
