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
        }

        project.task("alc-test"){

            println "real test 3...."

        }

    }
}
