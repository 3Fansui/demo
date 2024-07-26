# 简易版视频网站

这是一个使用 Java 和 Spring Boot 构建的简易版视频网站项目。

## 功能

- 用户注册和登录
- 视频上传和播放
- 视频评论和点赞

## 技术栈

- Java 17
- Spring Boot 3.3.0
- Maven 3.6.3
- MySQL 8.0
- MyBatis
- Knife4j

## 快速开始

### 环境要求

- JDK 17
- Maven 3.6.3+
- MySQL 8.0+

### 配置文件

在 `src/main/resources/application.properties` 文件中，您需要根据自己的环境修改以下配置：

```properties
# 数据库配置
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password

# 视频文件存储路径
video-path=d:\\aaa\\


### 构建和运行

1. 克隆项目到本地：
    ```bash
    git clone https://github.com/your_username/your_repository.git
    cd your_repository
    ```

2. 使用 Maven 构建项目：
    ```bash
    mvn clean install
    ```

3. 运行项目：
    ```bash
    mvn spring-boot:run
    ```

### 静态资源映射

在代码中，您需要确保正确配置了静态资源映射。例如，在 Spring Boot 配置类中添加以下内容：

```java
@SpringBootApplication
public class Demo1Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/play/**").addResourceLocations("file:d:\\aaa\\");
        registry.addResourceHandler("/img/**").addResourceLocations("file:d:\\aaa\\");
    }

    @Value("${video-path}")
    private String path;
}
```
