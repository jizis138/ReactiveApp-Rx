/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.data.repository_impl

import android.content.Context
import coil.imageLoader
import coil.request.ImageRequest
import io.reactivex.rxjava3.core.Single
import ru.vsibi.reactiveapp_rx.data.mapper.map
import ru.vsibi.reactiveapp_rx.data.model.DogResponse
import ru.vsibi.reactiveapp_rx.data.service.DogsService
import ru.vsibi.reactiveapp_rx.domain.model.Dog
import ru.vsibi.reactiveapp_rx.domain.repository.DogsRepository

class DogsRepositoryImpl(
    private val dogsService: DogsService,
    private val context: Context
) : DogsRepository {

    override fun getDog(): Single<Dog> =
        dogsService.getDog()
            .map(DogResponse::map)
            .doOnSuccess {
                preloadImage(it.imageUrl)
            }

    private fun preloadImage(imageUrl: String) {
        val request = ImageRequest.Builder(context)
            .data(imageUrl)
            .build()
        context.imageLoader.enqueue(request)
    }

}