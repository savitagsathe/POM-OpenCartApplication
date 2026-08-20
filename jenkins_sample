pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                echo 'Building the project'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Run unit level test cases'
            }
        }

        stage('Deploy on Dev') {
            steps {
                echo 'Deploy on Dev'
            }
        }

        stage('Deploy on QA') {
            steps {
                echo 'Deploy on QA'
            }
        }

        stage('Sanity Test') {
            steps {
                echo 'Run Sanity'
            }
        }

        stage('Regression Test') {
            steps {
                echo 'Run Regression'
            }
        }

        stage('Deploy on Stage') {
            steps {
                echo 'Deploy on Stage'
            }
        }

        stage('Sanity on Stage') {
            steps {
                echo 'Sanity done on Stage'
            }
        }

        stage('Prod Deployment') {
            steps {
                echo 'Deployed on Prod'
            }
        }
    }
}