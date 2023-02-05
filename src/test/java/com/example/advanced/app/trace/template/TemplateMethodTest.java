package com.example.advanced.app.trace.template;

import org.junit.jupiter.api.Test;

import com.example.advanced.app.trace.template.code.AbstractTemplate;
import com.example.advanced.app.trace.template.code.SubClassLogic1;
import com.example.advanced.app.trace.template.code.SubClassLogic2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {

	@Test
	void templateMethodV0() {
		logic1();
		logic2();
	}

	private void logic1() {
		long startTime = System.currentTimeMillis();

		//start bussiness logic
		log.info("비즈니스 로직 1 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}

	private void logic2() {
		long startTime = System.currentTimeMillis();

		//start bussiness logic
		log.info("비즈니스 로직 2 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}

	@Test
	void templateMethodV1(){
		AbstractTemplate template = new SubClassLogic1();
		template.execute();

		AbstractTemplate template2 = new SubClassLogic2();
		template2.execute();
	}
	@Test
	void templateMethodV2(){
		AbstractTemplate template = new AbstractTemplate() {
			@Override
			protected void call() {
				log.info("익명 클래스 사용");
			}
		};
		template.execute();
	}
}
