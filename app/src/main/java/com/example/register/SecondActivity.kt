package com.example.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.register.MainActivity.Companion.EXTRA_EMAIL
import com.example.register.MainActivity.Companion.EXTRA_PASSWORD
import com.example.register.MainActivity.Companion.EXTRA_PHONE
import com.example.register.MainActivity.Companion.EXTRA_USERNAME
import com.example.register.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        with(binding) {
            //menetapkan text di TextView
            txtWelcome.text = "Hello $username"
            txtEmail.text = "Your $email has been activated"
            txtPhone.text = "Your $phone has been registered"

            //ketika btnLogout diklik
            btnLogout.setOnClickListener {
                //untuk mengembalikan ke tampilan awal atau MainActivity
                val intent = Intent(this@SecondActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}