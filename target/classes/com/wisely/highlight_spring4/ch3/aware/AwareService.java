package com.wisely.highlight_spring4.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public ResourceLoader getLoader() {
        return loader;
    }

    @Override
    public void setResourceLoader(ResourceLoader loader) {
        this.loader = loader;
    }

    public void outputResult() {
        System.out.println("Bean的名字为：" + beanName);

        Resource resource = loader.getResource("classpath:com/wisely/highlight_spring4/ch2/el/test.txt");
        try {
            System.out.println("ResourceLoader 加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
