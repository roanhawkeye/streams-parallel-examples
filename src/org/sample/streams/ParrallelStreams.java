package org.sample.streams;

import java.util.stream.Stream;

public class ParrallelStreams {
	
	public static void main(String[] args) {
		
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		
		Stream.iterate("+", s -> s + "+")
			.parallel()
			.limit(6)
			.peek(s -> System.out.println(s + " processed in the thread " + Thread.currentThread().getName()))
			.forEach(System.out::println);
		
	}

}
