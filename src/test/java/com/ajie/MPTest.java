package com.ajie;

import com.ajie.mapper.UserMapper;
import com.ajie.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author ajie
 * @date 2023/5/17
 * @description:
 */
@SpringBootTest
public class MPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(20);
        user.setName("ajie_test");
        user.setEmail("xxxxxxxxx@qq.com");
        // 返回受影响的行数
        int insert = userMapper.insert(user);
        // id 自动回填
        // 默认 id 策略为全局唯一id，可以修改为主键自增
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6L);
        user.setName("hy");
        user.setAge(20);
        user.setEmail("xxxx@qq.com");
        // UPDATE user SET name=?, age=?, email=? WHERE id=?
        int update = userMapper.updateById(user);
        System.out.println(user);
    }


    /**
     * 根据 id 查询
     */
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 根据 id 批量查询
     */
    @Test
    public void testByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);

        // 查询到的结果封装在 page 对象 records 中
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testLogicDelete() {
        userMapper.deleteById(1L);
        System.out.println(userMapper.selectById(1L)); // null
    }

}
