package org.murcianapps.sample

import org.murcianapps.multitypeadapter.ActionView

/**
 * Implements many actions like you want
 */
sealed class HomeActionView: ActionView() {
    data class ItemContentGodActionHome(val item: GodBo): HomeActionView()
    data class ItemContentHeroeActionHome(val item: HeroesBo): HomeActionView()
    object ShowLogActionHome: HomeActionView()
    object None: HomeActionView() //For do nothing for example
}