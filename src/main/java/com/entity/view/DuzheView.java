package com.entity.view;

import com.entity.DuzheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 读者
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("duzhe")
public class DuzheView extends DuzheEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 读者类型的值
		*/
		private String duzheValue;



	public DuzheView() {

	}

	public DuzheView(DuzheEntity duzheEntity) {
		try {
			BeanUtils.copyProperties(this, duzheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 读者类型的值
			*/
			public String getDuzheValue() {
				return duzheValue;
			}
			/**
			* 设置： 读者类型的值
			*/
			public void setDuzheValue(String duzheValue) {
				this.duzheValue = duzheValue;
			}










}
