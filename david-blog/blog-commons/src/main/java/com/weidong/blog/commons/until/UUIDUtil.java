package com.weidong.blog.commons.until;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.UUID;

/**
 * UUID生成器
 * 
 */
public class UUIDUtil {
	public static String getUUID() {

		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) throws ScriptException {
		System.out.println(UUIDUtil.getUUID());
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine script = manager.getEngineByName("JavaScript");
		Object o = script.eval("1>=1&&2<1");
		System.out.println(o);
	}
	
	 
}