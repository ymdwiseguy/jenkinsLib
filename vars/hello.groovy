def sayHello() {
    wrap([$class: 'AnsiColorBuildWrapper', colorMapName: 'xterm']) {
        echo "\033[32m hello world from lib \033[0m"
    }
}
