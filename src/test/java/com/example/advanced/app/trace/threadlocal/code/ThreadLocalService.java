package com.example.advanced.app.trace.threadlocal.code;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

	private ThreadLocal<String> nameStore = new ThreadLocal<>();

	public String logic(String name){
		log.info("저장 name ={} -> nameStroe={}",name,nameStore.get());
		nameStore.set(name);
		sleep(1000);
		log.info("조회 nameStore={}",nameStore.get());

		return nameStore.get();
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
