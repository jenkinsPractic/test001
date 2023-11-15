pipeline {
	agent none
	environment {
		USERNAME = 'slave'
		HOST = '192.168.99.100'
	}
	stages {
		stage('add pub key') {
			steps {
				withCredentials([file{credentialsId: 'lan_pub', variable: 'key')])
				sh ''' ssh-copy-id -i ${key} ${USERNAME}@${HOST} '''
			}
		}
	}
}
