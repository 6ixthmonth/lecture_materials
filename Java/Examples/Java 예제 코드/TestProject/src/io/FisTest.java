package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FisTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("resources/hello.txt");
//			fis = new FileInputStream("resources\\hello.txt");
//			fis = new FileInputStream("C:/hello2.txt");
//			fis = new FileInputStream("C:\\hello2.txt");

			while (true) {
				int data = fis.read();
				if (data == -1) break;
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}