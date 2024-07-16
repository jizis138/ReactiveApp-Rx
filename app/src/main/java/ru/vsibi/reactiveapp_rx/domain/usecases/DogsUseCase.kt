/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.domain.usecases

import io.reactivex.rxjava3.core.Single
import ru.vsibi.reactiveapp_rx.domain.model.Dog
import ru.vsibi.reactiveapp_rx.domain.repository.DogsRepository

class DogsUseCase(private val dogsRepository: DogsRepository) {

    fun getDog() : Single<Dog> = dogsRepository.getDog()

}