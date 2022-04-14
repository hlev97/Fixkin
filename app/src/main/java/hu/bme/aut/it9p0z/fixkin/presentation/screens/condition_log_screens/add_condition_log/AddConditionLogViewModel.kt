package hu.bme.aut.it9p0z.fixkin.presentation.screens.condition_log_screens.add_condition_log

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
import hu.bme.aut.it9p0z.fixkin.data.repository.Repository
import javax.inject.Inject

@HiltViewModel
class AddConditionLogViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    suspend fun insertConditionLog(log: ConditionLog) { repository.insertConditionLog(log = log) }

    var feelingValue = ConditionLog.Feeling.feeling_1;
}