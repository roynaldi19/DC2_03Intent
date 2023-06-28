package com.roynaldi19.dc2_03intent.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.roynaldi19.dc2_03intent.databinding.ActivityMainBinding
import com.roynaldi19.dc2_03intent.model.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            binding.tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMoveActivity.setOnClickListener(this)
        binding.btnMoveActivityData.setOnClickListener(this)
        binding.btnMoveActivityObject.setOnClickListener(this)
        binding.btnDialNumber.setOnClickListener(this)
        binding.btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.btnMoveActivity.id -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            binding.btnMoveActivityData.id -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Roynaldi")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 29)
                startActivity(moveWithDataIntent)
            }

            binding.btnMoveActivityObject.id -> {
                val person = Person(
                    "Roynaldi",
                    29,
                    "roynaldi19@gmail.com",
                    "Pekanbaru"
                )
                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            binding.btnDialNumber.id -> {
                val phoneNumber = "082391613400"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            binding.btnMoveForResult.id -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }

}