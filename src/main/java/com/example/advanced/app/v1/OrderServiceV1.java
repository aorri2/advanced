package com.example.advanced.app.v1;

import org.springframework.stereotype.Service;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.hellotrace.HelloTraceV1;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

	private final OrderRepositoryV1 orderRepository;
	private final HelloTraceV1 trace;

	public void orderItem(String itemId) {

		TraceStatus traceStatus = null;
		try {
			traceStatus = trace.begin("OrderServiceV1.orderItem()");
			orderRepository.save(itemId);
			trace.end(traceStatus);
		} catch (Exception e) {
			trace.exception(traceStatus, e);
			throw e;
		}
	}
}
