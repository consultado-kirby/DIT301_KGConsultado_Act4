package com.example.eventpracticeapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)
        val tvError = findViewById<TextView>(R.id.tvError)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageInput = etAge.text.toString().trim()

            try {
                tvError.visibility = TextView.GONE

                if (name.isEmpty() || ageInput.isEmpty()) {
                    tvError.text = getString(R.string.error_fill_fields)
                    tvError.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                    tvError.visibility = TextView.VISIBLE
                    tvOutput.text = ""

                    Toast.makeText(this, getString(R.string.toast_fill_fields), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val age = ageInput.toInt()

                tvError.text = getString(R.string.success_submitted)
                tvError.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
                tvError.visibility = TextView.VISIBLE
                tvOutput.text = getString(R.string.output_text, name, age)

                Toast.makeText(this, getString(R.string.toast_success), Toast.LENGTH_SHORT).show()

            } catch (_: Exception) {
                tvError.text = getString(R.string.error_invalid_age)
                tvError.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                tvError.visibility = TextView.VISIBLE
                tvOutput.text = ""

                Toast.makeText(this, getString(R.string.toast_invalid_age), Toast.LENGTH_SHORT).show()
            }
        }
    }
}