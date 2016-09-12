package com.qgq.user.utils;

import java.util.UUID;

public class UploadUtils {
	public static String getUUIDFileName(String fileName){
		return UUID.randomUUID()+fileName;
	}
}
