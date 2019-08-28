package com.multiple.frame.parser.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Component
public class ClasspathResourceLoader implements ResourceLoader {


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String type() {
        return ResourceType.classpath;
    }

    @Override
    public TemplateResource read(String resourcePath) throws Exception {

        Resource resource = applicationContext.getResource(
                ResourceUtils.CLASSPATH_URL_PREFIX + resourcePath);

        String data = FileCopyUtils.copyToString(new EncodedResource(resource, StandardCharsets.UTF_8).getReader());
        return TemplateResource.builder().data(data).build();

    }
}
