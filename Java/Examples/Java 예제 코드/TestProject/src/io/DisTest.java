package io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DisTest {
	public static void main(String[] args) {
		int age;
		double height;
		double weight;
		char gender;
		boolean marriage;
		
		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(new FileInputStream("resources/primitive.bin"));
			
			age = dis.readInt();
			height = dis.readDouble();
			weight = dis.readDouble();
			gender = dis.readChar();
			marriage = dis.readBoolean();
			
			System.out.println("연령: " + age
							+ ", 신장: " + height
							+ ", 체중: " + weight
							+ ", 성별: " + gender
							+ ", 혼인: " + marriage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}