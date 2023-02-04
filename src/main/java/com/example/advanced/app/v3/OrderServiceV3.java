package com.example.advanced.app.v3;

import org.springframework.stereotype.Service;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.logtrace.LogTrace;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

	private final OrderRepositoryV3 orderRepository;
	private final LogTrace trace;

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
