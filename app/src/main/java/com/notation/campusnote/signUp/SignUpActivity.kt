package com.notation.campusnote.signUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.notation.campusnote.R
import com.notation.campusnote.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.signUpFrame.id, SignUp1Fragment())
            .commit()
    }
}