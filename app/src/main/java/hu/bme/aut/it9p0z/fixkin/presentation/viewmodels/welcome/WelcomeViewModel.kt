package hu.bme.aut.it9p0z.fixkin.presentation.viewmodels.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.repository.DataStoreRepository
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun saveOnOpeningState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnOpeningState(completed = completed)
        }
    }

}