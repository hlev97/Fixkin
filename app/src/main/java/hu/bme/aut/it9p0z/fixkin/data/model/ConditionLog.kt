package hu.bme.aut.it9p0z.fixkin.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "condition_logs")
data class ConditionLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
