pipeline {

	environment {
		containerName = "${PARKING_SERVICE_NAME}"
		imagesName = "${PROFILE}/${PARKING_SERVICE_NAME}"
	}
	
    agent any
    tools {
        maven "maven"
    }
	
    stages {
        stage('check') {
            steps {
				sh 'mvn -v'
				checkout scm
            }
        }
		
		stage('validate'){
			steps{
				sh ''' docker stop "${containerName}" || true && docker rm "${containerName}" || true '''
				sh ''' docker images -a | grep "${imagesName}" | awk '{print \$3}' | xargs --no-run-if-empty docker rmi --force '''
			}
		}
		
        stage('package') {
            steps {
                sh "chmod +x mvnw"
                sh "./mvnw clean package -P${PROFILE} -DskipTests"
				archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true

            }
        }
		
		stage('dockerize') {
            steps {
                sh "./mvnw -P${PROFILE} package verify jib:dockerBuild -DskipTests -Dimage=${imagesName}"
            }
        }
		
		stage('deploy') {
            steps {
				script {
					sh "docker run -it --name ${containerName} ${imagesName}"
				}
			}
        }
    }
}
