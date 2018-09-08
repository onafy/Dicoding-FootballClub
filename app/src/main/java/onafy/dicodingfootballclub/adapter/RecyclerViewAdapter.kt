package onafy.dicodingfootballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import onafy.dicodingfootballclub.R
import onafy.dicodingfootballclub.View.ItemListUI
import onafy.dicodingfootballclub.model.Item
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>,  val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(ItemListUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView
        var image : ImageView

        init{
            name = itemView.findViewById(ItemListUI.name)
            image = itemView.findViewById(R.id.image)
        }

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.setOnClickListener {
                listener(items)
            }

        }
    }
}



