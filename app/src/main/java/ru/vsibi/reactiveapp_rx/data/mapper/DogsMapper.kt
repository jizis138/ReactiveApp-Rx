/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.data.mapper

import ru.vsibi.reactiveapp_rx.data.model.DogResponse
import ru.vsibi.reactiveapp_rx.domain.model.Dog

fun DogResponse.map() = Dog(
    imageUrl = message
)