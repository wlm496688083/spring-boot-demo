package com.example.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by wanglimin1 on 2016/12/7.
 */
@RestController
public class RedisController {
    @GetMapping("/setRedis")
    public ResponseEntity index(HttpSession httpSession) {
        httpSession.setAttribute("user", "helloword");
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/getRedis")
    public ResponseEntity hello(HttpSession httpSession) {
        return ResponseEntity.ok(httpSession.getAttribute("user"));
    }
}
