package onafy.dicoding_footballclub

import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import onafy.dicoding_footballclub.View.ItemListUI.Companion.name
import onafy.dicoding_footballclub.model.Item

class DetailActivity : AppCompatActivity() {
    //public var items: MutableList<Item> = mutableListOf()
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intentMain = getIntent()
        if(intentMain.hasExtra(Intent.EXTRA_TEXT)){
             position = intentMain.getStringExtra(Intent.EXTRA_TEXT).toInt()
           }
        val nameclub = resources.getStringArray(R.array.club_name);
        val imageclubb = resources.getStringArray(R.array.club_image)
        val imageclub = resources.obtainTypedArray(R.array.club_image)
        val detailclub = resources.getStringArray(R.array.club_detail)

        name.text = nameclub[position]
        image.setImageResource(imageclub.getResourceId(position, -1));
        detail.text = detailclub[position]


    }
}
