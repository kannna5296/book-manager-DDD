dependencies {
    //全部要る
    implementation(project(":usecase"))
    implementation(project(":domain"))
    implementation(project(":infra"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}