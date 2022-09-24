job('JobDSLwithParametersGit') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/systtekcloud/jobdsl.git', 'main') { node ->
      node / gitConfigName('systtekcloud')
      node / gitConfigEmail('sergi@systtekcloud.com')
    }
  }
  parameters {
    stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  triggers {
    cron('H/1 * * * *')
    githubPush()
  }
  steps {
    shell("bash jobscript.sh")
  }
}