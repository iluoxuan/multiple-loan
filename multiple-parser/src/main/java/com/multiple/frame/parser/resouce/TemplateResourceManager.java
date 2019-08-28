package com.multiple.frame.parser.resouce;

import com.multiple.frame.common.exception.ChannelException;
import com.multiple.frame.parser.config.ParserProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Getter
@Setter
public class TemplateResourceManager implements ResourceManager{

    private ParserProperties parserProperties;

    private ResourceCache resourceCache;

    private List<ResourceLoader> resourceLoaderList;

    /**
     * 获取资源
     *
     * @param resourcePath
     * @param type
     * @return
     */
    @Override
    public TemplateResource getResource(String resourcePath, String type) {

        TemplateResource resource = null;
        if (parserProperties.isCacheStart()) {
            resource = resourceCache.get(getCacheKey(resourcePath, type));
        }

        if (Objects.nonNull(resource)) {
            return resource;
        }

        Optional<TemplateResource> optional = resourceLoaderList.stream()
                .filter(resourceLoader -> resourceLoader.type().equals(type))
                .map(resourceLoader -> {
                    try {
                        return resourceLoader.read(resourcePath);
                    } catch (Exception e) {
                        throw new ChannelException("resource loader error");
                    }
                }).findFirst();

        Assert.isTrue(optional.isPresent(), "no find template resource");

        resourceCache.put(getCacheKey(resourcePath, type), optional.get());

        return optional.get();
    }

    private String getCacheKey(String resourcePath, String type) {
        return type + ":" + resourcePath;
    }

}
