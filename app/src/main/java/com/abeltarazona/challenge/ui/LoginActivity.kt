package com.abeltarazona.challenge.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abeltarazona.challenge.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val user = binding.tfvUser.getContent()
            val pass = binding.tfvPassword.getContent()

            if (user == "Admin" && pass == "Password*123") {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
            }

        }


    }
}

/*
https://mail-attachment.googleusercontent.com/attachment/u/1/?ui=2&ik=3e535b6ccb&attid=0.1&permmsgid=msg-f:1698789730629299020&th=179350426a3dab4c&view=att&disp=inline&saddbat=ANGjdJ_-eEI4WDn4p6W6crk6o-b97v1SEkufYJE48eymeApbDgK_poX-dfsNHuudNRTJiYavoeqUbk2axJo_go9hlNjNgk9aChuQRO0b22GcP3lqbh3uA8age0HQl0SRXFaIvH-lfjrZGwY7WiRaNCEnWkRWPypFs4JwjyQCeHtCJZD3m6utgjVGXrG4PvVPNHp3kuDlIzP8GOj_iC-f7Dn-pA1SgzT-qzNCPes4JOpZDNd_5iwlFoxSHsvUaBA52JxcKOKtzReonTKcRHaOoE_ni5z4-qkiw3UabHMjhYPwRg3yX7jCLYGO6bXhkNsq-uwdyiB0M8PIVv0oNVDnbNaP8KKgmKdkdZnW24FxoeyCPNMGAhzjyjAzOLwmln90aklYq0s_xoJG-UQ54BTA9aAFiEvjwASvUvYGJ8cBX3T6J9LcZOLLNQbkLvHmckakteET4Yv2woYMTDAqaq7rY25LcgpnYtX4uSDEpCIp1KnHZy0_GZ-xhXRJiL9t_Bxs4F6oVwWQAiryYm5xS7keI4wYSFREqtsrGXy7jtyJI2HWdQszkUTXbFNITUhuGnqIUorK25CzvDxIrJCSSSSLAuXaUqcademc4ONxpRnab9_vyyJ1wYx1RAIvW_Gi_XnLp3qajYzoYs-7Bha6Q6hFkGmBUY89dMRY_qh78VUKTtHqNc9TsD1h1kpEqmgtQJM
https://cdn.dribbble.com/users/1720295/screenshots/15174993/media/c8a940f07901ea40935f549cd8ae2af8.png
https://dribbble.com/shots/15258922-Cinema-App-P2
 */