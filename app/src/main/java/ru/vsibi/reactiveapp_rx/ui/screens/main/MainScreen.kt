/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.vsibi.reactiveapp_rx.ui.screens.dogs_single.DogsScreen

class MainScreen : Screen {
    @Composable
    override fun Content() {
        MainContent()
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.currentOrThrow

    Column(modifier = modifier
        .fillMaxSize()
        .padding(top = 60.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {
            navigator.push(DogsScreen())
        }) {
            Text("Prefetch Dogs (Single)")
        }

    }

}