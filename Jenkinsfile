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

        stage('Run Ansible Playbook') {
             steps {
                 script {
                     ansiblePlaybook(
                         playbook: 'deploy.yml',
                         inventory: 'inventory'
                     )
                 }
             }
        }
    }
    post {
        always {
            script {
                try {
                    docker.image("nikhilguptaiiitb/scientific-calculator:latest").remove(force: true)
                } catch (Exception e) {
                    echo "Failed to remove Docker image: ${e.message}"
                }
            }
        }
    }
}
