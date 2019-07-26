package com.czxy.controller;

import com.czxy.domain.Metting;
import com.czxy.domain.User;
import com.czxy.service.MettingService;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MettingService mettingService;

    @GetMapping("/login")
    public ResponseEntity<String> login(User user, HttpServletRequest request){
        System.out.println("user="+user);
        try {
            List<User> list = userService.login(user);
            if (list.isEmpty()){
                return new ResponseEntity<>("用户名或密码错误", HttpStatus.OK);
            }else{
                User user1 = list.get(0);
                request.getSession().setAttribute("loginU",user1);
                return new ResponseEntity<>("登陆成功",HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/showLoginName")
    public ResponseEntity<User> showLoginName(HttpServletRequest request){
        try {
            User loginU = (User) request.getSession().getAttribute("loginU");
            return new ResponseEntity<>(loginU,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findMetting")
    public ResponseEntity<User> findMetting(HttpServletRequest request){
        User loginU = (User) request.getSession().getAttribute("loginU");
        User user = userService.findUserByUsername(loginU.getUsername());
        user.setMettings(mettingService.findMetByUsername(loginU.getUsername()));
//        System.out.println(user.getMettings());
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
