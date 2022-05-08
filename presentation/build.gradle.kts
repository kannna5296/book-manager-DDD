import java.util.regex.Pattern.compile

dependencies {
    // usecaseに依存
    implementation(project(":usecase"))
    // DI対象(domain層のRepositoryインターフェース)指定のためruntimeで入れる
    // 参考 > https://blog.takehata-engineer.com/entry/realizing-an-onion-architecture-in-kotlin-and-spring-boot-with-gradle-multi-project
    runtimeOnly(project(":infra"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    //API仕様書生成用
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
}
