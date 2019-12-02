package com.example.like

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {

    var like: Int = 0
    var dislike: Int = 0
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getPreferences(Context.MODE_PRIVATE)
        Log.d("MainActivity","onCreate")
        buttoncall.setOnClickListener(){
            val phone = "tel:0123456789"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(phone))
            if(intent.resolveActivity(packageManager)!= null){
                startActivity(intent)
            }else{
                //Download la sohai
            }


        }
    }


    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")
        with(preferences.edit()){
            putInt(getString(R.string.like),like)
            putInt(getString(R.string.dislike),dislike)
            commit()
        }
        super.onPause()
    }

    override fun onResume() {
        like = preferences.getInt(getString(R.string.like),0)
        dislike = preferences.getInt(getString(R.string.dislike),0)
        liketxt.text = like.toString()
        disliketxt.text = dislike.toString()
        imageViewUp.setOnClickListener(){
            like++
            liketxt.text = like.toString()
        }
        imageViewDown.setOnClickListener(){
            dislike++
            disliketxt.text = dislike.toString()
        }
        Log.d("MainActivity","onResume")
        super.onResume()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }

}
