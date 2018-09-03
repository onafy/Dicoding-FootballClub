package onafy.dicoding_footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import onafy.dicoding_footballclub.R
import onafy.dicoding_footballclub.View.ItemListUI
import onafy.dicoding_footballclub.model.Item
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(ItemListUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val Item = items[position]
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView
        var image : ImageView

        init{
            name = itemView.findViewById(ItemListUI.name)
            image = itemView.findViewById(R.id.image)
        }

        fun bindItem(items: Item) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
        }
    }
}



