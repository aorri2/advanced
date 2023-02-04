package com.example.advanced.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.hellotrace.HelloTraceV1;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

	private final OrderServiceV1 orderService;
	private final HelloTraceV1 trace;

	@GetMapping("v1/request")
	public String request(String itemId) {

		TraceStatus traceStatus = null;
		try {
			traceStatus = trace.begin("OrderController.request()");
			orderService.orderItem(itemId);
			trace.end(traceStatus);
			return "ok";
		} catch (Exception e) {
			trace.exception(traceStatus, e);
			throw e;
		}

	}
}
