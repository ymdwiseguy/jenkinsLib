def call(String packageVersion = '0') {
    wrap([$class: 'AnsiColorBuildWrapper', colorMapName: 'xterm']) {
        echo "\033[1;32mBuild yarn ${packageVersion} =="
        sh "GIT_HASH=`git rev-parse HEAD` && echo \"buildTestAndPackage() git hash: \"\$GIT_HASH"
        sh "cd ./src/main/frontend && yarn install && yarn test && GIT_HASH=`git rev-parse HEAD` yarn build"
    }
}
