package com.qq.runing.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY timestamp DESC")
    fun getAllRunSortByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY timeInMillis DESC")
    fun getAllRunSortByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY caloriesBurned DESC")
    fun getAllRunSortByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY avgSpeedInKMH DESC")
    fun getAllRunSortByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM RUNNING_TABLE ORDER BY distanceInMeter DESC")
    fun getAllRunSortByDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM RUNNING_TABLE")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM RUNNING_TABLE")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeter) FROM RUNNING_TABLE")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) FROM RUNNING_TABLE")
    fun getTotalAvgSpeed(): LiveData<Float>

}