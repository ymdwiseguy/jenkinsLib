def call(String name = 'world') {
    wrap([$class: 'AnsiColorBuildWrapper', colorMapName: 'xterm']) {
        echo "\033[32m hello ${name} from lib \033[0m"
    }
}
