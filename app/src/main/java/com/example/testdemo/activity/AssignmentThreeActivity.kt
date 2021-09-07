package com.example.testdemo.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ProgressBar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.testdemo.R
import com.example.testdemo.adapter.AssignmentThreeAdapter
import com.example.testdemo.pojo.MProductDTO
import com.example.testdemo.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import androidx.recyclerview.widget.*
import com.example.testdemo.pojo.MProductCatDTO


class AssignmentThreeActivity : AppCompatActivity() {

    private var noOfGrid: Int = 3
    private var progressBar: ProgressBar? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_two)
        setActionBar()
        initView()

        var adapter = AssignmentThreeAdapter(getProductsList(), this)
       // val layoutManager = LinearLayoutManager(applicationContext)


        val layoutManager = GridLayoutManager(applicationContext, noOfGrid)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.addItemDecoration(
            DividerItemDecoration(applicationContext,
                DividerItemDecoration.HORIZONTAL)
        )
        recyclerView?.addItemDecoration(
            DividerItemDecoration(applicationContext,
                DividerItemDecoration.VERTICAL)
        )
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun initView(){
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
    }

    fun getProductsList(): ArrayList<MProductDTO>{
        val jsonFileString = Constants().getJsonDataFromAsset(applicationContext,
            "productCategoryJson.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }

        val gson = Gson()
        val listPersonType = object : TypeToken<MProductCatDTO>() {}.type

        var products: MProductCatDTO = gson.fromJson(jsonFileString,
            listPersonType)

        if (products.noOfGrid>0){
            noOfGrid = products.noOfGrid
        } else{
            noOfGrid = 3
        }
       /* persons.forEachIndexed {
                idx,
                person ->
            Log.i("data", "> Item $idx:\n$person")
        }*/

        return products.proItem
    }

    fun setActionBar() {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            // actionBar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.black)))
            actionBar.setTitle("Assignment Three")
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