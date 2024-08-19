pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Clone your GitHub repo
                git 'https://github.com/Jamal-al-Gillani/Youtube-clone.git'
            }
        }
    }
    
    post {
        always {
            echo "Pipeline successfully run"
        }
    }
}
