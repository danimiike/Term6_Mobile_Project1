package com.example.dmiike.project1daniellemiike

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity(),ListLevelsFragment.SendMessages {
    lateinit var tvStdName : TextView
    lateinit var btnSurvey : Button
    lateinit var btnInstruction: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStdName = findViewById(R.id.tvStdName)
        btnSurvey = findViewById(R.id.btnTakeSurvey)
        btnInstruction = findViewById(R.id.btnInstructions)
    }

    fun onClickSurvey(view: View) {
        val newFragment: DialogFragment? = ListLevelsFragment
            .newInstance(R.string.app_name)
        newFragment!!.show(supportFragmentManager, "dialog")
    }
    fun doPositiveClick() {
        Log.i("ListLevelsFragment", "Positive click!")
    }

    fun doNegativeClick() {
        Log.i("ListLevelsFragment", "Negative click!")
    }

    override fun choiceMade(msg: String?) {
        val tvChoices = findViewById<TextView>(R.id.tvMessage)
        tvChoices.text = "My choice is: $msg"
    }

    fun onClickInstructions(view: View){
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

}