/**
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
 */
package com.ssm.chapter8.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Clinton Begin
 */
public class InterceptorChain {

  private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

  public Object pluginAll(Object target) {
    for (Interceptor interceptor : interceptors) {
      target = interceptor.plugin(target);//生成代理对象的方法,它是从Configuration对象中取出插件的,
      /*从第一个对象开始,将对象传递给plugin方法,然后返回一个代理.如果存在第二个插件,那么就拿到第一个代理对象给
              plugin方法,再返回一个代理对象,依次类推,有多少个拦截器就返回多个个代理对象.每一个插件都可以拦截到真实的对象
                      每一个插件都可以一层层处理被拦截的对象.
        Plugin类实现了InvocationHandler接口,采用jdk动态代理,用来生成代理对象.

                      */
    }
    return target;
  }

  public void addInterceptor(Interceptor interceptor) {
    interceptors.add(interceptor);
  }
  
  public List<Interceptor> getInterceptors() {
    return Collections.unmodifiableList(interceptors);
  }

}
