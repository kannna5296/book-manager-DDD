import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.flywaydb.flyway") version "6.2.2"
	id("io.gitlab.arturbosch.detekt").version("1.19.0")
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "net.bookmanager"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

allprojects {
	repositories {
		mavenCentral()
	}
	apply(plugin="kotlin")
	apply(plugin="org.jetbrains.kotlin.plugin.spring")
	apply(plugin="org.springframework.boot")
	apply(plugin="io.spring.dependency-management")
}


subprojects {
	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.springframework.boot:spring-boot-starter-security")
		implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")

		implementation("org.flywaydb:flyway-core")
		implementation("com.microsoft.sqlserver:mssql-jdbc")
		testImplementation("org.springframework.boot:spring-boot-starter-test")

		implementation("org.springframework.session:spring-session-data-redis")
		implementation("redis.clients:jedis")
		implementation("org.springframework.boot:spring-boot-starter-aop")
		testImplementation(kotlin("test"))
	}
}


tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


// DBサーバ作成
//tasks.register("runup", Exec::class) {
//	commandLine("docker-compose", "up", "-d")
//}
//
//// DBサーバ作成
//tasks.register("rundown", Exec::class) {
//	commandLine("docker-compose", "down")
//}
//
//// DB作成
//tasks.register("createDb", Exec::class) {
//	// TODO 可変にしたい
//	commandLine("docker", "exec", "-i", "mssql", "/opt/mssql-tools/bin/sqlcmd", "-U", "sa", "-P", "passWord567", "-Q", "CREATE DATABASE test")
//}


//flyway {
//	url = "jdbc:sqlserver://localhost:1433;databaseName=test;loginTimeout=30;socketTimeout=30000"
//	user = "sa"
//	password = "passWord567"
//}
