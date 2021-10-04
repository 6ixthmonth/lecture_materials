package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FwTest {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("resources/hello.txt");
			fw = new FileWriter("resources/copy/hello_copy.txt");
			
			while (true) {
				int data = fr.read();
				if (data == -1) break;
				fw.write(data);
			}
			
			System.out.println("Copy complete.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
				if (fr != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}