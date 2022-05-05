dependencies {
    // usecaseに依存
    implementation(project(":usecase"))
    // infraに依存(mapperscanのため)
    implementation(project(":infra"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.1")
}
