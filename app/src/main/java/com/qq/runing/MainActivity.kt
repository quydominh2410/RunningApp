package com.qq.runing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.qq.runing.db.RunDAO
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var runDAO: RunDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("runDao", runDAO.hashCode().toString())

    }
}