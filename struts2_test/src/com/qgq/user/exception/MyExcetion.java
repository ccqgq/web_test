package com.qgq.user.exception;

public class MyExcetion extends Exception{
	public MyExcetion(Throwable throwable) {
		super(throwable);
	}

	public MyExcetion(String message) {
		super(message);
	}

	public MyExcetion() {
		super();
	}
}
