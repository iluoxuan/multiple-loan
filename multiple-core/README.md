# 多扩展接入项目



### 请求如何找到一个实现类

![寻址](../doc/images/find.png)

### endpoint 端点 

* actuator/multiple-frame
* 可以看到寻址格式 channel-unitBiz-method [业务线-业务单元-执行方法]


```json

{
    "executes": {
        "default-default-unit": "{\"channel\":\"default\",\"unitBiz\":\"[default]\",\"method\":\"unit\",\"bean\":\"class com.multiple.frame.gw.biz.unit.DefaultPayBizUnit\"}",
        "dc-default-userCheck": "{\"channel\":\"dc\",\"unitBiz\":\"[default]\",\"method\":\"userCheck\",\"bean\":\"class com.multiple.frame.gw.biz.dc.DcApplyBiz\"}",
        "default-second-userCheck": "{\"channel\":\"default\",\"unitBiz\":\"[second]\",\"method\":\"userCheck\",\"bean\":\"class com.multiple.frame.gw.biz.unit.SecondApplyBizUnit\"}",
        "default-default-userCheck": "{\"channel\":\"default\",\"unitBiz\":\"[default]\",\"method\":\"userCheck\",\"bean\":\"class com.multiple.frame.gw.biz.unit.DefaultApplyBizUnit\"}",
        "default-default-getRepaymentUrl": "{\"channel\":\"default\",\"unitBiz\":\"[default]\",\"method\":\"getRepaymentUrl\",\"bean\":\"class com.multiple.frame.gw.biz.unit.DefaultPayBizUnit\"}"
    },
    "interceptors": {
        "global-InvokerMethodBizInterceptor": "{\"order\":\"100\", \"bean\":\"com.multiple.frame.core.interceptor.InvokerMethodBizInterceptor@4eb51408\"}",
        "global-SignCheckBizInterceptor": "{\"order\":\"-950\", \"bean\":\"com.multiple.frame.gw.support.SignCheckBizInterceptor@60f354c6\"}",
        "global-LookExecuteBizInterceptor": "{\"order\":\"-1000\", \"bean\":\"com.multiple.frame.core.interceptor.LookExecuteBizInterceptor@3ce3d95f\"}",
        "testFrame": "{\"order\":\"-2147483648\", \"bean\":\"com.multiple.frame.gw.support.TestFrameInterceptor@69d5db8a\"}",
        "global-RequestResolverBizInterceptor": "{\"order\":\"-900\", \"bean\":\"com.multiple.frame.core.interceptor.RequestResolverBizInterceptor@46ccef61\"}",
        "global-RequestCommonParserInterceptor": "{\"order\":\"null\", \"bean\":\"com.multiple.frame.parser.interceptor.RequestCommonParserInterceptor@677124d5\"}",
        "global-ReturnValueBizInterceptor": "{\"order\":\"200\", \"bean\":\"com.multiple.frame.core.interceptor.ReturnValueBizInterceptor@18265b9\"}"
    }
}

```

* 例子

```java

@FrameBiz(channel = "dc")
@Component
public class DcApplyBiz implements ApplyBiz {

    @Override
    public String userCheck() {
        return "test in dc";
    }
}


```

