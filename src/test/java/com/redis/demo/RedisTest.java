package com.redis.demo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author: Sophist Wu
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2016年2月3日 下午2:46:44
 * @desc:
 * 
 */
public class RedisTest {
	@Test
	public void testName() throws Exception {
		new RedisClient().show();
	}
}
