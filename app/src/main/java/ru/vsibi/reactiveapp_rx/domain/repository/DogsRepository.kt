/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.vsibi.reactiveapp_rx.domain.model.Dog

interface DogsRepository {

    fun getDog(): Single<Dog>

}