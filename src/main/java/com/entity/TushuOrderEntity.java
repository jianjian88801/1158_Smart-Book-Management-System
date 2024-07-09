package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 图书借阅
 *
 * @author 
 * @email
 */
@TableName("tushu_order")
public class TushuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TushuOrderEntity() {

	}

	public TushuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 借阅编号
     */
    @TableField(value = "tushu_order_uuid_number")

    private String tushuOrderUuidNumber;


    /**
     * 图书
     */
    @TableField(value = "tushu_id")

    private Integer tushuId;


    /**
     * 读者
     */
    @TableField(value = "duzhe_id")

    private Integer duzheId;


    /**
     * 借阅日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "jieyue_time")

    private Date jieyueTime;


    /**
     * 还书日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "huanshu_time")

    private Date huanshuTime;


    /**
     * 状态
     */
    @TableField(value = "tushu_order_types")

    private Integer tushuOrderTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：借阅编号
	 */
    public String getTushuOrderUuidNumber() {
        return tushuOrderUuidNumber;
    }


    /**
	 * 获取：借阅编号
	 */

    public void setTushuOrderUuidNumber(String tushuOrderUuidNumber) {
        this.tushuOrderUuidNumber = tushuOrderUuidNumber;
    }
    /**
	 * 设置：图书
	 */
    public Integer getTushuId() {
        return tushuId;
    }


    /**
	 * 获取：图书
	 */

    public void setTushuId(Integer tushuId) {
        this.tushuId = tushuId;
    }
    /**
	 * 设置：读者
	 */
    public Integer getDuzheId() {
        return duzheId;
    }


    /**
	 * 获取：读者
	 */

    public void setDuzheId(Integer duzheId) {
        this.duzheId = duzheId;
    }
    /**
	 * 设置：借阅日期
	 */
    public Date getJieyueTime() {
        return jieyueTime;
    }


    /**
	 * 获取：借阅日期
	 */

    public void setJieyueTime(Date jieyueTime) {
        this.jieyueTime = jieyueTime;
    }
    /**
	 * 设置：还书日期
	 */
    public Date getHuanshuTime() {
        return huanshuTime;
    }


    /**
	 * 获取：还书日期
	 */

    public void setHuanshuTime(Date huanshuTime) {
        this.huanshuTime = huanshuTime;
    }
    /**
	 * 设置：状态
	 */
    public Integer getTushuOrderTypes() {
        return tushuOrderTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setTushuOrderTypes(Integer tushuOrderTypes) {
        this.tushuOrderTypes = tushuOrderTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "TushuOrder{" +
            "id=" + id +
            ", tushuOrderUuidNumber=" + tushuOrderUuidNumber +
            ", tushuId=" + tushuId +
            ", duzheId=" + duzheId +
            ", jieyueTime=" + jieyueTime +
            ", huanshuTime=" + huanshuTime +
            ", tushuOrderTypes=" + tushuOrderTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
