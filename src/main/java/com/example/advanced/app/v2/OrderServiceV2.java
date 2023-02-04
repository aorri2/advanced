package com.example.advanced.app.v2;

import org.springframework.stereotype.Service;

import com.example.advanced.app.trace.TraceId;
import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.hellotrace.HelloTraceV2;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

	private final OrderRepositoryV2 orderRepository;
	private final HelloTraceV2 trace;

	public void orderItem(TraceId traceId, String itemId) {

		TraceStatus traceStatus = null;
		try {
			traceStatus = trace.beginSync(traceId,"OrderServiceV1.orderItem()");
			orderRepository.save(traceStatus.getTraceId(),itemId);
			trace.end(traceStatus);
		} catch (Exception e) {
			trace.exception(traceStatus, e);
			throw e;
		}
	}
}
