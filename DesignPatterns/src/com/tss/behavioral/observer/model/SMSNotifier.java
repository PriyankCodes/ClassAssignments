package com.tss.behavioral.observer.model;

public class SMSNotifier implements INotifiers {

	@Override
	public void sendNotification(Account account) {
		System.out.println("SMS Notification: Account " + account.getAccNo() + " of " + account.getName()
				+ " has new activity. Current balance: " + account.getBalance());
	}

}
