package com.example.testdemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testdemo.R

import android.graphics.drawable.Drawable
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.ActionBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.net.URL
import androidx.core.app.NavUtils





class AssignmentOneActivity : AppCompatActivity() {

    private var imageView: ImageView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_one)

        setActionBar()
        initView()
        loadProImage()
    }

    fun initView(){
        imageView = findViewById<ImageView>(R.id.imageView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
    }
    fun loadProImage(){
        val url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmBeuilQBV9xzAlTNhrQp8qnFCGgIOuy-vks7ZEEE4ejtkMrwb3aDhG920ZWWb3wl3L6M&usqp=CAU"
        if (imageView != null) {
// Show progress bar
            // Show progress bar
            progressBar?.setVisibility(View.VISIBLE)
// Hide progress bar on successful load
// Hide progress bar on successful load
            Picasso.with(this).load(R.drawable.groceries)
                .into(imageView, object : Callback {

                    override fun onSuccess() {
                        if (progressBar!=null){
                            progressBar?.setVisibility(View.GONE)
                        }
                    }

                    override fun onError() {
                        if (progressBar!=null){
                            progressBar?.setVisibility(View.GONE)
                        }
                    }
                })
        }
    }

    fun setActionBar() {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            // actionBar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.black)))
            actionBar.setTitle("Assignment One")
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