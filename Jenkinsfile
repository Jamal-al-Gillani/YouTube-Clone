pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Clone your GitHub repo
                git 'https://github.com/Jamal-al-Gillani/Youtube-clone.git'
            }
        }
        
        stage('Configure Nginx') {
            steps {
                script {
                    // Run the custom script to configure and start Nginx
                    sh 'groovy script.groovy'
                }
            }
        }
    }
    
    post {
        always {
            // Optionally, you can add commands here to stop Nginx or clean up
        }
    }
}
