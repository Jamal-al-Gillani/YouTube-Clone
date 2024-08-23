pipeline {
    agent any

    stages {
        stage('Pull Latest Code') {
            steps {
                sh "cd /home/jamal/projects/Youtube-clone && git stash && git pull"
            }
        }

        stage('Build or Run Docker Image') {
            steps {
                script {
                    // Check if the Docker image already exists
                    def imageExists = sh(script: "docker images -q youtube-clone:01", returnStdout: true).trim()

                    if (imageExists) {
                        // Check if the container is already running
                        def containerRunning = sh(script: "docker ps -q -f name=youtube-clone", returnStdout: true).trim()
                        if (containerRunning) {
                            echo 'Container is already running.'
                        } else {
                            // Check if the container exists but is exited
                            def containerExists = sh(script: "docker ps -a -q -f name=youtube-clone", returnStdout: true).trim()
                            if (containerExists) {
                                echo 'Container exists but is exited. Restarting container...'
                                sh 'docker start youtube-clone'
                            } else {
                                echo 'Container does not exist. Starting a new container...'
                                sh 'docker-compose up -d'
                            }
                        }
                    } else {
                        echo 'Image does not exist. Building image...'
                        sh 'docker-compose build'
                        sh 'docker-compose up -d'
                    }
                }
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
