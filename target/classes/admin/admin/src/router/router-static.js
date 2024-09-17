import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import tushu from '@/views/modules/tushu/list'
    import tushuCollection from '@/views/modules/tushuCollection/list'
    import tushuLiuyan from '@/views/modules/tushuLiuyan/list'
    import tushuOrder from '@/views/modules/tushuOrder/list'
    import duzhe from '@/views/modules/duzhe/list'
    import config from '@/views/modules/config/list'
    import dictionaryDuzhe from '@/views/modules/dictionaryDuzhe/list'
    import dictionaryForum from '@/views/modules/dictionaryForum/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryShujia from '@/views/modules/dictionaryShujia/list'
    import dictionaryTushu from '@/views/modules/dictionaryTushu/list'
    import dictionaryTushuCollection from '@/views/modules/dictionaryTushuCollection/list'
    import dictionaryTushuOrder from '@/views/modules/dictionaryTushuOrder/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryDuzhe',
        name: '读者类型',
        component: dictionaryDuzhe
    }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryShujia',
        name: '书架',
        component: dictionaryShujia
    }
    ,{
        path: '/dictionaryTushu',
        name: '图书类型',
        component: dictionaryTushu
    }
    ,{
        path: '/dictionaryTushuCollection',
        name: '收藏表类型',
        component: dictionaryTushuCollection
    }
    ,{
        path: '/dictionaryTushuOrder',
        name: '状态',
        component: dictionaryTushuOrder
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/tushu',
        name: '图书',
        component: tushu
      }
    ,{
        path: '/tushuCollection',
        name: '图书收藏',
        component: tushuCollection
      }
    ,{
        path: '/tushuLiuyan',
        name: '图书留言',
        component: tushuLiuyan
      }
    ,{
        path: '/tushuOrder',
        name: '图书借阅',
        component: tushuOrder
      }
    ,{
        path: '/duzhe',
        name: '读者',
        component: duzhe
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
