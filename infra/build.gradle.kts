dependencies {
    //implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.1")
    // https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
    implementation("org.springframework.data:spring-data-jpa:2.6.1")
    // https://mvnrepository.com/artifact/javax.persistence/javax.persistence-api
    implementation("javax.persistence:javax.persistence-api:2.2")
    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:1.3.148")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    // infraはドメインに依存
    implementation(project(":domain"))
}
