package onafy.dicodingfootballclub.View

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import onafy.dicodingfootballclub.R
import org.jetbrains.anko.*

class ItemListUI : AnkoComponent<ViewGroup> {
    companion object {
        const val name = 1
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
                }.lparams{
                    height = wrapContent
                    width = wrapContent
                    margin = dip(16)
                }

            }
        }
    }

