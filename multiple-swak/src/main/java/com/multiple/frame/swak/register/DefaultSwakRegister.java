package com.multiple.frame.swak.register;

import com.google.common.collect.Maps;
import com.multiple.frame.swak.annotation.SwakInterface;
import com.multiple.frame.swak.entity.InterfaceExecuteInfo;
import com.multiple.frame.swak.entity.MethodExecuteInfo;
import com.multiple.frame.swak.entity.SwakContext;
import com.multiple.frame.swak.utils.ClassUtils;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Optional;

/**
 * 要支持两种 调用方式
 * 1. 接口直接调用
 * <p>
 * 2. 通过方法名称调用
 *
 * @author: junqing.li
 * @date: 2019/9/4
 */
public class DefaultSwakRegister implements SwakRegister {

    private final static String DEFAULT_FORMAT = "%s-%s-%s";

    /**
     * 缓存接口调用
     * channel-tag-interface
     */
    private final static Map<String, InterfaceExecuteInfo> interfaceExecuteMap = Maps.newHashMap();

    /**
     * 缓存更多的信息
     * <p>
     * channel-tag-method [按方法名称调用]
     */
    private final static Map<String, MethodExecuteInfo> extInfoCache = Maps.newHashMap();


    @Override
    public void register(InterfaceExecuteInfo executeInfo) {

        Optional<Class<?>> optional = ClassUtils.getInterfaceClassByAnnotation(
                executeInfo.getTarget().getClass(), SwakInterface.class);
        if (!optional.isPresent()) {
            return;
        }

        String interfaceName = ClassUtils.getQualifiedName(optional.get());
        String key = String.format(DEFAULT_FORMAT, interfaceName, executeInfo.getBizCode(), executeInfo.getTags().get(0));

        interfaceExecuteMap.put(key, executeInfo);
    }

    @Override
    public void register(MethodExecuteInfo executeInfo) {


    }

    @Override
    public InterfaceExecuteInfo lookUp(InterfaceExecuteInfo selectInfo) {

        Optional<Class<?>> optional = ClassUtils.getInterfaceClassByAnnotation(
                selectInfo.getTarget().getClass(), SwakInterface.class);
        Assert.isTrue(optional.isPresent(), "no find @SwakInterface class");

        String interfaceName = ClassUtils.getQualifiedName(optional.get());
        String key = String.format(DEFAULT_FORMAT, interfaceName, selectInfo.getBizCode(), selectInfo.getTags().get(0));

        return interfaceExecuteMap.get(key);
    }

    @Override
    public MethodExecuteInfo lookMethod(SwakContext swakContext) {
        return null;
    }

    @Override
    public void clear() {

        interfaceExecuteMap.clear();

    }
}
