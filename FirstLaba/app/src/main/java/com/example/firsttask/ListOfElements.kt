package com.example.firsttask

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class DataAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return 1000000;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if ((position + 1) % 2 == 0 ) {
            holder?.layout?.setBackgroundColor(Color.DKGRAY)
        }
        else {
            holder?.layout?.setBackgroundColor(Color.LTGRAY)
        }
        holder?.text?.text = IntRetranslator.retranslate(position + 1L);
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val layout: LinearLayout = view.findViewById<LinearLayout>(R.id.item_layout);
    val text: TextView = view.findViewById<TextView>(R.id.text_view)
}


class ListOfElements : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_elements)
        val recView = findViewById<RecyclerView>(R.id.recycler_view)
        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter = DataAdapter(this)
    }
}
