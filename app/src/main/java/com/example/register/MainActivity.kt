package com.example.register

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.register.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifeCycle"

    //buat binding dulu
    private lateinit var binding : ActivityMainBinding

    //untuk mengirim data dr activity1 ke activity2 harus membuat key
    //dimana key ini akan mengidentifikasi data yang dikirimkan
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            //menetapkan btnRegister OnClickListener
            btnRegister.setOnClickListener {
                val intentToSecondActivity =
                    Intent(this@MainActivity, SecondActivity::class.java)

                //untuk meamnggil data yg dikirimkan dr MainActivity ke SecondActivity
                //menggunakan Intent dengan kunci EXTRA
                val username = editTxtUsername.text.toString()
                intentToSecondActivity.putExtra(EXTRA_USERNAME,username)

                val email = editTxtEmail.text.toString()
                intentToSecondActivity.putExtra(EXTRA_EMAIL,email)

                val phone = editTxtPhone.text.toString()
                intentToSecondActivity.putExtra(EXTRA_PHONE,phone)

                val password = editTxtPassword.text.toString()
                intentToSecondActivity.putExtra(EXTRA_PASSWORD,password)

                startActivity(intentToSecondActivity)
            }
        }

        Log.d(TAG, "inCreate dipanggil")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy dipanggil")
    }
}