node {
    def WORKSPACE = "${JENKINS_HOME}/workspace/LastPipeline"
    def mysqlContainerName = "mysqlContainer"
    def springAppContainerName = "spring-app-container"
    def dockerComposeDir = "${WORKSPACE}"  // Update this line
    def dockerComposeFilePath = "./docker-compose.yml"
    def dockerNetworkName = "lastNet"

    try {
        notifyBuild('STARTED')

        stage('Clone Repo') {
            git url: 'https://github.com/douaeelmz/SpringBootMicroServices.git',
                           credentialsId: 'LastUser',
                           branch: 'main'
        }

        stage('Create Docker Network') {
            dir(dockerComposeDir) {  // Add this block
                script {
                    if (isUnix()) {
                        sh "docker network inspect ${dockerNetworkName} > /dev/null 2>&1 || docker network create ${dockerNetworkName}"
                    } else {
                        bat "docker network inspect ${dockerNetworkName} >nul 2>&1 || docker network create ${dockerNetworkName}"
                    }
                }
            }
        }

        stage('Run MySQL Container') {
            dir(dockerComposeDir) {  // Add this block
                script {
                    if (isUnix()) {
                        sh "docker-compose -f ${dockerComposeFilePath} up -d mysql"
                    } else {
                        bat "docker-compose -f ${dockerComposeFilePath} up -d mysql"
                    }
                }
            }
        }

        stage('Build and Run Docker Containers') {
            script {
                if (isUnix()) {
                    sh "docker-compose -f ${dockerComposeFilePath} up -d authentication-service"
                } else {
                    bat "docker-compose -f ${dockerComposeFilePath} up -d authentication-service"
                }
            }
        }
        stage('Build and Run Docker Containers - Microservice2') {
            script {
                if (isUnix()) {
                    sh "docker-compose -f ${dockerComposeFilePath} up -d microservice2"
                } else {
                    bat "docker-compose -f ${dockerComposeFilePath} up -d microservice2"
                }
            }
        }

    } catch (e) {
        currentBuild.result = "FAILED"
        throw e
    } finally {
        notifyBuild(currentBuild.result)
    }
}
def notifyBuild(String buildStatus = 'STARTED'){

  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def now = new Date()

  // message
  def subject = "${buildStatus}, Job: ${env.JOB_NAME} FRONTEND - Deployment Sequence: [${env.BUILD_NUMBER}] "
  def summary = "${subject} - Check On: (${env.BUILD_URL}) - Time: ${now}"
  def subject_email = "Spring boot Deployment"
  def details = """<p>${buildStatus} JOB </p>
    <p>Job: ${env.JOB_NAME} - Deployment Sequence: [${env.BUILD_NUMBER}] - Time: ${now}</p>
    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""

  }
