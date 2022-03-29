//package com.example.shiro_demo.controller;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.shiro_demo.entity.User;
//import com.example.shiro_demo.utils.ResultData;
//import com.example.shiro_demo.utils.ResultUtils;
//import com.example.shiro_demo.service.UserService;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
///**
// * (User)表控制层
// *
// * @author XingGao
// * @since 2022-03-24 14:31:20
// */
//@RestController
//@RequestMapping("user")
//public class UserController {
//    /**
//     * 服务对象
//     */
//    @Autowired
//    private UserService userService;
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    /**
//     * 分页查询所有数据
//     *
//     * @return 所有数据
//     */
//
//    @GetMapping
//    @RequiresPermissions("ROLE_USER")
//    public ResultData selectAll(Page<User> page, User user) {
//        return ResultUtils.ok(this.userService.page(page, new QueryWrapper<>(user)));
//    }
//
//    @GetMapping("/login")
//    public ResultData login(User user) {
//        String token = UUID.randomUUID().toString().replaceAll("-", "");
//        stringRedisTemplate.opsForValue().set(token, user.getAccount(), 3600, TimeUnit.SECONDS);
//        return ResultUtils.ok(null);
//    }
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public ResultData selectOne(@PathVariable Serializable id) {
//        return ResultUtils.ok(this.userService.getById(id));
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param user 实体对象
//     * @return 新增结果
//     */
//    @PostMapping
//    public ResultData insert(@RequestBody User user) {
//        return ResultUtils.ok(this.userService.save(user));
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param user 实体对象
//     * @return 修改结果
//     */
//    @PutMapping
//    public ResultData update(@RequestBody User user) {
//        return ResultUtils.ok(this.userService.updateById(user));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param idList 主键结合
//     * @return 删除结果
//     */
//    @DeleteMapping
//    public ResultData delete(@RequestParam("idList") List<Long> idList) {
//        return ResultUtils.ok(this.userService.removeByIds(idList));
//    }
//}
//
