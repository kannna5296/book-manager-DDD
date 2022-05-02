dependencies {
    //全部要る
    implementation(project(":usecase"))
    implementation(project(":domain"))
    implementation(project(":infra"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.1")
}