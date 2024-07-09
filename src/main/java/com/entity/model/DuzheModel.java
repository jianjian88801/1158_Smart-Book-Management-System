package com.entity.model;

import com.entity.DuzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 读者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DuzheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 读者编号
     */
    private String duzheUuidNumber;


    /**
     * 读者姓名
     */
    private String duzheName;


    /**
     * 读者手机号
     */
    private String duzhePhone;


    /**
     * 读者身份证号
     */
    private String duzheIdNumber;


    /**
     * 读者头像
     */
    private String duzhePhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 读者类型
     */
    private Integer duzheTypes;


    /**
     * 电子邮箱
     */
    private String duzheEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：读者编号
	 */
    public String getDuzheUuidNumber() {
        return duzheUuidNumber;
    }


    /**
	 * 设置：读者编号
	 */
    public void setDuzheUuidNumber(String duzheUuidNumber) {
        this.duzheUuidNumber = duzheUuidNumber;
    }
    /**
	 * 获取：读者姓名
	 */
    public String getDuzheName() {
        return duzheName;
    }


    /**
	 * 设置：读者姓名
	 */
    public void setDuzheName(String duzheName) {
        this.duzheName = duzheName;
    }
    /**
	 * 获取：读者手机号
	 */
    public String getDuzhePhone() {
        return duzhePhone;
    }


    /**
	 * 设置：读者手机号
	 */
    public void setDuzhePhone(String duzhePhone) {
        this.duzhePhone = duzhePhone;
    }
    /**
	 * 获取：读者身份证号
	 */
    public String getDuzheIdNumber() {
        return duzheIdNumber;
    }


    /**
	 * 设置：读者身份证号
	 */
    public void setDuzheIdNumber(String duzheIdNumber) {
        this.duzheIdNumber = duzheIdNumber;
    }
    /**
	 * 获取：读者头像
	 */
    public String getDuzhePhoto() {
        return duzhePhoto;
    }


    /**
	 * 设置：读者头像
	 */
    public void setDuzhePhoto(String duzhePhoto) {
        this.duzhePhoto = duzhePhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：读者类型
	 */
    public Integer getDuzheTypes() {
        return duzheTypes;
    }


    /**
	 * 设置：读者类型
	 */
    public void setDuzheTypes(Integer duzheTypes) {
        this.duzheTypes = duzheTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getDuzheEmail() {
        return duzheEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setDuzheEmail(String duzheEmail) {
        this.duzheEmail = duzheEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
