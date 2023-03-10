# 前言
纯粹当做个人学习而做的项目，结合个人经验。运用 Android 前言技术以及「性能优化」而衍生的一个 App。
性能方面有：_**内存、电量、卡顿、网络、APK 体积、启动**_
可参考此文章：
> [https://www.yuque.com/tongsr/xy0i84/ovqq98?singleDoc#](https://www.yuque.com/tongsr/xy0i84/ovqq98?singleDoc#) 《编写一个「高质量」的 Android App》

技术栈大致如下：

- AndroidX
- 协程
- Kotlin
- **Compose**
- TheRouter
- Navigation
- OkHttp
- Retrofit2
- Paing3
- Datastore
- Coil/Glide
- ......
# API 来源
本项目所用到 API 均来自 [Wanandroid](https://www.wanandroid.com/)。API 地址：
> [https://www.wanandroid.com/blog/show/2](https://www.wanandroid.com/blog/show/2)

计划业务线有如下：

- 用户模块
- 首页
- 体系和导航归为导航
- 项目
- 公众号
- 广场
- 搜索

详细可点击 API 地址查看所有业务点
# 项目架构
路由采用 [TheRouter](https://therouter.cn/) ，项目架构学习到了 [AucFrame](https://blankj.com/2019/07/24/auc-frame-manage-gradle/#more)。
如图：
![image.png](https://cdn.nlark.com/yuque/0/2023/png/22637940/1676553139524-009d4ae6-9c26-45a6-b932-f156b7f26bfd.png#averageHue=%236e8873&clientId=u58631c3b-dd79-4&from=paste&height=335&id=ubbcb4708&name=image.png&originHeight=670&originWidth=558&originalType=binary&ratio=2&rotation=0&showTitle=false&size=73473&status=done&style=none&taskId=u588e5e9b-d9fd-4856-b052-007437dfb00&title=&width=279)
