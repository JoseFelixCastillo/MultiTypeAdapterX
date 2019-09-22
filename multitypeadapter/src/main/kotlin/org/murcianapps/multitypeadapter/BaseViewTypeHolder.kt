package org.murcianapps.multitypeadapter
import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewTypeHolder<T: BaseViewTypeItem, A: ActionView>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun onBind(item: T, callback: (A) -> Unit)
}
