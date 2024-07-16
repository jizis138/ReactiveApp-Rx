package ru.vsibi.reactiveapp_rx.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.vsibi.reactiveapp_rx.data.network.ClientCreator
import ru.vsibi.reactiveapp_rx.data.repository_impl.DogsRepositoryImpl
import ru.vsibi.reactiveapp_rx.data.service.DogsService
import ru.vsibi.reactiveapp_rx.domain.repository.DogsRepository
import ru.vsibi.reactiveapp_rx.domain.usecases.DogsUseCase
import ru.vsibi.reactiveapp_rx.ui.screens.dogs_single.DogsViewModel

object CommonModule {

    operator fun invoke() = module {


        singleOf(::ClientCreator)

        single {
            get<ClientCreator>().create(DogsService::class.java)
        }

        singleOf(::DogsRepositoryImpl) bind DogsRepository::class

        factoryOf(::DogsUseCase)

//        viewModelOf(::DogsViewModel)

    }

}