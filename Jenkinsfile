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
 - name: kubectl
    image: lachlanevenson/k8s-kubectl:v1.8.8
    command: ['cat']
    tty: true
  - name: maven-firefox
    image: maven:3.3.9-jdk-8-alpine
    command: ['cat']
    tty: true
  - name: maven-chrome
    image: maven:3.3.9-jdk-8-alpine
    command: ['cat']
    tty: true
  - name: selenium-hub
    image: selenium/hub:3.4.0
  - name: selenium-chrome
    image: selenium/node-chrome:3.4.0
    env:
    - name: HUB_PORT_4444_TCP_ADDR
      value: localhost
    - name: HUB_PORT_4444_TCP_PORT
      value: 4444
    - name: DISPLAY
      value: :99.0
    - name: SE_OPTS
      value: -port 5556
  - name: selenium-firefox
    image: selenium/node-firefox:3.4.0
    env:
    - name: HUB_PORT_4444_TCP_ADDR
      value: localhost
    - name: HUB_PORT_4444_TCP_PORT
      value: 4444
    - name: DISPLAY
      value: :98.0
    - name: SE_OPTS
      value: -port 5557
"""
  ) {

  node(label) {
  
	def myRepo = checkout scm
    def gitCommit = myRepo.GIT_COMMIT
    def gitBranch = myRepo.GIT_BRANCH
    def shortGitCommit = "${gitCommit[0..10]}"
    def previousGitCommit = sh(script: "git rev-parse ${gitCommit}~", returnStdout: true)
 
    stage('Run kubectl') {
      container('kubectl') {
        sh "kubectl get pods"
      }
    }
  
    stage('Checkout') {
      git 'https://github.com/carlossg/selenium-example.git'
      parallel (
        firefox: {
          container('maven-firefox') {
            stage('Test firefox') {
              sh 'mvn -B clean test -Dselenium.browser=firefox -Dsurefire.rerunFailingTestsCount=5 -Dsleep=0'
            }
          }
        },
        chrome: {
          container('maven-chrome') {
            stage('Test chrome') {
              sh 'mvn -B clean test -Dselenium.browser=chrome -Dsurefire.rerunFailingTestsCount=5 -Dsleep=0'
            }
          }
        }
      )
    }

    stage('Logs') {
      containerLog('selenium-chrome')
      containerLog('selenium-firefox')
    }
  }
}
