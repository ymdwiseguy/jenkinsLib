def call(String packageVersion = '0') {
    wrap([$class: 'AnsiColorBuildWrapper', colorMapName: 'xterm']) {
        echo "\033[1;32mBuild maven ${packageVersion} =="
        sh "MAVEN_COLOR=true mvn -Dmaven.multiModuleProjectDirectory=$WORKSPACE versions:set -DnewVersion=${packageVersion} -DgenerateBackupPoms=False"
        sh "MAVEN_COLOR=true mvn -Dmaven.multiModuleProjectDirectory=$WORKSPACE clean verify"
        sh "MAVEN_COLOR=true mvn -Dmaven.multiModuleProjectDirectory=$WORKSPACE install -DskipTests -Pbamboo"
    }
    archiveArtifacts artifacts: '**/target/classes/service_descriptor.yml', allowEmptyArchive: true, fingerprint: true
}
