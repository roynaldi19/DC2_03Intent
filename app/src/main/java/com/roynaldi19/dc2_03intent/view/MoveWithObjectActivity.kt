package com.roynaldi19.dc2_03intent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.roynaldi19.dc2_03intent.R
import com.roynaldi19.dc2_03intent.databinding.ActivityMoveWithDataBinding
import com.roynaldi19.dc2_03intent.databinding.ActivityMoveWithObjectBinding
import com.roynaldi19.dc2_03intent.model.Person

class MoveWithObjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveWithObjectBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
        binding.tvObjectReceived.text = text
    }
}