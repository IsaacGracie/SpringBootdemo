Spring Boot 简介：
Spring Boot 是一个基于 Spring 框架 的开源 Java 开发框架，旨在简化 Spring 应用的初始搭建和开发流程。它采用约定优于配置的原则，减少繁琐的 XML 配置，让开发者能够快速构建生产级的独立应用。  

Spring Boot 核心特点：

简化配置： 
自动配置（Auto-configuration）：根据项目依赖自动配置 Spring 应用。  
起步依赖（Starter Dependencies）：提供预定义的依赖组合，避免手动管理版本冲突。

内置服务器：默认集成 Tomcat、Jetty、Undertow，无需额外部署，直接 java -jar 运行。

微服务友好：与 Spring Cloud 深度集成，支持服务发现（Eureka）、配置中心（Config）、负载均衡（Ribbon）等微服务组件。

丰富的生态：Actuator（监控）、DevTools（热部署）、Spring Security（安全）等扩展，提升开发效率和应用健壮性。

生产就绪：提供健康检查、性能指标、日志管理等企业级功能，方便运维和监控。


项目结构：
<img width="1346" height="1444" alt="image" src="https://github.com/user-attachments/assets/8d9d0dfe-9946-440b-9534-44f38c15ab97" />


REST API规范：
    路径：路径又称“终点”（endpoint），表示API的具体网址。
        在RESTful架构中，每个网址代表一种资源（resource），所以网址中不能有动词，只能有名词，而且所用的名词往往与数据库的表格名对应。

Http 动词：
GET（SELECT）：从服务器取出资源（一项或多项）。
POST（CREATE）：在服务器新建一个资源。
PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
DELETE（DELETE）：从服务器删除资源。

创建数据库表：

建库语句：
    CREATE DATABASE test
      CHARACTER SET utf8mb4
      COLLATE utf8mb4_general_ci;
  
建表语句：
    CREATE TABLE student (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(50) NOT NULL,
      email VARCHAR(100) NOT NULL,
      age INT
    );
