def call() {
    archiveArtifacts artifacts: '**/target/classes/service_descriptor.yml', allowEmptyArchive: true, fingerprint: true

    stash includes: '**/target/classes/service_descriptor.yml', name: 'service_descriptor'
    stash includes: '**/target/classes/route_config_dev.yml', name: 'route_config_dev'
    stash includes: '**/target/classes/route_config_int.yml', name: 'route_config_int'
    stash includes: '**/target/classes/route_config_pre.yml', name: 'route_config_pre'
    stash includes: '**/target/classes/route_config_prod.yml', name: 'route_config_prod'

    stash includes: '**/target/classes/**/*', name: 'application_classes'
    stash includes: '**/target/coverage-reports/jacoco-ut.exec', name: 'code_coverage'

    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
}
