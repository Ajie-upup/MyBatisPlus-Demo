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

    /**
     * 测试乐观锁失败场景
     */
    @Test
    public void testOptimisticLockerFail() {
        User user = userMapper.selectById(7L);
        user.setAge(19);
        //模拟取出数据后，数据库中version实际数据比取出的值大，即已被其它线程修改并更新了version
        user.setVersion(user.getVersion() - 1);
        // 执行更新，version字段没有自增
        userMapper.updateById(user);
    }


}
