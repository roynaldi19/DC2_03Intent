package com.roynaldi19.dc2_03intent.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import com.roynaldi19.dc2_03intent.R
import com.roynaldi19.dc2_03intent.databinding.ActivityMoveBinding
import com.roynaldi19.dc2_03intent.databinding.ActivityMoveForResultBinding

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMoveForResultBinding

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChoose.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_choose) {
            if (binding.rgNumber.checkedRadioButtonId > 0) {
                var value = 0
                when (binding.rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}