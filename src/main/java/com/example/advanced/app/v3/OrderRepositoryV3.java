package com.example.advanced.app.v3;

import org.springframework.stereotype.Repository;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.logtrace.LogTrace;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
	private final LogTrace trace;

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
