package com.tss.structural.composite.model;

import java.util.ArrayList;
import java.util.List;

public class FolderComposite implements IFileComponent {
	
	private String name;
	private List<IFileComponent> components = new ArrayList<>();

	public FolderComposite(String name) {
		this.name = name;
	}

	public void addComponent(IFileComponent component) {
		components.add(component);
	}

	@Override
	public void showDetails() {
		System.out.println("Folder: " + name);
		for (IFileComponent component : components) {
			component.showDetails();
		}
	}
}
