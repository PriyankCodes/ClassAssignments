package com.tss.structural.proxy.test;

import com.tss.structural.proxy.model.IImage;
import com.tss.structural.proxy.model.ProxyImage;

public class ImageTest {
	public static void main(String[] args) {
		IImage image = new ProxyImage("example.jpg");

		image.display();
		image.display();
	}
}