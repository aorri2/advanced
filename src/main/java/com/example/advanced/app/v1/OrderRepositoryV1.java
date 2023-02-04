package com.example.advanced.app.v1;

import org.springframework.stereotype.Repository;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.hellotrace.HelloTraceV1;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
	private final HelloTraceV1 trace;

	public void save(String itemId){
		//저장 로직
		TraceStatus traceStatus = null;
		try {
			traceStatus = trace.begin("OrderRepository.save()");
			if (itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생!");
			}
			sleep(1000);

			trace.end(traceStatus);
		} catch (Exception e) {
			trace.exception(traceStatus, e);
			throw e;
		}

	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
