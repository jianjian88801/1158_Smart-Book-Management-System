package com.entity.vo;

import com.entity.DuzheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 读者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("duzhe")
public class DuzheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 读者编号
     */

    @TableField(value = "duzhe_uuid_number")
    private String duzheUuidNumber;


    /**
     * 读者姓名
     */

    @TableField(value = "duzhe_name")
    private String duzheName;


    /**
     * 读者手机号
     */

    @TableField(value = "duzhe_phone")
    private String duzhePhone;


    /**
     * 读者身份证号
     */

    @TableField(value = "duzhe_id_number")
    private String duzheIdNumber;


    /**
     * 读者头像
     */

    @TableField(value = "duzhe_photo")
    private String duzhePhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 读者类型
     */

    @TableField(value = "duzhe_types")
    private Integer duzheTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "duzhe_email")
    private String duzheEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：读者编号
	 */
    public String getDuzheUuidNumber() {
        return duzheUuidNumber;
    }


    /**
	 * 获取：读者编号
	 */

    public void setDuzheUuidNumber(String duzheUuidNumber) {
        this.duzheUuidNumber = duzheUuidNumber;
    }
    /**
	 * 设置：读者姓名
	 */
    public String getDuzheName() {
        return duzheName;
    }


    /**
	 * 获取：读者姓名
	 */

    public void setDuzheName(String duzheName) {
        this.duzheName = duzheName;
    }
    /**
	 * 设置：读者手机号
	 */
    public String getDuzhePhone() {
        return duzhePhone;
    }


    /**
	 * 获取：读者手机号
	 */

    public void setDuzhePhone(String duzhePhone) {
        this.duzhePhone = duzhePhone;
    }
    /**
	 * 设置：读者身份证号
	 */
    public String getDuzheIdNumber() {
        return duzheIdNumber;
    }


    /**
	 * 获取：读者身份证号
	 */

    public void setDuzheIdNumber(String duzheIdNumber) {
        this.duzheIdNumber = duzheIdNumber;
    }
    /**
	 * 设置：读者头像
	 */
    public String getDuzhePhoto() {
        return duzhePhoto;
    }


    /**
	 * 获取：读者头像
	 */

    public void setDuzhePhoto(String duzhePhoto) {
        this.duzhePhoto = duzhePhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：读者类型
	 */
    public Integer getDuzheTypes() {
        return duzheTypes;
    }


    /**
	 * 获取：读者类型
	 */

    public void setDuzheTypes(Integer duzheTypes) {
        this.duzheTypes = duzheTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getDuzheEmail() {
        return duzheEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setDuzheEmail(String duzheEmail) {
        this.duzheEmail = duzheEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
