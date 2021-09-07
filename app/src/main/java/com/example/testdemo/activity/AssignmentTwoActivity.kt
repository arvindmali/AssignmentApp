package com.example.testdemo.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ProgressBar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testdemo.R
import com.example.testdemo.adapter.AssignmentTwoAdapter
import com.example.testdemo.pojo.MProductDTO
import com.example.testdemo.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AssignmentTwoActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_two)
        setActionBar()
        initView()

        var adapter = AssignmentTwoAdapter(getProductsList(), this)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()

        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun initView(){
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
    }

    fun getProductsList(): ArrayList<MProductDTO>{
        val jsonFileString = Constants().getJsonDataFromAsset(applicationContext,
            "productAsisTwo.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }

        val gson = Gson()
        val listPersonType = object : TypeToken<List<MProductDTO>>() {}.type

        var persons: ArrayList<MProductDTO> = gson.fromJson(jsonFileString, listPersonType)
        persons.forEachIndexed {
                idx,
                person ->
            Log.i("data", "> Item $idx:\n$person")
        }

        return persons
    }

    fun setActionBar() {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            // actionBar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.black)))
            actionBar.setTitle("Assignment Two")
            actionBar.show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                // NavUtils.navigateUpFromSameTask(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}