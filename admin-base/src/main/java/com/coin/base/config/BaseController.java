package com.coin.base.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BaseController
 * @Description: TODO
 * @Author kh
 * @Date 2020/4/18 18:12
 * @Version V1.0
 **/
@RestController
@RequestMapping("/")
public class BaseController {
    @GetMapping("base")
    public String base() {
        return "base";
    }
}
