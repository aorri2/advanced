package com.example.advanced.app.trace.hellotrace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.advanced.app.trace.TraceStatus;

class HelloTraceV1Test {
	@Test
	void begin_end() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus hello = trace.begin("hello");
		trace.end(hello);
	}

	@Test
	void begin_exception() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus hello = trace.begin("hello");
		trace.exception(hello,new IllegalStateException());
	}
}