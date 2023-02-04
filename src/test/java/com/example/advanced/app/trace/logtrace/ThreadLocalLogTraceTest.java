package com.example.advanced.app.trace.logtrace;

import org.junit.jupiter.api.Test;

import com.example.advanced.app.trace.TraceStatus;

class ThreadLocalLogTraceTest {

	ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

	@Test
	void begin_end_level2() {
		TraceStatus status1 = trace.begin("hello");
		TraceStatus status2 = trace.begin("hello2");
		trace.end(status2);
		trace.end(status1);
	}

	@Test
	void begin_exception_level2() {
		TraceStatus status1 = trace.begin("hello");
		TraceStatus status2 = trace.begin("hello2");
		trace.exception(status2, new IllegalStateException());
		trace.exception(status1, new IllegalStateException());
	}
}