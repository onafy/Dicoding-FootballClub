package onafy.dicoding_footballclub.View

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import onafy.dicoding_footballclub.R
import org.jetbrains.anko.*

class ItemListUI : AnkoComponent<ViewGroup> {
    companion object {
        val name = 1
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
            verticalLayout {
                orientation = LinearLayout.HORIZONTAL
                backgroundColor = Color.WHITE
                lparams(matchParent, wrapContent)
                padding = dip(16)

                imageView{
                    id = R.id.image
                }.lparams(100, 100)

                textView {
                    id = name
                    backgroundColor = Color.WHITE
                    text = "Liverpool FC"
                }.lparams{
                    height = wrapContent
                    width = wrapContent
                    margin = dip(16)
                }

            }
        }
    }

