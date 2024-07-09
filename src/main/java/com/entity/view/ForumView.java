package com.entity.view;

import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 论坛
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 帖子类型的值
		*/
		private String forumValue;
		/**
		* 帖子状态的值
		*/
		private String forumStateValue;



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

		//级联表 users
			/**
			* 读者名
			*/
			private String uusername;
			/**
			* 密码
			*/
			private String upassword;
			/**
			* 角色
			*/
			private String urole;
			/**
			* 新增时间
			*/
			private Date uaddtime;

	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 帖子类型的值
			*/
			public String getForumValue() {
				return forumValue;
			}
			/**
			* 设置： 帖子类型的值
			*/
			public void setForumValue(String forumValue) {
				this.forumValue = forumValue;
			}
			/**
			* 获取： 帖子状态的值
			*/
			public String getForumStateValue() {
				return forumStateValue;
			}
			/**
			* 设置： 帖子状态的值
			*/
			public void setForumStateValue(String forumStateValue) {
				this.forumStateValue = forumStateValue;
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




			//级联表的get和set users
					/**
					* 获取： 读者名
					*/
					public String getUusername() {
						return uusername;
					}
					/**
					* 设置： 读者名
					*/
					public void setUusername(String uusername) {
						this.uusername = uusername;
					}
					/**
					* 获取： 密码
					*/
					public String getUpassword() {
						return upassword;
					}
					/**
					* 设置： 密码
					*/
					public void setUpassword(String upassword) {
						this.upassword = upassword;
					}
					/**
					* 获取： 角色
					*/
					public String getUrole() {
						return urole;
					}
					/**
					* 设置： 角色
					*/
					public void setUrole(String urole) {
						this.urole = urole;
					}
					/**
					* 获取： 新增时间
					*/
					public Date getUaddtime() {
						return uaddtime;
					}
					/**
					* 设置： 新增时间
					*/
					public void setUaddtime(Date uaddtime) {
						this.uaddtime = uaddtime;
					}
}
