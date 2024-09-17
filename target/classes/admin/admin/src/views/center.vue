<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='duzhe'"  label='读者编号' prop="duzheUuidNumber">
               <el-input v-model="ruleForm.duzheUuidNumber"  placeholder='读者编号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='duzhe'"  label='读者姓名' prop="duzheName">
               <el-input v-model="ruleForm.duzheName"  placeholder='读者姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='duzhe'"  label='读者手机号' prop="duzhePhone">
               <el-input v-model="ruleForm.duzhePhone"  placeholder='读者手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='duzhe'"  label='读者身份证号' prop="duzheIdNumber">
               <el-input v-model="ruleForm.duzheIdNumber"  placeholder='读者身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='duzhe'" label='读者头像' prop="duzhePhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.duzhePhoto?ruleForm.duzhePhoto:''"
                         @change="duzhePhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='duzhe'"  label='读者类型' prop="duzheTypes">
                 <el-select v-model="ruleForm.duzheTypes" placeholder='请选择读者类型'>
                     <el-option
                             v-for="(item,index) in duzheTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='duzhe'"  label='电子邮箱' prop="duzheEmail">
               <el-input v-model="ruleForm.duzheEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="读者名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="读者名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      sexTypesOptions : [],
     duzheTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录读者的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
          this.sexTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
  });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=duzhe_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.duzheTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    duzhePhotoUploadChange(fileUrls) {
        this.ruleForm.duzhePhoto = fileUrls;
    },

    onUpdateHandler() {
                         if((!this.ruleForm.duzheUuidNumber)&& 'duzhe'==this.flag){
                             this.$message.error('读者编号不能为空');
                             return
                         }

                         if((!this.ruleForm.duzheName)&& 'duzhe'==this.flag){
                             this.$message.error('读者姓名不能为空');
                             return
                         }

                             if( 'duzhe' ==this.flag && this.ruleForm.duzhePhone&&(!isMobile(this.ruleForm.duzhePhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.duzheIdNumber)&& 'duzhe'==this.flag){
                             this.$message.error('读者身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.duzhePhoto)&& 'duzhe'==this.flag){
                             this.$message.error('读者头像不能为空');
                             return
                         }

                         if((!this.ruleForm.duzheTypes)&& 'duzhe'==this.flag){
                             this.$message.error('读者类型不能为空');
                             return
                         }

                             if( 'duzhe' ==this.flag && this.ruleForm.duzheEmail&&(!isEmail(this.ruleForm.duzheEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes)&& this.flag !='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`读者名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
