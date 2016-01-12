package com.jin.active_mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicReceiver {

	public static void main(String[] args) throws Throwable {
		final ConnectionFactory connFactory = new ActiveMQConnectionFactory();

	    final Connection conn = connFactory.createConnection();

	    final Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

	    final Destination dest = sess.createTopic("SampleTopic");

	    final MessageConsumer cons = sess.createConsumer(dest);

	    conn.start();

	    final Message msg = cons.receive();

	    System.out.println(msg);

	    conn.close();

	}

}
