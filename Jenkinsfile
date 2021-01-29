pipeline{
    agent any
    // tools list use in jenkins pipeline
    tools{
    maven 'maven3.6.3'
    }
    stages{
        stage('Clone'){
        steps{
            git 'https://bitbucket.org/nguyenphuc46/api-demo.git'
//             sh 'sudo systemctl restart spring-boot-hello'
            }
            }
        stage('Build'){
        steps{
            sh 'mvn compile'
            }
         }
 /*        stage('Test'){
          steps{
           sh 'mvn test'
        }
        }
          stage('Deploy'){
                  steps{
                  sh 'mvn install'
                  sh 'sudo cp /var/lib/jenkins/workspace/check-sum-pipeline/target/api-0.0.1-SNAPSHOT.jar /home/phucnd/workspace_intellij/workspace_jar/api-0.0.1-SNAPSHOT.jar'
                  sh 'sudo systemctl restart spring-boot-hello'
                  echo 'Success !'
                }
                } */

        }

    }