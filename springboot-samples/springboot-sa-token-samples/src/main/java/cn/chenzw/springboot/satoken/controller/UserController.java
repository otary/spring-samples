package cn.chenzw.springboot.satoken.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 1. 校验用户名和密码（这里模拟一个简单的校验）
        if ("admin".equals(username) && "123456".equals(password)) {
            // 2. 登录，保存用户ID为10001
            StpUtil.login(10001);

            // 将用户ID为10001的用户踢下线
            // StpUtil.logout(10001);

            // 判断是否登录
            boolean isLogout = StpUtil.isLogin();

            // 权限验证
            StpUtil.checkPermission("user:update");


            return "登录成功，Token：" + StpUtil.getTokenValue();
        }
        return "用户名或密码错误";
    }

    // 查询用户信息，需登录
    @GetMapping("/info")
    public String getUserInfo() {
        // 校验是否登录
        StpUtil.checkLogin();
        // 获取用户ID
        int userId = StpUtil.getLoginIdAsInt();

        // 获取当前会话的Session
        SaSession session = StpUtil.getSession();

        // 存储数据
        session.set("name", "张三");
        session.set("email", "zhangsan@example.com");

        // 获取数据
        String name = session.getString("name");
        String email = session.getString("email");


        return "当前用户信息，ID：" + userId;
    }

    // 修改用户信息，需有权限"user:update"
    @SaCheckPermission("user:update")
    @PostMapping("/update")
    public String updateUser() {
        return "用户信息更新成功";
    }

    // 仅管理员角色可访问
    @SaCheckRole("admin")
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "欢迎进入管理员控制台";
    }
}
