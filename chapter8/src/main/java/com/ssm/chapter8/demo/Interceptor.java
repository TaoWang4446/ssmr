/*
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.


package com.ssm.chapter8.demo;

import java.util.Properties;

*
 * @author Clinton Begin
 * 使用插件就必须使用这个接口,
 * 这是插件的骨架,模板模式,并告知模板方法是干什么用的,由开发人员完成.


public interface Interceptor {

  *
   * 将直接覆盖拦截对象的原有方法.
   * @param invocation 可以反射调用原来对象的方法
   * @return
   * @throws Throwable
  Object intercept(Invocation invocation) throws Throwable;

*
   * 给被拦截对象生成一个代理对象,并返回他
   * Plugin中 wrap ()生成代理对象,一般情况下都会使用它生成代理对象
   * @param target 被拦截对象
   * @return


  Object plugin(Object target);

*
   * 允许在plugin元素中配置所需参数,方法在插件初始化时就被调用了一次,然后把插件对象存入到配置中,以便后面使用
   * @param properties


  void setProperties(Properties properties);

}

 */
