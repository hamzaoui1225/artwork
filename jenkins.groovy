pipeline {
    agent any

    tools{
        jdk 'jdk22'
        maven 'maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: '{PROJECT-GIT_URL}'
            }
        }

        stage('Build Back-End'){
            steps{
                sh "cd interview; ./mvn clean package -DskipTests"
            }
        }

        stage("Docker Build And Staging"){
            steps{
                sh 'docker-compose up -d --build'
            }
        }
    }
}