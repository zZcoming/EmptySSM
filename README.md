tips: 启动项目后，welcome-file的链接即为测试用例

1. 部署maven web项目
   * [Eclipse使用Maven构建web项目详解](http://www.devnote.cn/article/148.html)
   * pom.xml添加webapp依赖：
    ```
    <dependency>
    	<groupId>javax.servlet</groupId>
    	<artifactId>javax.servlet-api</artifactId>
    	<version>3.1.0</version>
    	<scope>provided</scope>
    </dependency>
    <dependency>
    	<groupId>javax.servlet</groupId>
    	<artifactId>jsp-api</artifactId>
    	<version>2.0</version>
    	<scope>provided</scope>
    </dependency>
    <dependency>
    	<groupId>javax.servlet</groupId>
    	<artifactId>jstl</artifactId>
    	<version>1.2</version>
    	<scope>provided</scope>
    </dependency>
    ```
   * 配置jdk版本，在build->plugins节点中添加：
   ```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
            <source>1.7</source>
            <target>1.7</target>
        </configuration>
    </plugin>
   ```
2. 整合spring
3. 整合log4j
4. 配置dataSource
   * [Spring整合阿里巴巴开源数据源Druid](http://www.html580.com/9880)
   ```
    <!-- druid -->
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>druid</artifactId>
		<version>1.0.7</version>
	</dependency>
   ```
   * [编程方式取得Spring上下文的Properties](http://blog.csdn.net/tornadowp/article/details/8049548)
   * driverClassName=com.mysql.jdbc.Driver
   * url=jdbc:mysql://localhost:3306/ssm?useUnicode=true&amp;characterEncoding=utf-8
5. 整合mybatis
   * [mybatis-spring官方文档 - SqlSessionFactoryBean](http://www.mybatis.org/spring/zh/factorybean.html)
   > 在此，应完成的有：
   > 1. 事务管理
   > 2. 扫描mapper包
6. 整合mybatis-generator
   * [MyBatis Generator generatorConfig.xml配置详解](http://blog.csdn.net/pk490525/article/details/16819307)
   > mybatis-spring的版本换成1.3.0，否则会报错：
   > java.lang.AbstractMethodError: org.mybatis.spring.transaction.SpringManagedTransaction.getTimeout()L
   * [用Maven插件生成Mybatis代码](http://my.oschina.net/lilw/blog/168304)
7. 用junit测试一下
   * Junit测试用例见test下的cn.jxnu.mapper.UserMapperTest
   * [Spring Test+JUnit完美组合](http://blog.csdn.net/shan9liang/article/details/40452469)
8. 整合springMVC
   * [spring MVC配置详解](http://www.cnblogs.com/superjt/p/3309255.html)
9. 整合Shiro
   * 添加Shiro依赖
   ```
	<dependency>
		<groupId>org.apache.shiro</groupId>
		<artifactId>shiro-web</artifactId>
		<version>1.2.4</version>
	</dependency>
	<dependency>
		<groupId>org.apache.shiro</groupId>
		<artifactId>shiro-spring</artifactId>
		<version>1.2.4</version>
	</dependency>
   ```
   * web.xml中配置Shiro拦截器
   ```
	<!-- Shiro filter -->
	<filter>
		<filter-name>shiroFilter</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		<init-param>
			<param-name>targetFilterLifecycle</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>shiroFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
   ```
   * applicationContext.xml中配置Shiro
   ```
   <!-- Shiro start-->
	<bean id="myRealm" class="cn.jxnu.realm.UserRealm" />

	<!-- 安全管理器 -->
	<bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
		<property name="realm" ref="myRealm" />
	</bean>

	<!-- 保证实现了Shiro内部lifecycle函数的bean执行 -->
	<bean id="lifecycleBeanPostProcessor" class="org.apache.shiro.spring.LifecycleBeanPostProcessor" />

	<!-- Shiro过滤器 -->
	<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
		<!-- Shiro的核心安全接口,这个属性是必须的 -->
		<property name="securityManager" ref="securityManager" />
		<!-- 身份认证失败，则跳转到登录页面的配置 -->
		<property name="loginUrl" value="/user/login" />
		<!-- 登录成功，跳转到成功页面 -->
		<!-- <property name="successUrl" value="/success"/> -->
		<!-- 权限认证失败，则跳转到指定页面 -->
		<property name="unauthorizedUrl" value="/user/login?msg=unlogin or unauthorized" />
		<!-- Shiro连接约束配置,即过滤链的定义 -->
		<property name="filterChainDefinitions">
			<value>
				/ = anon
				/user/login = anon
				/user/home = roles[teacher]
				/user/save = perms["user:create"]
				/** = authc
			</value>
		</property>
	</bean>
	<!-- Shiro end -->
   ```
   * 顺便把登录之类的功能补全一下，还有role和permission的数据库之类的(连带着generatorConfig.xml也要增加)，index.jsp也增加几个例子
10. EncodingFilter
   * [Spring中的字符编码过滤器（CharacterEncodingFilter）](http://blog.csdn.net/gaojinshan/article/details/39230635)