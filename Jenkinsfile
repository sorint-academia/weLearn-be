pipeline {
  agent any
  stages {
    stage('test') {
      steps {
        sh 'mvn test'
        sh 'mvn surefire-report:report'
      }
      post {
        always {
          junit '**/surefire-reports/**/*.xml'
          
        }
        
      }
    }
    stage('build') {
      steps {
        sh 'mvn clean compile'
        sh 'mvn package'
      }
     
      /*post {
        success {
          archiveArtifacts 'target/*.jar'
          
        }
        
      }*/
    }
    stage('report') {
      steps {
        archiveArtifacts(artifacts: 'target/*.jar', allowEmptyArchive: true)
      }
    }
  }
  tools {
    maven 'Maven_3_5_3'
  }
}