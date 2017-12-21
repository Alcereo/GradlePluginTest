package ru.alcereo.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by alcereo on 21.12.17.
 */
class TestPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {

        project.configure(project){

            apply plugin: 'java'

            sourceCompatibility = 1.7

            ext {
                springBootConfig = 'org.springframework.boot:spring-boot-starter-test:2.0.0.M7'
            }

            repositories{
                mavenCentral()
                maven{
                    url 'http://repo.spring.io/milestone/'
                }
            }
        }

        def ALCEREO_GROUP = 'alcereo-tasks'

        project.task("alc-test"){
            group = ALCEREO_GROUP
            description = "Вывод тестовой строки.. Те се.."

            doLast{

                println "real test 3...."
            }
        }


        project.task("shell-script-test"){
            group = ALCEREO_GROUP
            description = "Выполнение скрипта..."

            doLast{

                def proc = "git --version".execute()
                proc.waitForProcessOutput(System.out, System.err)
            }
        }

    }
}
