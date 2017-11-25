package com.myorg.controller;

import com.myorg.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/goLogin")
    @ResponseBody
    public Map<String, Object> goLogin(@RequestBody User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);
        return map;
    }

}
