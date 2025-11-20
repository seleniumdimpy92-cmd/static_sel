pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build') {
      steps { sh 'mvn -B -DskipTests=true verify' }
    }
    stage('Test') {
      steps { sh 'mvn -B test' }
    }
    stage('Publish') {
      steps {
        archiveArtifacts artifacts: 'target/allure-results/**', fingerprint: true
      }
    }
  }
}
