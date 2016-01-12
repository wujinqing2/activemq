package com.jin.active_mq.topic;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener implements MessageListener {

	public void onMessage(Message message) {
		
		TextMessage textMessage = (TextMessage)message;
		
		System.out.println("Topic-接收信息:" + textMessage);
	}
	
}
