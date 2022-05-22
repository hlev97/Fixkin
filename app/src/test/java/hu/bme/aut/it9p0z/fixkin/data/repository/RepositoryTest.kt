//package hu.bme.aut.it9p0z.fixkin.data.repository
//
//import androidx.lifecycle.asLiveData
//import hu.bme.aut.it9p0z.fixkin.data.model.ConditionLog
//import junit.framework.Assert.assertEquals
//import junit.framework.Assert.assertTrue
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//import java.time.LocalDateTime
//
//class RepositoryTest {
//    private lateinit var repository: FakeRepository
//
//    @Before
//    fun setUp() {
//        repository = FakeRepository(mutableListOf(
//            ConditionLog(
//                1,
//                LocalDateTime.now(),
//                ConditionLog.Feeling.feeling_3,
//                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
//            ), ConditionLog(
//                2,
//                LocalDateTime.now(),
//                ConditionLog.Feeling.feeling_3,
//                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
//            ), ConditionLog(
//                3,
//                LocalDateTime.now(),
//                ConditionLog.Feeling.feeling_3,
//                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
//            )), mutableListOf(
//
//            ))
//    }
//
//
//    @Test
//    fun getAllConditionLogs() = runBlocking {
//        assertEquals(repository.getAllConditionLogs().asLiveData().value!!.size, 3)
//    }
//
//    @Test
//    fun insertConditionLog() = runBlocking {
//        val log = ConditionLog(
//            1,
//            LocalDateTime.now(),
//            ConditionLog.Feeling.feeling_3,
//            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
//        )
//        val beforeInsert = repository.getAllConditionLogs().asLiveData().value
//        repository.insertConditionLog(log)
//        val afterInsert = repository.getAllConditionLogs().asLiveData().value
//        assertEquals(beforeInsert!!.size+1, afterInsert!!.size)
//        assertTrue(afterInsert.contains(log))
//    }
//
//    @Test
//    fun updateConditionLog() {
//
//    }
//
//    @Test
//    fun deleteConditionLog() {
//
//    }
//
//    @Test
//    fun getConditionLog() {
//
//    }
//
//    @Test
//    fun getLastConditionLog() {
//
//    }
//
//    @Test
//    fun getAllLqtrLogs() {
//
//    }
//
//    @Test
//    fun getLqtrLog() {
//
//    }
//
//    @Test
//    fun getLastLqtrLog() {
//    }
//
//    @Test
//    fun insertLqtrLog() {
//    }
//
//    @Test
//    fun updateLqtrLog() {
//    }
//
//    @Test
//    fun deleteLqtrLog() {
//    }
//
//}