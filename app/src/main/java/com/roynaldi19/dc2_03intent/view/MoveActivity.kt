package com.roynaldi19.dc2_03intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roynaldi19.dc2_03intent.databinding.ActivityMoveBinding

class MoveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}