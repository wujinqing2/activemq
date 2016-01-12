package com.jin.active_mq.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener2 implements MessageListener {

	public void onMessage(Message message) {
		
		TextMessage textMessage = (TextMessage)message;
		
		System.out.println("接收信息2:" + textMessage);
	}
	
}
