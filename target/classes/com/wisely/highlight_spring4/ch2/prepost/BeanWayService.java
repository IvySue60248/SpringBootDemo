package com.wisely.highlight_spring4.ch2.prepost;

/**
 * init方法在构造函数之后执行
 * destroy方法在销毁之前执行
 */
public class BeanWayService {
    public void init() {
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        super();
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destroy() {
        System.out.println("@Bean-destroy-method");
    }
}
