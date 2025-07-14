package com.tss.behavioral.observer.model;

public class WhatsappNotifier implements INotifiers {

	@Override
	public void sendNotification(Account account) {
		System.out.println("WhatsApp Notification: Account " + account.getAccNo() + " of " + account.getName()
				+ " has new activity. Current balance: " + account.getBalance());
	}
}
