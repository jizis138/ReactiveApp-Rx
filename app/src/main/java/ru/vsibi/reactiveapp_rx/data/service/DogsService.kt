/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.data.service

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.vsibi.reactiveapp_rx.data.model.DogResponse

interface DogsService {

    @GET("api/breeds/image/random")
    fun getDog(): Single<DogResponse>

}