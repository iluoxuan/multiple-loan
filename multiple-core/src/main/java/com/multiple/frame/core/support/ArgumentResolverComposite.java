package com.multiple.frame.core.support;

import com.multiple.frame.common.support.ArgumentResolver;
import com.multiple.frame.common.base.ChannelExchange;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Optional;

/**
 * 组合
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public class ArgumentResolverComposite implements ArgumentResolver {

    private List<ArgumentResolver> argumentResolverList = Lists.newArrayList();

    @Override
    public boolean supportsParameter(ChannelExchange exchange) {
        return getArgumentResolver(exchange).isPresent();
    }

    @Override
    public void resolveArgument(ChannelExchange exchange) {

        Optional<ArgumentResolver> optional = getArgumentResolver(exchange);
        if (!optional.isPresent()) {
            return;
        }

        optional.get().resolveArgument(exchange);
    }

    private Optional<ArgumentResolver> getArgumentResolver(ChannelExchange exchange) {

        return argumentResolverList.stream()
                .filter(argumentResolver -> argumentResolver.supportsParameter(exchange))
                .findFirst();
    }

    public void addArgumentResolver(List<ArgumentResolver> argumentResolvers) {

        argumentResolverList.addAll(argumentResolvers);
    }
}
