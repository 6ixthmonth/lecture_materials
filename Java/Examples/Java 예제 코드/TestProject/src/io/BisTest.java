package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BisTest {
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream("resources/hello.txt"));
			
			while (true) {
				int data = bis.read();
				if (data == -1) break;
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}