package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSignletonService s1 = context.getBean(DemoSignletonService.class);
        DemoSignletonService s2 = context.getBean(DemoSignletonService.class);

        DemoPrototypeScope p1 = context.getBean(DemoPrototypeScope.class);
        DemoPrototypeScope p2 = context.getBean(DemoPrototypeScope.class);

        System.out.println("s1与s2是否相等: " + s1.equals(s2));
        System.out.println("p1与p2是否相等: " + p1.equals(p2));
        context.close();
    }
}
