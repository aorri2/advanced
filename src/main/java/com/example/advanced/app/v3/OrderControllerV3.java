package com.example.advanced.app.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.logtrace.LogTrace;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

	private final OrderServiceV3 orderService;
	private final LogTrace trace;

	@GetMapping("v3/request")
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
