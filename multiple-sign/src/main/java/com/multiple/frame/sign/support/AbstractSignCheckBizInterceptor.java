package com.multiple.frame.sign.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.multiple.frame.common.base.BaseRequest;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ExecuteInfo;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.sign.annotation.SignCheck;
import com.multiple.frame.sign.config.SignProperties;
import com.multiple.frame.sign.rule.SignRuleParam;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Map;
import java.util.Objects;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Slf4j
@Setter
public abstract class AbstractSignCheckBizInterceptor implements GlobalInterceptor {

    @Autowired(required = false)
    protected SignManager signManager;

    @Autowired(required = false)
    protected SignProperties signProperties;

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {

        BaseRequest baseRequest = exchange.getBaseRequest();
        if (!isNeedCheckSign(exchange.getExecuteInfo())) {
            return true;
        }

        SignContext signContext = new SignContext();
        signContext.setSign(baseRequest.getSign());
        signContext.setSignConfig(createSignConfig(exchange, signProperties));
        SignRuleParam signRuleParam = new SignRuleParam();
        signRuleParam.setAppId(baseRequest.getAppId());
        signRuleParam.setDataContent(baseRequest.getData());
        signRuleParam.setDataMap(JSON.parseObject(exchange.getChannelParam().getRequestBody(), Map.class, Feature.OrderedField));
        signContext.setSignRuleParam(signRuleParam);

        return signManager.verifySign(signContext);

    }

    /**
     * 生成 签名配置
     *
     * @param exchange
     * @param signProperties
     * @return
     */
    protected abstract SignConfig createSignConfig(ChannelExchange exchange, SignProperties signProperties);

    private boolean isNeedCheckSign(ExecuteInfo executeInfo) {

        // 在启动之进入 请求之前 验证签名
        SignCheck signCheck = AnnotationUtils.findAnnotation(executeInfo.getMethod(), SignCheck.class);

        // 先判断
        if (signProperties.isSkipCheck()) {
            log.info("[isNeedCheckSign] is open skip check sign");
            return false;
        }

        boolean isNeed = Objects.isNull(signCheck) || signCheck.value();
        return isNeed;
    }
}
