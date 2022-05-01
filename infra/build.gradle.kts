dependencies {
    //infraはドメインに依存
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.1")
    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:1.3.148")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    implementation(project(":domain"))
    implementation(project(":usecase"))
}