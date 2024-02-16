pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java'
    }

    environment {
        IMAGE_NAME = 'nikhilguptaiiitb/scientific-calculator'
        IMAGE_TAG = '1.0-SNAPSHOT'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub_credentials', usernameVariable: 'REGISTRY_USER', passwordVariable: 'REGISTRY_PASS')]) {
                        sh "docker login -u ${REGISTRY_USER} -p ${REGISTRY_PASS}"
                        sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy step is not implemented yet.'
            }
        }
    }
}
