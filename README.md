# 多扩展接入项目

### 查看core的文档
* ![core文档](/multiple-core/README.md)


## 设计目的
* 可以处理多供应商，商户，渠道，产品线，第三方接入 的可扩展性
* 可插拔式，业务可以配置化
* 


## 业务架构设计

* 核心可扩展化
* 业务逻辑自动化/配置化
* 





## 设计点 [问题点]
* 目前的拦截器都是全局拦截器【不能针对身份做不对的拦截】
* 参考spring cloud gateway 做【某个身份的】局部拦截器 [fix]
* GlobalInterceptor 全局拦截器 --- 

## 要支持内部服务调用 [fix]
* 支持http
* 支持rpc
* 等

## 逻辑处理查找【支持自定义注解】[fix]

* @BizUnit()


## 多接入实现框架 
* https://yq.aliyun.com/live/1003     闲鱼SWAK
* https://mp.weixin.qq.com/s/iS7QjI-LSOET4cmRGo_Jow?utm_medium=hao.caibaojian.com&utm_source=hao.caibaojian.com



## 扩展设计思路

* 先初始化注入 
* 

## 寻找实现类逻辑

* 初始化的时候先注册所有 @FrameBiz ，或者 实现channelInfo , unitBiz的接口

* 查找的时候 先找channel下的default 或者unit 【无】

* 找默认 实现default下的 unit



