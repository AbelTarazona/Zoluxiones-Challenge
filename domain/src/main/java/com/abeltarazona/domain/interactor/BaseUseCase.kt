package com.abeltarazona.domain.interactor

/**
 * Created by AbelTarazona on 5/05/2021
 */
interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}