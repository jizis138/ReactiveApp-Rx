package ru.vsibi.reactiveapp_rx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import org.koin.compose.KoinContext
import ru.vsibi.reactiveapp_rx.ui.screens.dogs_single.DogsScreen
import ru.vsibi.reactiveapp_rx.ui.screens.main.MainScreen
import ru.vsibi.reactiveapp_rx.ui.theme.ReactiveAppRxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReactiveAppRxTheme {
                KoinContext {
                    Navigator(screen = MainScreen())
                }
            }
        }
    }
}