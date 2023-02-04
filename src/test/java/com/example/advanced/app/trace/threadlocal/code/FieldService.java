package com.example.advanced.app.trace.threadlocal.code;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

	private String nameStore;

	public String logic(String name){
		log.info("저장 name ={} -> nameStroe={}",name,nameStore);
		nameStore = name;
		sleep(1000);
		log.info("조회 nameStore={}",nameStore);

		return nameStore;
	}

	private void sleep(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void name() {
	}
}
