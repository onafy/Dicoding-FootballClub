package onafy.dicoding_footballclub.View

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import onafy.dicoding_footballclub.R
import org.jetbrains.anko.*

class ItemListUI : AnkoComponent<ViewGroup> {
    companion object {
        val name = 1
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
            verticalLayout {
                lparams(matchParent, wrapContent)
                padding = dip(16)

                imageView{
                    id = R.id.image
                }.lparams(50, 50)

                textView {
                    id = name
                    text = "Liverpool FC"
                }.lparams{
                    height = wrapContent
                    width = wrapContent
                    margin = dip(16)
                }

            }
        }
    }

