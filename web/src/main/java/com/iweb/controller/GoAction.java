package com.iweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Chentyit
 * @Date 2019/8/11 14:20
 * @Description:
 */
@Controller
public class GoAction {

    /**
     * 进入主页
     * @return
     */
    @RequestMapping("/index")
    public String goIndex() {
        return "index";
    }
}
