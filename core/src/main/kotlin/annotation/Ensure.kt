package annotation

import constant.ProcessType

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Ensure(
    val processType: ProcessType
)
