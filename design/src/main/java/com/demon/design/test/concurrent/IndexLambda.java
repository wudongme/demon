package com.demon.design.test.concurrent;
 
/**
 * lambda 使用：
 * 语法使用规则： （参数列表） -> {表达式}
 *
 *
 * lambda定义规则：
 * @FunctionalInterface
 * interface 接口名称 {
 *     void say();// 接口为实现的类，有且只能写一个为实现的方法
 * }
 */
@FunctionalInterface
public interface IndexLambda {
    void exec();
}