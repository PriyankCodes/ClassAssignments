package com.tss.structural.composite.test;

import com.tss.structural.composite.model.FileLeaf;
import com.tss.structural.composite.model.FolderComposite;
import com.tss.structural.composite.model.IFileComponent;

public class CompositeTest {
	public static void main(String[] args) {
		
		IFileComponent file1 = new FileLeaf("Resume.pdf");
		IFileComponent file2 = new FileLeaf("CoverLetter.docx");

		FolderComposite documents = new FolderComposite("Documents");
		documents.addComponent(file1);
		documents.addComponent(file2);

		IFileComponent file3 = new FileLeaf("Photo.jpg");
		FolderComposite pictures = new FolderComposite("Pictures");
		pictures.addComponent(file3);

		FolderComposite root = new FolderComposite("MyDrive");
		root.addComponent(documents);
		root.addComponent(pictures);

		root.showDetails();
	}
}
