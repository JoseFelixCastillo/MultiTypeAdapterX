package org.murcianapps.multitypeadapter

/**
 * Item in adapter
 * @param viewTypeId viewType of item
 */
abstract class BaseViewTypeItem(val viewTypeId: Int = UNKNOWN) {
    companion object {
        const val UNKNOWN = -1
    }
}