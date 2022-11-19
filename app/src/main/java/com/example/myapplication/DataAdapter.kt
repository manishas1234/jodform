package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.db.UserEntity
import org.w3c.dom.Text


var list = emptyList<UserEntity>()
class DataAdapter(): RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
         val name:TextView
         val email:TextView
         val hobbies:TextView


        init
        {
            name=itemView.findViewById(R.id.tvName)
            email= itemView.findViewById(R.id.tvEmail)
            hobbies=itemView.findViewById(R.id.hobbies)



        }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycl_row, parent, false),
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
             val list = list[position]
        holder.name.text=list.name
        holder.email.text=list.email
        holder.hobbies.text=list.hobbies.toString()



    }

    fun setData(entity: List<UserEntity>) {
        list = entity
        notifyDataSetChanged()
    }

    fun getNoteAt(position: Int): UserEntity {
        return list[position]

    }

    override fun getItemCount(): Int {
        return list.size

    }
}