package com.example.advanced.app.trace.logtrace;

import com.example.advanced.app.trace.TraceStatus;

public interface LogTrace {
	TraceStatus begin(String message);

	void end(TraceStatus status);

	void exception(TraceStatus status, Exception e);
}
