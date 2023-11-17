pipeline {
    agent any
    environment {
        USERNAME = 'slave'
        HOST = '192.168.99.100'
        Key = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC8D/0fzS5y9C+mBxXmrGE1/wv532muPu/AHxCgnjp5ZbQffn0oo706E8zaQCrVI333HqS2Lapby/3J9/AHac9fJ79B6p9mW7rJwemeUxv3qXKjfF3cmbssGwIA1WqUXsaUo51UWV5Zmk4TKnJNZcCFLSBgnqd8MCDUYS+kt6i+Ka3Bpjyw6rza3e1hxcalPBa1Ch+5Dqm/oHgm69JgnM7xwpexJne/UA2heUdlKrMZx5R5HZf2ESheBNO4OO3ZPGDaqB3pXIMRNDC11uP88C4rKC/KEMjPiyCvgCgfZatmmh+uG9Hitj+ACtTjD/a/gzrSO8LkuUgwFuhJfQhYYRZ/vqx1z19J7l/vLZoyIAeI/ukiudakcgQVSJMBhQai+8BAf0GGCWpb3XinYCSYB1yiwGQFYdCCQVf1L8IBTb6lP0tU38cLTdu/37gmz9CJl/1/4tqxTI4HUzX40fPWOHky3tMuqGP66VhLQ4JkQq7YK8S5Fv+oRt/S9PutdEgOzH8= master@redos"
        PATH = '/var/jenkins_home/workspace/test_install'
        FILE_NAME = 'pubkey.pub'
    }
    stages {
        stage('create pub key') {
            steps {
                //sh ''' ssh ${USERNAME}@${HOST}'''
                //sh ''' ssh -l StrictHostKeyChecking=no ${USERNAME}@{HOST} '''
                //sh '''sshpass -p 'slave' ssh -o StrictHostKeyChecking=no ${USERNAME}@${HOST}'''
                writeFile(file: '''key''', text: '''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''')
                writeFile(file: '''pubkey.pub''', text: '''ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC8D/0fzS5y9C+mBxXmrGE1/wv532muPu/AHxCgnjp5ZbQffn0oo706E8zaQCrVI333HqS2Lapby/3J9/AHac9fJ79B6p9mW7rJwemeUxv3qXKjfF3cmbssGwIA1WqUXsaUo51UWV5Zmk4TKnJNZcCFLSBgnqd8MCDUYS+kt6i+Ka3Bpjyw6rza3e1hxcalPBa1Ch+5Dqm/oHgm69JgnM7xwpexJne/UA2heUdlKrMZx5R5HZf2ESheBNO4OO3ZPGDaqB3pXIMRNDC11uP88C4rKC/KEMjPiyCvgCgfZatmmh+uG9Hitj+ACtTjD/a/gzrSO8LkuUgwFuhJfQhYYRZ/vqx1z19J7l/vLZoyIAeI/ukiudakcgQVSJMBhQai+8BAf0GGCWpb3XinYCSYB1yiwGQFYdCCQVf1L8IBTb6lP0tU38cLTdu/37gmz9CJl/1/4tqxTI4HUzX40fPWOHky3tMuqGP66VhLQ4JkQq7YK8S5Fv+oRt/S9PutdEgOzH8= master@redos''')
                sh ''' ls -l '''
                //sh ''' realpath key '''
                sh ''' mkdir .ssh '''
                sh ''' ls -a '''
                //sh ''' cd ${PATH} '''
                sh ''' mv ${FILE_NAME} .ssh/${FILE_NAME} '''
                sh ''' cd .ssh '''
                sh ''' cat ${FILE_NAME} '''
                //sh ''' ssh-copy-id -i /var/jenkins_home/workspace/test_install/pubkey.pub ${USERNAME}@${HOST} '''
            }
            //sh ''' echo 'connected' '''
            //sshagent('ssh-agent')
            //    {
                //sh ''' cat groovy.txt '''
                //sshpass -p 'password' ssh -o StrictHostKeyChecking=no slave@192.168.99.100
                //sh ''' ssh-copy-id -i 'lan_pub' slave@192.168.99.100 '''
            //    }
        }
        stage('add pub key') {
           steps {
                //sh ''' cd /var/jenkins_home/.ssh '''
                //sh ''' ls '''
                //sh ''' ssh ${USERNAME}@${HOST} '''
                sh ''' cd .ssh '''
                sh ''' ssh-copy-id -f -i ${FILE_NAME} ${USERNAME}@${HOST} '''
            }
        }
    }
}
