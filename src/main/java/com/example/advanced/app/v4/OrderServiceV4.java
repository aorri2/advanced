package com.example.advanced.app.v4;

import org.springframework.stereotype.Service;

import com.example.advanced.app.trace.TraceStatus;
import com.example.advanced.app.trace.logtrace.LogTrace;
import com.example.advanced.app.trace.template.AbstractTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

	private final OrderRepositoryV4 orderRepository;
	private final LogTrace trace;

	public void orderItem(String itemId) {

		AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
			@Override
			protected Void call() {
				orderRepository.save(itemId);

				return null;
			}
		};

		template.execute("OrderService.orderItem()");
	}
}
