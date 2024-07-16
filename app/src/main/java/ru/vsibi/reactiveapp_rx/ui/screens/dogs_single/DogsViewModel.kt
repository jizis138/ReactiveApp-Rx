/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.ui.screens.dogs_single

import cafe.adriel.voyager.rxjava.RxScreenModel
import cafe.adriel.voyager.rxjava.disposables
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vsibi.reactiveapp_rx.domain.usecases.DogsUseCase

class DogsViewModel(
    private val dogsUseCase: DogsUseCase,
) : RxScreenModel<DogsState>() {

    private companion object {
        const val PREFETCH_DISTANCE = 3
    }

    init {
        next(
            currentIncrease = false,
            times = PREFETCH_DISTANCE
        )
    }

    fun next(currentIncrease: Boolean, times: Int = 1) {
        repeat(times) {
            dogsUseCase.getDog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        val state = mutableState.value ?: DogsState(dogs = listOf(), current = 0)
                        val current = if (currentIncrease) {
                            state.current + 1
                        } else {
                            state.current
                        }

                        val newDog = response.map()
                        mutableState.onNext(
                            state.copy(
                                dogs = state.dogs.plus(newDog),
                                current = current
                            )
                        )
                    },
                    { error -> error.printStackTrace() }
                ).let(disposables::add)
        }
    }

}