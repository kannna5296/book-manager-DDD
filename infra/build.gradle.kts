dependencies {
    //infraはドメインに依存
    implementation(project(":domain"))
    // https://mvnrepository.com/artifact/com.h2database/h2
    testImplementation("com.h2database:h2:1.3.148")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    implementation("com.microsoft.sqlserver:mssql-jdbc")
}