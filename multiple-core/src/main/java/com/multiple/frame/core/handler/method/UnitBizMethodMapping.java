package com.multiple.frame.core.handler.method;

import com.multiple.frame.common.base.*;
import com.multiple.frame.common.utils.ReflectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

/**
 * 默认逻辑单元 寻找逻辑
 * <p>
 * 1. 开始uri没有找到
 * 2. 虚招默认的，如果有默认的实现 --> 执行默认的实现
 * 3. 如果没有默认的实现 --> 找到对应的 逻辑单元执行
 *
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Order(1000)
@Component
public class UnitBizMethodMapping extends AbstractMethodMapping {

    @Override
    public boolean support(ChannelExchange exchange) {
        ExecuteInfo executeInfo = exchange.getExecuteInfo();
        return ExecuteInfo.isNull(executeInfo);
    }

    @Override
    protected void look0(ChannelExchange exchange) {

        // 逻辑单元
        String unitBiz = exchange.getBizFunctionConfig().getBizUnit();
        unitBiz = StringUtils.isBlank(unitBiz) ? BizUnit.defaultUnit : unitBiz;

        // 找到对应的逻辑执行单元
        ChannelInfo channelInfo = getExecuteUnit(unitBiz);
        Method method = ReflectUtils.getDeclaredMethod(channelInfo, exchange.getChannelParam().getBizMethod());
        exchange.setExecuteInfo(new ExecuteInfo(method, channelInfo));

    }

    /**
     * 找到对应的处理器 没有找到抛出异常
     */
    private BizUnit getExecuteUnit(String unitBizStr) {

        Map<String, ? extends BizUnit> beans = applicationContext.getBeansOfType(BizUnit.class);

        // 先过滤再map
        Optional<BizUnit> currentBean = beans.entrySet().stream().filter(entry -> {

            BizUnit bizUnit = entry.getValue();

            return unitBizStr.equals(bizUnit.unit());

        }).map(entry -> (BizUnit) entry.getValue()).findFirst();

        return currentBean.orElse(null);

    }


}
