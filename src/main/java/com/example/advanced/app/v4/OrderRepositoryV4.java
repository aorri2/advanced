package com.example.advanced.app.v4;

import org.springframework.stereotype.Repository;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.logtrace.LogTrace;
import com.example.advanced.app.trace.template.AbstractTemplate;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
	private final LogTrace trace;

	public void save(String itemId){

		AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
			@Override
			protected Void call() {
				if (itemId.equals("ex")) {
					throw new IllegalStateException("예외 발생!");
				}
				sleep(1000);

				return null;
			}
		};
		//저장 로직
		template.execute("OrderRepository.save()");

	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
