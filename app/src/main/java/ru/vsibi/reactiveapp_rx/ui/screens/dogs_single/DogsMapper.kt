/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.ui.screens.dogs_single

import ru.vsibi.reactiveapp_rx.domain.model.Dog

fun Dog.map() = DogViewItem(imageUrl = imageUrl)