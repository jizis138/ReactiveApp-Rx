/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.ui.screens.dogs_single

data class DogsState(
    val dogs: List<DogViewItem>,
    val current: Int
)