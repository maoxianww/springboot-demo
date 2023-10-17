package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.domain.entity.NeoProperties;
import org.example.domain.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth: w
 * @desc: testController
 * @date: 2023/10/16 19:07
 */

@RestController
@RequestMapping("/api")
@Api(tags = "业务说明-TestController",value = "/api/xxx")
public class TestController {
    @Autowired
    NeoProperties  neoProperties;

    @GetMapping("/testUser")
    @ApiOperation(value = "测试接口-查询测试用户信息")
    public TestUser getUser(){
        TestUser testUser = new TestUser();
        testUser.setName("wu");
        testUser.setAge(18);
        return testUser;
    }

    @GetMapping("/neoProperties")
    @ApiOperation(value = "测试接口-查询neoProperties")
    public NeoProperties getNeoProperties(){
        return neoProperties;
    }
}
