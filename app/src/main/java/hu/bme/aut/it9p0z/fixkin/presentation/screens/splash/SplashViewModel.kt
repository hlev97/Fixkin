package hu.bme.aut.it9p0z.fixkin.presentation.screens.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.bme.aut.it9p0z.fixkin.navigation.Screen
import hu.bme.aut.it9p0z.fixkin.presentation.data.repository.DataStoreRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.Welcome.screen_route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnOpeningState().collect { completed ->
                if (completed) {
                    _startDestination.value = Screen.Main.screen_route
                } else {
                    _startDestination.value = Screen.Welcome.screen_route
                }
            }
            _isLoading.value = false
        }
    }

}