package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myName : MyName = MyName("Geraldine Vilamil")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        binding.button.setOnClickListener {
            addNickName(it)
        }

    }

    fun addNickName(view : View){


        binding.apply {
            //nickName.text = binding.editText.text
            myName?.nickName = editText.text.toString()
            invalidateAll()
            editText.visibility = View.GONE
            view.visibility = View.GONE
            nickName.visibility = View.VISIBLE
        }



        //hide keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }
}
