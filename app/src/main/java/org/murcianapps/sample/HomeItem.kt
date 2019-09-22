package org.murcianapps.sample

import org.murcianapps.multitypeadapter.BaseViewTypeItem


//Other form is with private const or with companion object inside homeItem
/*private const val TYPE_HEADER = 1
private const val TYPE_CONTENT = 2*/

sealed class HomeItem(viewType: Int): BaseViewTypeItem(viewType) {
    enum class ViewType(val type: Int){
        TYPE_HEROE(1),
        TYPE_GOD(2)
    }

    open class HomeHeroeItem: HomeItem(ViewType.TYPE_HEROE.type) //Open if you want to inherit in another class or without open if you preffer a wrapper
    open class HomeGodItem: HomeItem(ViewType.TYPE_GOD.type)
}