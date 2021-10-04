package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FosTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("resources/cookie.png");
			fos = new FileOutputStream("resources/cookie_copy.png");
			
			byte[] buf = new byte[50];
			int count;

			while (true) {
				count = fis.read(buf);
				if (count < buf.length) {
					for (int i = 0; i < count; i++) fos.write(buf[i]);
					break;
				}
				fos.write(buf);
			}
			
			System.out.println("Copy complete.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}