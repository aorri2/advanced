package com.example.advanced.app.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.hellotrace.HelloTraceV2;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

	private final OrderServiceV2 orderService;
	private final HelloTraceV2 trace;

	@GetMapping("v2/request")
	public String request(String itemId) {

		TraceStatus traceStatus = null;
		try {
			traceStatus = trace.begin("OrderController.request()");
			orderService.orderItem(traceStatus.getTraceId(),itemId);
			trace.end(traceStatus);
			return "ok";
		} catch (Exception e) {
			trace.exception(traceStatus, e);
			throw e;
		}

	}
}
