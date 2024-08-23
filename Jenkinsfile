pipeline {
    agent any

    stages {
        stage('Pull Latest Code') {
            steps {
                sh "git pull"
            }
        }

        stage('Deploy the Latest Code') {
            steps {
                sh "docker-compose up -d"
            }
        }

        stage('Verify the app') {
            steps {
                sh "docker ps"
            }
        }

    }
}
