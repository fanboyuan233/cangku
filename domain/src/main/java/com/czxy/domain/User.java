package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/*
CREATE TABLE `tab_user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) DEFAULT NULL,
  `password` VARCHAR(32) DEFAULT NULL,
  `phone` VARCHAR(15) DEFAULT NULL,
  `email` VARCHAR(30) DEFAULT NULL,
  `dept_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

 */

@Entity
@Table(name = "tab_user")
public class User {
    @Id
    private Integer userId;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer deptId;
    private List<Metting>mettings;

    public List<Metting> getMettings() {
        return mettings;
    }

    public void setMettings(List<Metting> mettings) {
        this.mettings = mettings;
    }

    public User(Integer userId, String username, String password, String phone, String email, Integer deptId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.deptId = deptId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
