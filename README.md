<p align="center">
	<img alt="logo" src="https://oscimg.oschina.net/oscnet/up-d3d0a9303e11d522a06cd263f3079027715.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">RuoYi v3.8.6</h1>
<h4 align="center">基于SpringBoot+Vue前后端分离的Java快速开发框架</h4>
<p align="center">
	<a href="https://gitee.com/y_project/RuoYi-Vue/stargazers"><img src="https://gitee.com/y_project/RuoYi-Vue/badge/star.svg?theme=dark"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue"><img src="https://img.shields.io/badge/RuoYi-v3.8.6-brightgreen.svg"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>

## 技术栈
* Vue + ElementPlus + Echarts
* Spring Boot + MyBatisPlus + Spring Security + Redis

## 内置功能
1.  首页：首页展示页，一些数据统计
2.  时光轴：动态展示
3.  留言板：访客可以留言
4.  作品集：作品集展示
5.  数据管理：对时光轴的动态的增删查、留言板的审核、作品集的增删改查

## 在线体验
演示地址：http://www.qmeternity/index

## 部署提示(前后端)

### 修改配置
1. 前端修改`vite.config.js`文件中的`server.proxy.'/dev-api'.target`为后端程序ip+port
2. 后端修改`application-druid.yml`中`spring.datasource.druid.master.url`为同服务器的mysql的docker别名
3. 后端修改`application.yml`中`spring.redis.host`为同服务器的redis的docker别名
4. 后端修改`application.yml`中`ruoyi.profile`为后台部署的docker的ruoyi自带文件保存路径

### 打包
1. 前端执行`yarn build:prod`
2. 后端用`maven package`

### 部署
1. 将前端dist放入对应位置
2. 将后端jar放入对应位置
3. 重启docker容器
