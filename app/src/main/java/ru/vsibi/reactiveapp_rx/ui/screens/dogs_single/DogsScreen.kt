/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.ui.screens.dogs_single

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.SubcomposeAsyncImage
import coil.imageLoader
import org.koin.compose.koinInject
import ru.vsibi.reactiveapp_rx.domain.usecases.DogsUseCase


class DogsScreen : Screen {
    @Composable
    override fun Content() {

        val dogsUseCase = koinInject<DogsUseCase>()

        val vm = rememberScreenModel { DogsViewModel(dogsUseCase) }

        DogsContent(vm)
    }
}

@Composable
fun DogsContent(vm: DogsViewModel) {
    val viewState = vm.state.subscribeAsState(initial = DogsState(dogs = listOf(), current = 0))

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        with(viewState.value) {
            if (dogs.isNotEmpty()) {
                SubcomposeAsyncImage(modifier = Modifier.fillMaxSize(),
                    model = dogs[current].imageUrl,
                    contentDescription = null,
                    imageLoader = context.imageLoader,
                    loading = {
                        CircularLoading()
                    })
            } else {
                CircularLoading()
            }
        }

        Button(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 60.dp), onClick = {
            vm.next(currentIncrease = true)
        }) {
            Text(text = "Next")
        }
    }
}

@Composable
fun CircularLoading() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}