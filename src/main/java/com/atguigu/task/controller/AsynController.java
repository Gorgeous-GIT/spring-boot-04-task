package com.atguigu.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.task.service.AsyncService;

@RestController
public class AsynController {
	@Autowired
	AsyncService asyncService;
	//告诉spring这是一个异步方法
	@GetMapping("/hello")
	public String hello() {
		asyncService.hello();
		return "success";
	}
}
