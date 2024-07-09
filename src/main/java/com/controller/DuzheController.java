
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 读者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/duzhe")
public class DuzheController {
    private static final Logger logger = LoggerFactory.getLogger(DuzheController.class);

    @Autowired
    private DuzheService duzheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("读者".equals(role))
            params.put("duzheId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = duzheService.queryPage(params);

        //字典表数据转换
        List<DuzheView> list =(List<DuzheView>)page.getList();
        for(DuzheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DuzheEntity duzhe = duzheService.selectById(id);
        if(duzhe !=null){
            //entity转view
            DuzheView view = new DuzheView();
            BeanUtils.copyProperties( duzhe , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DuzheEntity duzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,duzhe:{}",this.getClass().getName(),duzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DuzheEntity> queryWrapper = new EntityWrapper<DuzheEntity>()
            .eq("username", duzhe.getUsername())
            .or()
            .eq("duzhe_phone", duzhe.getDuzhePhone())
            .or()
            .eq("duzhe_id_number", duzhe.getDuzheIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DuzheEntity duzheEntity = duzheService.selectOne(queryWrapper);
        if(duzheEntity==null){
            duzhe.setCreateTime(new Date());
            duzhe.setPassword("123456");
            duzheService.insert(duzhe);
            return R.ok();
        }else {
            return R.error(511,"账户或者读者手机号或者读者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DuzheEntity duzhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,duzhe:{}",this.getClass().getName(),duzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<DuzheEntity> queryWrapper = new EntityWrapper<DuzheEntity>()
            .notIn("id",duzhe.getId())
            .andNew()
            .eq("username", duzhe.getUsername())
            .or()
            .eq("duzhe_phone", duzhe.getDuzhePhone())
            .or()
            .eq("duzhe_id_number", duzhe.getDuzheIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DuzheEntity duzheEntity = duzheService.selectOne(queryWrapper);
        if("".equals(duzhe.getDuzhePhoto()) || "null".equals(duzhe.getDuzhePhoto())){
                duzhe.setDuzhePhoto(null);
        }
        if(duzheEntity==null){
            duzheService.updateById(duzhe);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者读者手机号或者读者身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        duzheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<DuzheEntity> duzheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DuzheEntity duzheEntity = new DuzheEntity();
//                            duzheEntity.setUsername(data.get(0));                    //账户 要改的
//                            //duzheEntity.setPassword("123456");//密码
//                            duzheEntity.setDuzheUuidNumber(data.get(0));                    //读者编号 要改的
//                            duzheEntity.setDuzheName(data.get(0));                    //读者姓名 要改的
//                            duzheEntity.setDuzhePhone(data.get(0));                    //读者手机号 要改的
//                            duzheEntity.setDuzheIdNumber(data.get(0));                    //读者身份证号 要改的
//                            duzheEntity.setDuzhePhoto("");//照片
//                            duzheEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            duzheEntity.setDuzheTypes(Integer.valueOf(data.get(0)));   //读者类型 要改的
//                            duzheEntity.setDuzheEmail(data.get(0));                    //电子邮箱 要改的
//                            duzheEntity.setCreateTime(date);//时间
                            duzheList.add(duzheEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //读者编号
                                if(seachFields.containsKey("duzheUuidNumber")){
                                    List<String> duzheUuidNumber = seachFields.get("duzheUuidNumber");
                                    duzheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> duzheUuidNumber = new ArrayList<>();
                                    duzheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("duzheUuidNumber",duzheUuidNumber);
                                }
                                //读者手机号
                                if(seachFields.containsKey("duzhePhone")){
                                    List<String> duzhePhone = seachFields.get("duzhePhone");
                                    duzhePhone.add(data.get(0));//要改的
                                }else{
                                    List<String> duzhePhone = new ArrayList<>();
                                    duzhePhone.add(data.get(0));//要改的
                                    seachFields.put("duzhePhone",duzhePhone);
                                }
                                //读者身份证号
                                if(seachFields.containsKey("duzheIdNumber")){
                                    List<String> duzheIdNumber = seachFields.get("duzheIdNumber");
                                    duzheIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> duzheIdNumber = new ArrayList<>();
                                    duzheIdNumber.add(data.get(0));//要改的
                                    seachFields.put("duzheIdNumber",duzheIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<DuzheEntity> duzheEntities_username = duzheService.selectList(new EntityWrapper<DuzheEntity>().in("username", seachFields.get("username")));
                        if(duzheEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DuzheEntity s:duzheEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //读者编号
                        List<DuzheEntity> duzheEntities_duzheUuidNumber = duzheService.selectList(new EntityWrapper<DuzheEntity>().in("duzhe_uuid_number", seachFields.get("duzheUuidNumber")));
                        if(duzheEntities_duzheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DuzheEntity s:duzheEntities_duzheUuidNumber){
                                repeatFields.add(s.getDuzheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [读者编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //读者手机号
                        List<DuzheEntity> duzheEntities_duzhePhone = duzheService.selectList(new EntityWrapper<DuzheEntity>().in("duzhe_phone", seachFields.get("duzhePhone")));
                        if(duzheEntities_duzhePhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DuzheEntity s:duzheEntities_duzhePhone){
                                repeatFields.add(s.getDuzhePhone());
                            }
                            return R.error(511,"数据库的该表中的 [读者手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //读者身份证号
                        List<DuzheEntity> duzheEntities_duzheIdNumber = duzheService.selectList(new EntityWrapper<DuzheEntity>().in("duzhe_id_number", seachFields.get("duzheIdNumber")));
                        if(duzheEntities_duzheIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DuzheEntity s:duzheEntities_duzheIdNumber){
                                repeatFields.add(s.getDuzheIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [读者身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        duzheService.insertBatch(duzheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        DuzheEntity duzhe = duzheService.selectOne(new EntityWrapper<DuzheEntity>().eq("username", username));
        if(duzhe==null || !duzhe.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(duzhe.getId(),username, "duzhe", "读者");
        R r = R.ok();
        r.put("token", token);
        r.put("role","读者");
        r.put("username",duzhe.getDuzheName());
        r.put("tableName","duzhe");
        r.put("userId",duzhe.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody DuzheEntity duzhe){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<DuzheEntity> queryWrapper = new EntityWrapper<DuzheEntity>()
            .eq("username", duzhe.getUsername())
            .or()
            .eq("duzhe_phone", duzhe.getDuzhePhone())
            .or()
            .eq("duzhe_id_number", duzhe.getDuzheIdNumber())
            ;
        DuzheEntity duzheEntity = duzheService.selectOne(queryWrapper);
        if(duzheEntity != null)
            return R.error("账户或者读者手机号或者读者身份证号已经被使用");
        duzhe.setCreateTime(new Date());
        duzheService.insert(duzhe);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        DuzheEntity duzhe = new DuzheEntity();
        duzhe.setPassword("123456");
        duzhe.setId(id);
        duzheService.updateById(duzhe);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        DuzheEntity duzhe = duzheService.selectOne(new EntityWrapper<DuzheEntity>().eq("username", username));
        if(duzhe!=null){
            duzhe.setPassword("123456");
            boolean b = duzheService.updateById(duzhe);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取读者的session读者信息
    */
    @RequestMapping("/session")
    public R getCurrDuzhe(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        DuzheEntity duzhe = duzheService.selectById(id);
        if(duzhe !=null){
            //entity转view
            DuzheView view = new DuzheView();
            BeanUtils.copyProperties( duzhe , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = duzheService.queryPage(params);

        //字典表数据转换
        List<DuzheView> list =(List<DuzheView>)page.getList();
        for(DuzheView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DuzheEntity duzhe = duzheService.selectById(id);
            if(duzhe !=null){


                //entity转view
                DuzheView view = new DuzheView();
                BeanUtils.copyProperties( duzhe , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DuzheEntity duzhe, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,duzhe:{}",this.getClass().getName(),duzhe.toString());
        Wrapper<DuzheEntity> queryWrapper = new EntityWrapper<DuzheEntity>()
            .eq("username", duzhe.getUsername())
            .or()
            .eq("duzhe_phone", duzhe.getDuzhePhone())
            .or()
            .eq("duzhe_id_number", duzhe.getDuzheIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DuzheEntity duzheEntity = duzheService.selectOne(queryWrapper);
        if(duzheEntity==null){
            duzhe.setCreateTime(new Date());
        duzhe.setPassword("123456");
        duzheService.insert(duzhe);
            return R.ok();
        }else {
            return R.error(511,"账户或者读者手机号或者读者身份证号已经被使用");
        }
    }


}
