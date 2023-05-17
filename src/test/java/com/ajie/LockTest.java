package com.ajie;

import com.ajie.mapper.UserMapper;
import com.ajie.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ajie
 * @date 2023/5/17
 * @description:
 */
@SpringBootTest
public class LockTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(7L);
        // 修改数据
        user.setAge(18);
        // 执行更新
        userMapper.updateById(user);
    }


}
