package com.example.mobilimtahansistemi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobilimtahansistemi.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser != null){
            val intent = Intent(applicationContext, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun signInClicked(view: View){
        var email2 = binding.emailText.text.toString()
        var password2 = binding.emailText.text.toString()

        if(email2.isNotEmpty() && password2.isNotEmpty()){
            auth.signInWithEmailAndPassword(email2, password2).addOnSuccessListener {
                val intent = Intent(applicationContext, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                println(it.localizedMessage)
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Email və Parolu daxil edin", Toast.LENGTH_LONG).show()
        }
    }
    fun signUpClicked(view: View){
        var email1= binding.emailText.text.toString()
        var password1 = binding.passwordText.text.toString()

        if(email1.isNotEmpty() && password1.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email1,password1).addOnSuccessListener {
                val intent = Intent(applicationContext, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, "Email və Parolu daxil edin", Toast.LENGTH_LONG).show()
        }
    }
}