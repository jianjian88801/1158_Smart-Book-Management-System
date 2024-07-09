package com.entity.view;

import com.entity.TushuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 图书留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("tushu_liuyan")
public class TushuLiuyanView extends TushuLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 tushu
			/**
			* 图书编号
			*/
			private String tushuUuidNumber;
			/**
			* 图书名称
			*/
			private String tushuName;
			/**
			* 图书照片
			*/
			private String tushuPhoto;
			/**
			* 书架
			*/
			private Integer shujiaTypes;
				/**
				* 书架的值
				*/
				private String shujiaValue;
			/**
			* 图书类型
			*/
			private Integer tushuTypes;
				/**
				* 图书类型的值
				*/
				private String tushuValue;
			/**
			* 图书作者
			*/
			private String tushuZuozhe;
			/**
			* 出版社
			*/
			private String tushuChubanshe;
			/**
			* 图书库存
			*/
			private Integer tushuKucunNumber;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer tushuDelete;
			/**
			* 图书介绍
			*/
			private String tushuContent;

		//级联表 duzhe
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
			* 读者类型
			*/
			private Integer duzheTypes;
				/**
				* 读者类型的值
				*/
				private String duzheValue;
			/**
			* 电子邮箱
			*/
			private String duzheEmail;

	public TushuLiuyanView() {

	}

	public TushuLiuyanView(TushuLiuyanEntity tushuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, tushuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set tushu
					/**
					* 获取： 图书编号
					*/
					public String getTushuUuidNumber() {
						return tushuUuidNumber;
					}
					/**
					* 设置： 图书编号
					*/
					public void setTushuUuidNumber(String tushuUuidNumber) {
						this.tushuUuidNumber = tushuUuidNumber;
					}
					/**
					* 获取： 图书名称
					*/
					public String getTushuName() {
						return tushuName;
					}
					/**
					* 设置： 图书名称
					*/
					public void setTushuName(String tushuName) {
						this.tushuName = tushuName;
					}
					/**
					* 获取： 图书照片
					*/
					public String getTushuPhoto() {
						return tushuPhoto;
					}
					/**
					* 设置： 图书照片
					*/
					public void setTushuPhoto(String tushuPhoto) {
						this.tushuPhoto = tushuPhoto;
					}
					/**
					* 获取： 书架
					*/
					public Integer getShujiaTypes() {
						return shujiaTypes;
					}
					/**
					* 设置： 书架
					*/
					public void setShujiaTypes(Integer shujiaTypes) {
						this.shujiaTypes = shujiaTypes;
					}


						/**
						* 获取： 书架的值
						*/
						public String getShujiaValue() {
							return shujiaValue;
						}
						/**
						* 设置： 书架的值
						*/
						public void setShujiaValue(String shujiaValue) {
							this.shujiaValue = shujiaValue;
						}
					/**
					* 获取： 图书类型
					*/
					public Integer getTushuTypes() {
						return tushuTypes;
					}
					/**
					* 设置： 图书类型
					*/
					public void setTushuTypes(Integer tushuTypes) {
						this.tushuTypes = tushuTypes;
					}


						/**
						* 获取： 图书类型的值
						*/
						public String getTushuValue() {
							return tushuValue;
						}
						/**
						* 设置： 图书类型的值
						*/
						public void setTushuValue(String tushuValue) {
							this.tushuValue = tushuValue;
						}
					/**
					* 获取： 图书作者
					*/
					public String getTushuZuozhe() {
						return tushuZuozhe;
					}
					/**
					* 设置： 图书作者
					*/
					public void setTushuZuozhe(String tushuZuozhe) {
						this.tushuZuozhe = tushuZuozhe;
					}
					/**
					* 获取： 出版社
					*/
					public String getTushuChubanshe() {
						return tushuChubanshe;
					}
					/**
					* 设置： 出版社
					*/
					public void setTushuChubanshe(String tushuChubanshe) {
						this.tushuChubanshe = tushuChubanshe;
					}
					/**
					* 获取： 图书库存
					*/
					public Integer getTushuKucunNumber() {
						return tushuKucunNumber;
					}
					/**
					* 设置： 图书库存
					*/
					public void setTushuKucunNumber(Integer tushuKucunNumber) {
						this.tushuKucunNumber = tushuKucunNumber;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getTushuDelete() {
						return tushuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setTushuDelete(Integer tushuDelete) {
						this.tushuDelete = tushuDelete;
					}
					/**
					* 获取： 图书介绍
					*/
					public String getTushuContent() {
						return tushuContent;
					}
					/**
					* 设置： 图书介绍
					*/
					public void setTushuContent(String tushuContent) {
						this.tushuContent = tushuContent;
					}













				//级联表的get和set duzhe
					/**
					* 获取： 读者编号
					*/
					public String getDuzheUuidNumber() {
						return duzheUuidNumber;
					}
					/**
					* 设置： 读者编号
					*/
					public void setDuzheUuidNumber(String duzheUuidNumber) {
						this.duzheUuidNumber = duzheUuidNumber;
					}
					/**
					* 获取： 读者姓名
					*/
					public String getDuzheName() {
						return duzheName;
					}
					/**
					* 设置： 读者姓名
					*/
					public void setDuzheName(String duzheName) {
						this.duzheName = duzheName;
					}
					/**
					* 获取： 读者手机号
					*/
					public String getDuzhePhone() {
						return duzhePhone;
					}
					/**
					* 设置： 读者手机号
					*/
					public void setDuzhePhone(String duzhePhone) {
						this.duzhePhone = duzhePhone;
					}
					/**
					* 获取： 读者身份证号
					*/
					public String getDuzheIdNumber() {
						return duzheIdNumber;
					}
					/**
					* 设置： 读者身份证号
					*/
					public void setDuzheIdNumber(String duzheIdNumber) {
						this.duzheIdNumber = duzheIdNumber;
					}
					/**
					* 获取： 读者头像
					*/
					public String getDuzhePhoto() {
						return duzhePhoto;
					}
					/**
					* 设置： 读者头像
					*/
					public void setDuzhePhoto(String duzhePhoto) {
						this.duzhePhoto = duzhePhoto;
					}
					/**
					* 获取： 读者类型
					*/
					public Integer getDuzheTypes() {
						return duzheTypes;
					}
					/**
					* 设置： 读者类型
					*/
					public void setDuzheTypes(Integer duzheTypes) {
						this.duzheTypes = duzheTypes;
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
					/**
					* 获取： 电子邮箱
					*/
					public String getDuzheEmail() {
						return duzheEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setDuzheEmail(String duzheEmail) {
						this.duzheEmail = duzheEmail;
					}



}
