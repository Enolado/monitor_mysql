package com.lwl.monitor.controller;

import com.lwl.monitor.entity.Profile;
import com.lwl.monitor.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试模块
 * @author lwl
 * @create 2021/11/15 10:56
 */
@RestController
@RequestMapping("/events")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    /**
     * 测试SQL语句效率
     * @param profile
     * @return Map<String,Object>
     */
    @RequestMapping(value = "profile",method = RequestMethod.POST)
    public Map<String,Object> profile(@RequestBody() Profile profile){
        //有SQL注入问题,下版本更新
        Map<String, Object> map = new HashMap<>(1);
        map = profileService.profile(profile);
        return map;
    }
}
