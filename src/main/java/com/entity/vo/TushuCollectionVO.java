package com.entity.vo;

import com.entity.TushuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 图书收藏
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tushu_collection")
public class TushuCollectionVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 photoShow
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
	 * 设置：创建时间 show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
