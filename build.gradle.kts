import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.flywaydb.flyway") version "6.2.2"
	id("io.gitlab.arturbosch.detekt").version("1.19.0")
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "com.book.manager"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
	//implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
	implementation("org.flywaydb:flyway-core")
	//TODO そのうちSQLServerに変えたい
	implementation("com.microsoft.sqlserver:mssql-jdbc")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
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
tasks.register("runup", Exec::class) {
	commandLine("docker-compose", "up", "-d")
}

// DBサーバ作成
tasks.register("rundown", Exec::class) {
	commandLine("docker-compose", "down")
}

// DB作成
tasks.register("createDb", Exec::class) {
	// TODO 可変にしたい
	commandLine("docker", "exec", "-i", "mssql", "/opt/mssql-tools/bin/sqlcmd", "-U", "sa", "-P", "passWord567", "-Q", "CREATE DATABASE test")
}


flyway {
	url = "jdbc:sqlserver://localhost:1433;databaseName=test;loginTimeout=30;socketTimeout=30000"
	user = "sa"
	password = "passWord567"
}
