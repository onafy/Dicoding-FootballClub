package onafy.dicodingfootballclub

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import onafy.dicodingfootballclub.adapter.RecyclerViewAdapter
import onafy.dicodingfootballclub.model.Item
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    var items: MutableList<Item> = mutableListOf()
    private lateinit var clubList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ----------------------------------- UI ------------------------------
        verticalLayout {
            lparams(matchParent, matchParent)
            backgroundColor = Color.WHITE
            clubList = recyclerView {

                lparams(width = matchParent, height = wrapContent)
            }

        }
        //---------------------------------------------------------------------

        initData()
        clubList.layoutManager = LinearLayoutManager( this)
        clubList.adapter = RecyclerViewAdapter(this, items) {
            startActivity<DetailActivity>("name" to it.name, "detail" to it.detail, "image" to it.image)
            Log.d("LOG", "image dikirim : "+it.image)
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name);
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.club_detail)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0), detail[i]))
        }

        //Recycle the typed array
        image.recycle()
    }

}
