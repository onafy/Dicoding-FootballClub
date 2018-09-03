package onafy.dicoding_footballclub

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import onafy.dicoding_footballclub.adapter.RecyclerViewAdapter
import onafy.dicoding_footballclub.model.Item
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        club_list.layoutManager = LinearLayoutManager( this)
        club_list.adapter = RecyclerViewAdapter(this, items)

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name);
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for(i in name.indices){
            items.add(Item(name[i],
                    image.getResourceId(i,0)))
        }

        //Recycle the typed array
        image.recycle()
    }

}
