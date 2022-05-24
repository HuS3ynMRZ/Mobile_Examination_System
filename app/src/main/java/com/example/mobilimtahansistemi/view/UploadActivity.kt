package com.example.mobilimtahansistemi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobilimtahansistemi.databinding.ActivityUploadBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var storage: FirebaseStorage
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth

        auth = Firebase.auth
        firestore = Firebase.firestore
        storage = Firebase.storage
    }
    fun upload(view: View){

        val postMap = hashMapOf<String,Any>()
        postMap.put("userEmail", auth.currentUser!!.email.toString()!!)
        postMap.put("sual1",binding.commentText.text.toString())
        postMap.put("sual2",binding.commentText2.text.toString())
        postMap.put("sual3",binding.commentText3.text.toString())

        firestore.collection("Posts").add(postMap).addOnSuccessListener {
            finish()
        }.addOnFailureListener{
            Toast.makeText(this,it.localizedMessage, Toast.LENGTH_LONG)
        }
    }
}