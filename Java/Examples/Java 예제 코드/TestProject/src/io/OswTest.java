package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OswTest {
	public static void main(String[] args) {
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		
		try {
			isr = new InputStreamReader(new FileInputStream("resources/hello.txt"));
			osw = new OutputStreamWriter(new FileOutputStream("resources/copy_hello.bin"));
			
			while (true) {
				int data = isr.read();
				if (data == -1) break;
				osw.write((char) data); 
			}
			
			System.out.println("Copy complete.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isr != null) isr.close();
				if (osw != null) osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}