package com.example.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.advanced.app.trace.logtrace.LogTrace;
import com.example.advanced.app.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

	@Bean
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}
}
