package org.murcianapps.sample

import android.view.View
import org.murcianapps.multitypeadapter.BaseViewTypeAdapter
import org.murcianapps.multitypeadapter.BaseViewTypeHolder

class HomeAdapter(itemList: MutableList<HomeItem>, callback: (HomeActionView) -> Unit): BaseViewTypeAdapter<HomeItem, BaseViewTypeHolder<HomeItem, HomeActionView>, HomeActionView>(itemList = itemList, callback = callback) {

    override fun getHolder(viewType: Int, view: View): BaseViewTypeHolder<HomeItem, HomeActionView> {
        return when (viewType) {
            HomeItem.ViewType.TYPE_GOD.type -> HomeGodViewHolder(view)
            HomeItem.ViewType.TYPE_HEROE.type -> HomeHeroeViewHolder(view)
            else ->  HomeHeroeViewHolder(view) //Normally try to use a empty viewHolder or error case
        }
    }

    override fun getLayoutResourceIdByViewType(viewType: Int): Int {
        return when (viewType) {
            HomeItem.ViewType.TYPE_GOD.type -> R.layout.god_layout
            HomeItem.ViewType.TYPE_HEROE.type -> R.layout.heroe_layout
            else ->  R.layout.god_layout //Error case like empty layout
        }
    }
}