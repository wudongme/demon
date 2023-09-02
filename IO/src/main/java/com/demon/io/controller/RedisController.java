package com.demon.io.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @desc
 * @fileName RedisController.java
 * @date 2023/7/31/0031 14:16
 * @author Dongmo.Wu
 */
@RestController
@Slf4j
public class RedisController {
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private RedisTemplate redisTemplate;

	@GetMapping("/redis/{id}")
	public Long getDbMoveCount(@PathVariable("id") Long id) {
		/*Long count = (Long) redisTemplate.opsForValue().get("DIS:DB_MOVE:TASK:" + id);
		return count;*/
		return -1L;
	}

	@GetMapping("/redisIncrease/{id}")
	public Long redisIncrease(@PathVariable("id") Long id) {

		String test_increase = "TEST_INCREASE";

		stringRedisTemplate.opsForValue().set(test_increase, "1");
		log.info("11111111111111111=" + stringRedisTemplate.opsForValue().get(test_increase));

		stringRedisTemplate.opsForValue().increment(test_increase);
		log.info("22222222222222222=" + stringRedisTemplate.opsForValue().get(test_increase));

		stringRedisTemplate.opsForValue().getAndDelete(test_increase);
		log.info("33333333333333333=" + stringRedisTemplate.opsForValue().get(test_increase));

		log.info("44444444444444444=" + stringRedisTemplate.opsForValue().get(test_increase));

		return 1L;
	}


}
