package com.example.mobilimtahansistemi

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
    private lateinit var password : String
    private lateinit var email : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        val currentUser = auth.currentUser
    }
    fun signInClicked(view: View){
        email = binding.emailText.text.toString()
        password = binding.emailText.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
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
    fun signUpClicked(view: View){
        email = binding.emailText.text.toString()
        password = binding.passwordText.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
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