def call(String packageVersion = '0') {
    wrap([$class: 'AnsiColorBuildWrapper', colorMapName: 'xterm']) {
        sh "MAVEN_COLOR=true mvn -Dmaven.multiModuleProjectDirectory=$WORKSPACE versions:set -DnewVersion=${packageVersion} -DgenerateBackupPoms=False"
        sh "MAVEN_COLOR=true mvn -Dmaven.multiModuleProjectDirectory=$WORKSPACE clean verify"
        sh "MAVEN_COLOR=true mvn -Dmaven.multiModuleProjectDirectory=$WORKSPACE install -DskipTests -Pbamboo"
    }
}
