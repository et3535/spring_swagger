package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Pjt01ApplicationTests {

	
	 @Test 
	 void contextLoads() { 
		 System.out.println("TEST1\n");
		 Version v = new Version(); 
	 }
	 
	@Test
	void contextLoads2() {
		System.out.println("TEST2\n");
		ArrayList<Version> arrv = new ArrayList<>();
		arrv.add(new Version("1.1.3-SNAPSHOT"));
		arrv.add(new Version("0.1.3-SNAPSHOT"));
		arrv.add(new Version("2.1.3-SNAPSHOT"));
		for(int i=0;i<arrv.size();i++) {
			System.out.println(arrv.get(i).getVersion());
		}
		Collections.sort(arrv);
		for(int i=0;i<arrv.size();i++) {
			System.out.println(arrv.get(i).getVersion());
		}
	}
	@Test
	void contextLoads3() {
		System.out.println("TEST3");
	}
}
