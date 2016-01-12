package com.jin.active_mq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 信息消费者
 * 
 * @author wu.jinqing
 * @date 2016年1月8日
 */
public class Consumer {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args)  {
		try
		{
			ConnectionFactory connectionFactory;// 连接工厂
			Connection connection;// 连接
			Session session;// 会话
			Destination destination;//目的地队列
			MessageConsumer messageConsumer;// 信息消费者
			
			connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createTopic("FirstTopic");
			
			messageConsumer = session.createConsumer(destination);
			messageConsumer.setMessageListener(new Listener());
		}catch(JMSException e)
		{
			e.printStackTrace();
		}

//		connection.close();
	}

}
