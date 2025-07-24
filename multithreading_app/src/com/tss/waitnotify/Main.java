package com.tss.waitnotify;

public class Main {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}
}
