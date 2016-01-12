package com.jin.active_mq.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener implements MessageListener {

	public void onMessage(Message message) {
		
		TextMessage textMessage = (TextMessage)message;
		
		System.out.println("接收信息:" + textMessage);
	}
	
}
