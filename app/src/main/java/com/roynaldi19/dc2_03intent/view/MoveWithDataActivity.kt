package com.roynaldi19.dc2_03intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.roynaldi19.dc2_03intent.R
import com.roynaldi19.dc2_03intent.databinding.ActivityMoveBinding
import com.roynaldi19.dc2_03intent.databinding.ActivityMoveWithDataBinding

class MoveWithDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveWithDataBinding

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithDataBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name, Your Age : $age"
        binding?.tvDataReceived?.text = text
    }
}