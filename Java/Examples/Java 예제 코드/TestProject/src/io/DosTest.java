package io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosTest {
	public static void main(String[] args) {
		int age = 10;
		double height = 178.4;
		double weight = 64.8;
		char gender = 'M';
		boolean marriage = true;
		
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream("resources/primitive.bin"));

			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeDouble(weight);
			dos.writeChar(gender);
			dos.writeBoolean(marriage);
			
			System.out.println("Write complete.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}