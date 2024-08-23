pipeline {
    agent any

    stages {
        stage('Pull Latest Code') {
            steps {
                sh "cd /home/jamal/projects/Youtube-clone && git pull"
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
