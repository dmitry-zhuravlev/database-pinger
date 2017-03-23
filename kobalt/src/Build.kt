import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project


val pingerProject = project {
    name = "database-pinger"
    group = "com.pinger"
    artifactId = name
    version = "1.0-SNAPSHOT"
    directory = "database-pinger"



    dependencies {
//       database drivers. Oracle driver not included due licence violation.
        compile("org.postgresql:postgresql:9.4-1206-jdbc4")
        compile("org.apache.derby:derbyclient:10.13.1.1")
        compile("mysql:mysql-connector-java:6.0.6")

        compile("com.beust:jcommander:1.60")
        compile("org.jetbrains.kotlin:kotlin-stdlib-jre7:1.1.1")

    }


    dependenciesTest {
        compile("org.testng:testng:6.9.9")
        compile("org.jetbrains.kotlin:kotlin-test:1.1.1")
    }


    sourceDirectories {
        path("src/main/kotlin")
    }


    sourceDirectoriesTest {
        path("src/main/kotlin")
    }

    assemble {
        jar {
            manifest {
                fatJar = true
                attributes("Main-Class", "com.pinger.MainKt")
            }
        }
    }

}