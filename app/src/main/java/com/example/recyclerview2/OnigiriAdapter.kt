package com.example.recyclerview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//リストに表示させるデータを保持するはViewHolder
// ビューホルダーを管理してリストを画面表示するロジックを担うはAdapter
class OnigiriAdapter(private var onigiriList: ArrayList<Onigiri>) :
    RecyclerView.Adapter<OnigiriAdapter.OnigiriViewHolder>() {

    var onItemClick: ((Onigiri) -> Unit)? = null

    class OnigiriViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textView: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnigiriViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return OnigiriViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnigiriViewHolder, position: Int) {
        val onigiri = onigiriList[position]
        holder.imageView.setImageResource(onigiri.image)
        holder.textName.text = onigiri.name
        holder.textView.text = onigiri.text

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(onigiri)
        }
    }

    override fun getItemCount(): Int {
        return onigiriList.size
    }
}
