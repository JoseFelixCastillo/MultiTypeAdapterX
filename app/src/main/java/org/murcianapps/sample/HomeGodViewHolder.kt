package org.murcianapps.sample

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.god_layout.view.*
import org.murcianapps.multitypeadapter.BaseViewTypeHolder

class HomeGodViewHolder(view: View): BaseViewTypeHolder<HomeItem, HomeActionView>(view = view) {

    private val tvName: TextView? by lazy { view.god__tv__name }
    private val tvType: TextView? by lazy { view.god__tv__type }
    private val container: ViewGroup? by lazy { view.god__container }

    override fun onBind(item: HomeItem, callback: (HomeActionView) -> Unit) {
        (item as? GodBo)?.let { godItem ->
            tvName?.text = godItem.name
            tvType?.text = godItem.description
            container?.setOnClickListener {
                if ("Zeus" == godItem.name) {  //Por poner un ejemplo de devolver el callback adecuado
                    callback(HomeActionView.ShowLogActionHome)

                } else {
                    callback(HomeActionView.ItemContentGodActionHome(godItem))
                }
            }

        } ?: run {
            container?.setOnClickListener { callback(HomeActionView.None) }
        }

    }


}