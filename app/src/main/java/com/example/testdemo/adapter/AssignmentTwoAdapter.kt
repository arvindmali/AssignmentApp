package com.example.testdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testdemo.R
import com.example.testdemo.pojo.MProductDTO
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class AssignmentTwoAdapter (private var items: ArrayList<MProductDTO>, protected var context: Context):
    RecyclerView.Adapter<AssignmentTwoAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var textProductName: TextView? = null
        var txtComment: TextView? = null
        var textMrp: TextView? = null
        var imageView3: ImageView? = null
        var progressBar: ProgressBar? = null
        var textDmartPrice: TextView? = null
        var textSavePrice: TextView? = null
        var textAddToList: TextView?= null

        init {
            this.progressBar = row?.findViewById<ProgressBar>(R.id.progressBar)
            this.imageView3 = row?.findViewById<ImageView>(R.id.imageView3)
            this.textProductName = row?.findViewById<TextView>(R.id.textProductName)
            this.textMrp = row?.findViewById<TextView>(R.id.textMrp)
            this.textDmartPrice = row?.findViewById<TextView>(R.id.textDmartPrice)
            this.textSavePrice = row?.findViewById<TextView>(R.id.textSavePrice)
            this.textAddToList = row?.findViewById<TextView>(R.id.textAddToList)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userDto = items[position]
        if (!userDto.proName.isNullOrEmpty()){
            holder?.textProductName?.text = userDto.proName
        }

        if (!userDto.mrp.isNullOrEmpty()){
            holder?.textMrp?.text = "MRP "+context.getString(R.string.rs)+userDto.mrp
        }

        if (!userDto.dmart.isNullOrEmpty()){
            holder?.textDmartPrice?.text = "DMart "+context.getString(R.string.rs)+""+userDto.dmart
        }

        if (!userDto.save.isNullOrEmpty()){
            holder?.textSavePrice?.text = "Save "+context.getString(R.string.rs)+userDto.save
        }

        val url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmBeuilQBV9xzAlTNhrQp8qnFCGgIOuy-vks7ZEEE4ejtkMrwb3aDhG920ZWWb3wl3L6M&usqp=CAU"
        if (holder?.imageView3 != null) {
// Show progress bar
            // Show progress bar
            holder?.progressBar?.setVisibility(View.VISIBLE)
// Hide progress bar on successful load
// Hide progress bar on successful load
            Picasso.with(context).load(userDto.proImage)//R.drawable.groceries
                .into(holder?.imageView3, object : Callback {

                    override fun onSuccess() {
                        if (holder?.progressBar!=null){
                           holder?.progressBar?.setVisibility(View.GONE)
                        }
                    }

                    override fun onError() {
                        if (holder?.progressBar!=null){
                           holder?.progressBar?.setVisibility(View.GONE)
                            holder?.imageView3!!.setImageResource(R.drawable.groceries)
                        }
                    }
                })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.activity_assignment_two_item, parent, false)

        return ViewHolder(itemView)
    }
}