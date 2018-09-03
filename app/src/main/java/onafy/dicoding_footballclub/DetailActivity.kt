package onafy.dicoding_footballclub

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import onafy.dicoding_footballclub.R.id.detail
import onafy.dicoding_footballclub.R.id.name
import onafy.dicoding_footballclub.model.Item
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    //public var items: MutableList<Item> = mutableListOf()
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailActivityUI().setContentView(this)

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

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui) {
            verticalLayout {
                lparams(matchParent, matchParent)
                backgroundColor = Color.WHITE
                padding = dip(17)
                gravity = Gravity.CENTER_HORIZONTAL


                imageView{
                    id = R.id.image
                }.lparams(130, 130)

                textView {
                    id = name
                    textSize = 19f
                }.lparams{
                    height = wrapContent
                    width = wrapContent
                    topMargin = dip(5)
                }


                textView {
                    id = detail
                }.lparams{
                    height = wrapContent
                    width = wrapContent
                    topMargin = dip(20)
                }


            }
        }
    }
}
