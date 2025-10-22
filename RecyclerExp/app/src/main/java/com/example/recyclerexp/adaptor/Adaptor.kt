package com.example.recyclerexp.adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerexp.R
import com.example.recyclerexp.SecondActivity
import com.example.recyclerexp.model.ExampleItem
import com.example.recyclerexp.utils.Constants

class ExampleAdaptor(private val context: Context, private val elements: MutableList<ExampleItem>)
    : RecyclerView.Adapter<ExampleAdaptor.ExampleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ExampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = elements[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    inner class ExampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)

        init {
            view.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = elements[position]

                    val intent = Intent(context, SecondActivity::class.java)
                    intent.putExtra(Constants.KEY_TITLE, item.title)
                    intent.putExtra(Constants.KEY_DESCRIPTION, item.description)

                    context.startActivity(intent)
                }
            }
        }

    }
}