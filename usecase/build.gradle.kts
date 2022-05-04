dependencies {
    // cleanアーキテクチャの考え方に寄り、usecase層はdomain層にのみ依存する
    // application層ともいう
    implementation(project(":domain"))
}
