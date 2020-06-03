package com.mobile.mall.utils.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/test/t1")
public class WebTestController {
    public static class User{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
    @PostMapping("helper")
    public Object test(@NotEmpty String keyword,
                         @RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer limit,
                       @RequestBody User user) {
        return "这是" + page + "页，每页"+ limit + ",HI "+ user.getName() + ":" + user.getAge();
    }
}

