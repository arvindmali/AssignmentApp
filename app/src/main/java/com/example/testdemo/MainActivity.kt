package com.example.testdemo

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import com.example.testdemo.activity.AssignmentOneActivity
import com.example.testdemo.activity.AssignmentThreeActivity
import com.example.testdemo.activity.AssignmentTwoActivity

class MainActivity : AppCompatActivity() {

    private var button: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar()
        initView()
        clickListener()
    }

    fun initView(){
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
    }

    fun clickListener(){
        button?.setOnClickListener {
            val intent = Intent(baseContext, AssignmentOneActivity::class.java)
            startActivity(intent)
        }

        button2?.setOnClickListener {
            val intent = Intent(baseContext, AssignmentTwoActivity::class.java)
            startActivity(intent)
        }

        button3?.setOnClickListener {
            val intent = Intent(baseContext, AssignmentThreeActivity::class.java)
            startActivity(intent)
        }
    }

    fun setActionBar() {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(false)
            actionBar.setDisplayShowHomeEnabled(false)
           // actionBar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.black)))
            actionBar.setTitle("Assignments")
            actionBar.show()
        }
    }
}