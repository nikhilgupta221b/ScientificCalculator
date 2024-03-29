pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'Java'
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
                    docker.build("nikhilguptaiiitb/scientific-calculator:latest", ".")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub_credentials') {
                        sh "docker push nikhilguptaiiitb/scientific-calculator:latest"
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh "ansible-playbook deploy_app.yml"
                }
            }
        }
    }
}
