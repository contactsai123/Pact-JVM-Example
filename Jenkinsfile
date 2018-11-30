/**
 * This pipeline executes Selenium tests against Chrome and Firefox, all running in the same Pod but in separate containers
 * and in parallel
 */

def label = "maven-selenium-${UUID.randomUUID().toString()}"

podTemplate(label: label, yaml: """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: gradle
    image: gradle:4.5.1-jdk9
    command: ['cat']
    tty: true
    privileged: true
  - name: kubectl
    image: lachlanevenson/k8s-kubectl:v1.8.8
    command: ['cat']
    tty: true
"""
  ) {

  node(label) {
  
   
    stage('Run kubectl') {
      container('kubectl') {
        sh "kubectl get pods"
      }
    }
	
	stage('Dev code Checkout') {
      git 'https://github.com/contactsai123/PACT-JVM-Example.git'
      parallel (
        buildrepo: {
          container('gradle') {
            stage('Build repo') {
              sh 'chmod +x gradlew;./gradlew clean build -xtest'
            }
          }
        },
        testrepo: {
          container('gradle') {
            stage('Test repo') {
              sh 'chmod +x gradlew;./gradlew clean build -xtest'
            }
          }
        }
      )
    }
	
    stage('Logs') {
      containerLog('gradle')
      containerLog('kubectl')
    }
  }
}
