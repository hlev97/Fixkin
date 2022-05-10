package hu.bme.aut.it9p0z.fixkin.presentation.viewmodels.condition_log_screens.check_condition_log

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import hu.bme.aut.it9p0z.fixkin.util.feelingToSliderPosition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckConditionLogViewModel @Inject constructor(
    private val repository: Repository,
    savedStateHandle: SavedStateHandle
) :ViewModel() {
    private val _selectedConditionLog: MutableStateFlow<ConditionLog?> = MutableStateFlow(null)
    val selectedConditionLog: StateFlow<ConditionLog?> = _selectedConditionLog

    var sliderPosition: Float = feelingToSliderPosition(selectedConditionLog.value?.feeling ?: ConditionLog.Feeling.feeling_1)
    var feelingValue = selectedConditionLog.value?.feeling ?: ConditionLog.Feeling.feeling_1


    private fun getConditionLog(id: Int) {
        viewModelScope.launch {
            repository.getConditionLog(id = id).collect { log ->
                _selectedConditionLog.value = log
            }
        }
    }

    fun updateConditionLog(log: ConditionLog) {
        viewModelScope.launch {
            repository.updateConditionLog(log)
        }
    }

    fun deleteConditionLog(log: ConditionLog) {
        viewModelScope.launch {
            repository.deleteConditionLog(log)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val conditionLogId = savedStateHandle.get<Int>("id");
            if (conditionLogId != null) {
                getConditionLog(conditionLogId)
            }
            if (selectedConditionLog.value != null) {
                sliderPosition = feelingToSliderPosition(selectedConditionLog.value!!.feeling)
            }
        }
    }
}