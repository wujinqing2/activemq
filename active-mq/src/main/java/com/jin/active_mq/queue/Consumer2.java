package com.jin.active_mq.queue;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 * 信息消费者
 * 
 * @author wu.jinqing
 * @date 2016年1月8日
 */
public class Consumer2 {
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static final String BROKER_URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory connectionFactory;// 连接工厂
		Connection connection;// 连接
		Session session;// 会话
		Destination destination;//目的地队列
		MessageConsumer messageConsumer;// 信息消费者
		
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		destination = new ActiveMQQueue("FirstQueue");
		messageConsumer = session.createConsumer(destination);
		messageConsumer.setMessageListener(new Listener2());
		

//		connection.close();
	}

}
