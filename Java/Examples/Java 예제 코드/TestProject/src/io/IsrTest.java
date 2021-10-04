package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsrTest {
	public static void main(String[] args) {
		InputStreamReader isr = null;
		
		try {
			isr = new InputStreamReader(new FileInputStream("resources/hello.txt"), "MS949");
			while (true) {
				int data = isr.read();
				if (data == -1) break;
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isr != null) isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}