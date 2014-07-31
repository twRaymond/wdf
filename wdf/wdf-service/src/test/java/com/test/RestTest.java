package com.test;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

public class RestTest {
	private static final String URI = "http://localhost:8080/wdf-web";
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		AsyncRestTemplate template = new AsyncRestTemplate();
		ListenableFuture<ResponseEntity<String>> future = template
				.getForEntity(URI + "/user/str/json?accountId=raymond lin", String.class);
		System.out.println(future.get());
		future = template
				.getForEntity(URI + "/user/obj/json?accountId=raymond lin", String.class);
		System.out.println(future.get());
	}
}
