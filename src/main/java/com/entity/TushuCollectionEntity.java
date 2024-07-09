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
 * 图书收藏
 *
 * @author 
 * @email
 */
@TableName("tushu_collection")
public class TushuCollectionEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TushuCollectionEntity() {

	}

	public TushuCollectionEntity(T t) {
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
     * 类型
     */
    @TableField(value = "tushu_collection_types")

    private Integer tushuCollectionTypes;


    /**
     * 收藏时间
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
	 * 设置：类型
	 */
    public Integer getTushuCollectionTypes() {
        return tushuCollectionTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setTushuCollectionTypes(Integer tushuCollectionTypes) {
        this.tushuCollectionTypes = tushuCollectionTypes;
    }
    /**
	 * 设置：收藏时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：收藏时间
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
        return "TushuCollection{" +
            "id=" + id +
            ", tushuId=" + tushuId +
            ", duzheId=" + duzheId +
            ", tushuCollectionTypes=" + tushuCollectionTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
