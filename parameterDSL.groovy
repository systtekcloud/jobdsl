job('Job DSL with parameters') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('macloujulian')
      node / gitConfigEmail('macloujulian@gmail.com')
    }
  }
  parameters {
    stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  triggers {
    cron('H/1 * * * *')
  }
  steps {
    shell("bash jobscript.sh")
  }
}