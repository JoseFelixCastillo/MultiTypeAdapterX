package org.murcianapps.sample

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.heroe_layout.view.*
import org.murcianapps.multitypeadapter.BaseViewTypeHolder

class HomeHeroeViewHolder(view: View): BaseViewTypeHolder<HomeItem, HomeActionView>(view = view) {

    private val tvName: TextView? by lazy { view.heroe__tv__name }
    private val tvType: TextView? by lazy { view.heroe__tv__type }
    private val container: ViewGroup? by lazy { view.heroe__container }

    override fun onBind(item: HomeItem, callback: (HomeActionView) -> Unit) {
        (item as? HeroesBo)?.let { heroeItem ->
            tvName?.text = heroeItem.name
            tvType?.text = heroeItem.type.name
            container?.setOnClickListener { callback(HomeActionView.ItemContentHeroeActionHome(item)) }

        } ?: run {
            container?.setOnClickListener { callback(HomeActionView.None) }
        }

    }
}