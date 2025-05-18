package edu.luqsiyana.pahlawanindonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.luqsiyana.pahlawanindonesia.R
import edu.luqsiyana.pahlawanindonesia.model.Hero

class ListHeroAdapter (private val listHero: ArrayList<Hero>,
            private val onItemCLick:(Hero) -> Unit): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>(){

                private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.txtName.text = name
        holder.txtDesc.text = desc
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClickCallback(listHero[position])
        }

    }

    override fun getItemCount(): Int =listHero.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        var txtName : TextView = itemView.findViewById(R.id.txt_item_name)
        var txtDesc : TextView = itemView.findViewById(R.id.txt_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClickCallback(data: Hero)
    }

}
