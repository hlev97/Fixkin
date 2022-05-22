//package hu.bme.aut.it9p0z.fixkin.data.repository
//
//import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
//import hu.bme.aut.it9p0z.fixkin.data.model.LifeQualityTestResultLog
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//
//class FakeRepository(
//    private var conditionLogs: MutableList<ConditionLog>,
//    private var lqtrLogs: MutableList<LifeQualityTestResultLog>
//) : ConditionLogRepository, LifeQualityTestResultLogRepository, DataStoreRepository {
//
//    var openingState = false
//    var counter = 0
//
//    override fun getAllConditionLogs(): Flow<List<ConditionLog>> {
//        return flow {
//            conditionLogs
//        }
//    }
//
//    override fun getConditionLog(id: Int): Flow<ConditionLog> {
//        return flow {
//            conditionLogs[id]
//        }
//    }
//
//    override fun getLastConditionLog(): Flow<ConditionLog> {
//        return flow {
//            conditionLogs[conditionLogs.size-1]
//        }
//    }
//
//    override suspend fun insertConditionLog(log: ConditionLog) {
//       conditionLogs.add(log)
//    }
//
//    override suspend fun updateConditionLog(log: ConditionLog) {
//        conditionLogs[log.id] = log
//    }
//
//    override suspend fun deleteConditionLog(log: ConditionLog) {
//        conditionLogs.remove(log)
//    }
//
//    override fun getAllLqtrLogs(): Flow<List<LifeQualityTestResultLog>> {
//        return flow {
//            lqtrLogs
//        }
//    }
//
//    override fun getLqtrLog(id: Int): Flow<LifeQualityTestResultLog> {
//        return flow {
//            lqtrLogs[id]
//        }
//    }
//
//    override fun getLastLqtrLog(): Flow<LifeQualityTestResultLog> {
//        return flow {
//            lqtrLogs[lqtrLogs.size-1]
//        }
//    }
//
//    override suspend fun insertLqtrLog(log: LifeQualityTestResultLog) {
//        lqtrLogs.add(log)
//    }
//
//    override suspend fun updateLqtrLog(log: LifeQualityTestResultLog) {
//        lqtrLogs[log.id] = log
//    }
//
//    override suspend fun deleteLqtrLog(log: LifeQualityTestResultLog) {
//        lqtrLogs.remove(log)
//    }
//
//    override suspend fun saveOnOpeningState(completed: Boolean) {
//        openingState = completed
//    }
//
//    override fun readOnOpeningState(): Flow<Boolean> {
//        return flow {
//            openingState
//        }
//    }
//
//    override suspend fun incrementDailyConditionLogCounter() {
//        counter++
//    }
//
//    override suspend fun decrementDailyConditionLogCounter() {
//        TODO("Not yet implemented")
//    }
//
//    override fun readDailyConditionLogCounterValue(): Flow<Int> {
//       return flow {
//           counter
//       }
//    }
//
//    override suspend fun initDailyConditionLogCounter() {
//        counter = 0
//    }
//
//    override suspend fun saveOnWeeklyLifeQualityTestFilling(completed: Boolean) {
//        TODO("Not yet implemented")
//    }
//
//    override fun readOnWeeklyLifeQualityTestFillingState(): Flow<Boolean> {
//        TODO("Not yet implemented")
//    }
//}