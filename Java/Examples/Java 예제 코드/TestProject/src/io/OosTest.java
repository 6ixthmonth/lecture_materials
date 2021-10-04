package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OosTest {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("resources/userList.bin"));
			
			User kim = new User("김아무개", 35, 178.5, 'M', true);
			User lee = new User("이뭐씨", 25, 167.4, 'F', false);
			
			oos.writeObject(kim);
			oos.writeObject(lee);
			
			System.out.println("Write complete.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}