package onafy.dicoding_footballclub


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    lateinit var nameView: TextView
    lateinit var detailView: TextView
    lateinit var imgView: ImageView

    private var name: String = ""
    private var image: Int = 0
    private var detail: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ------------------------------------------- UI -----------------------------------------------
        verticalLayout {
            lparams(matchParent, matchParent)
            backgroundColor = Color.WHITE
            padding = dip(17)
            gravity = Gravity.CENTER_HORIZONTAL


            imgView = imageView{
            }.lparams(130, 130)

            nameView = textView {
                textSize = 19f
            }.lparams{
                height = wrapContent
                width = wrapContent
                topMargin = dip(5)
            }


            detailView = textView {
            }.lparams{
                height = wrapContent
                width = wrapContent
                topMargin = dip(20)
            }


        }

        // --------------------------------------- NOT UI -----------------------------------------------
        var intentMain = getIntent()
        name = intentMain.getStringExtra("name")
        detail = intentMain.getStringExtra("detail")
        image = intentMain.getIntExtra("image",0)
        Log.d("LOG", "name extra : "+name)
        Log.d("LOG", "image extra : "+image)

        nameView.text = name
        detailView.text = detail
        Glide.with(this).load(image).into(imgView)


    }

        }
