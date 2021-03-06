/**
 * Created by AbelTarazona on 4/05/2021
 */
package dependencies

object PresentationDep {
    const val kotlin = Dependencies.KotlinDep.kotlin
    const val javax = Dependencies.JavaDep.javax
    const val coroutineCore = Dependencies.CoroutinesDep.coroutineCore

    // Dagger-Hilt
    val daggerHilt = listOf(
        Dependencies.DaggerHiltDep.hiltAndroid,
        Dependencies.DaggerHiltDep.hiltViewModel
    )
    val daggerHiltKapt = listOf(
        Dependencies.DaggerHiltDep.hiltAndroidKapt,
        Dependencies.DaggerHiltDep.hiltKapt
    )
    val lifeCycle = listOf(
        Dependencies.LifeCycleDep.viewModelKtx,
        Dependencies.LifeCycleDep.liveDataKtx,
        Dependencies.LifeCycleDep.lifeCycleExtension,
        Dependencies.LifeCycleDep.lifeCycleRuntime,
        Dependencies.LifeCycleDep.lifeCycleRuntimeKtx
    )
}