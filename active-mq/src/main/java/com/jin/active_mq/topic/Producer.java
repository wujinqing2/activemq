package com.jin.active_mq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

/**
 * 信息生产者
 * 
 * @author wu.jinqing
 * @date 2016年1月8日
 */
public class Producer {
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static final String BROKER_URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory;// 连接工厂
		Connection connection;// 连接
		Session session;// 会话
		Destination destination;//目的地队列
		MessageProducer messageProducer;// 信息生产者
		TextMessage message;// 具体消息
		
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		destination = session.createTopic("FirstTopic");
		
		messageProducer = session.createProducer(destination);
		
		message = new ActiveMQTextMessage();
		message.setText("Topic-信息内容: ");
		messageProducer.send(message);
		session.commit();
		connection.close();
	}
}
