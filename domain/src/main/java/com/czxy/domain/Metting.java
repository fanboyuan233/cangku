package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/*
CREATE TABLE `tab_metting` (
  `metting_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `metting_name` VARCHAR(30) DEFAULT NULL COMMENT '会议名称',
  `metting_size` INT(11) DEFAULT NULL COMMENT '预计参会人数',
  `metting_starttime` DATETIME DEFAULT NULL COMMENT '会议开始时间',
  `metting_endtime` DATETIME DEFAULT NULL COMMENT '会议结束时间',
  `metting_ordertime` DATETIME DEFAULT NULL COMMENT '会议预定时间',
  `remark` VARCHAR(200) DEFAULT NULL COMMENT '会议说明',
  `status` VARCHAR(10) DEFAULT NULL COMMENT '会议状态',
  `username` VARCHAR(30) DEFAULT NULL COMMENT '预定者',
  `room_id` INT(11) DEFAULT NULL COMMENT '会议室ID',
  PRIMARY KEY (`metting_id`)
) ENGINE=INNODB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

 */
@Entity
@Table(name = "tab_metting")
public class Metting {
    @Id
    private Integer mettingId;
    private String mettingName;
    private Integer mettingSize;
    private String mettingStarttime;
    private String mettingEndtime;
    private String mettingOrdertime;
    private String remark;
    private String status;
    private String username;
    private Integer roomId;
    private Room room;
    private User user;

    public Metting() {
    }

    public Integer getMettingId() {
        return mettingId;
    }

    public void setMettingId(Integer mettingId) {
        this.mettingId = mettingId;
    }

    public String getMettingName() {
        return mettingName;
    }

    public void setMettingName(String mettingName) {
        this.mettingName = mettingName;
    }

    public Integer getMettingSize() {
        return mettingSize;
    }

    public void setMettingSize(Integer mettingSize) {
        this.mettingSize = mettingSize;
    }

    public String getMettingStarttime() {
        return mettingStarttime;
    }

    public void setMettingStarttime(String mettingStarttime) {
        this.mettingStarttime = mettingStarttime;
    }

    public String getMettingEndtime() {
        return mettingEndtime;
    }

    public void setMettingEndtime(String mettingEndtime) {
        this.mettingEndtime = mettingEndtime;
    }

    public String getMettingOrdertime() {
        return mettingOrdertime;
    }

    public void setMettingOrdertime(String mettingOrdertime) {
        this.mettingOrdertime = mettingOrdertime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Metting{" +
                "mettingId=" + mettingId +
                ", mettingName='" + mettingName + '\'' +
                ", mettingSize=" + mettingSize +
                ", mettingStarttime='" + mettingStarttime + '\'' +
                ", mettingEndtime='" + mettingEndtime + '\'' +
                ", mettingOrdertime='" + mettingOrdertime + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", roomId=" + roomId +
                ", room=" + room +
                ", user=" + user +
                '}';
    }
}
