package io;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 입력: ");
//		System.out.println("입력 결과: " + sc.nextInt() + "\n");
		System.out.println("입력 결과: " + sc.next() + "\n");
		
		System.out.print("두 번째 입력: ");
		System.out.println("입력 결과: " + sc.nextLine() + "\n");
		
		System.out.print("세 번째 입력: ");
		System.out.println("입력 결과: " + sc.nextLine() + "\n");
		
		sc.close();
	}
}