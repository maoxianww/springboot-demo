package org.example.service.impl;

import org.example.mapper.TestTableMapper;
import org.example.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auth: w
 * @desc:
 * @date: 2023/10/23 10:19
 */
@Service
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    TestTableMapper testTableMapper;
    @Override
    public Long getTestUserCount() {
        return testTableMapper.countByExample(null);
    }
}
