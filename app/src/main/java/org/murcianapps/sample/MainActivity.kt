package org.murcianapps.sample

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.main_activity__rv
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val rvMain: RecyclerView? by lazy { main_activity__rv }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    private fun initRecycler() {
        rvMain?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = createAdapter()
            addItemDecoration(createItemDecoration())
        }
    }

    private fun createItemDecoration(): RecyclerView.ItemDecoration {
        return object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)

                val itemPosition = parent.getChildAdapterPosition(view)

                if (itemPosition > 0) {
                    outRect.bottom = 30
                }
            }
        }
    }

    private fun createList(): List<HomeItem> {
        return listOf(
            HeroesBo("Goku", TypeHeroe.CHUCK_NORRIS),
            HeroesBo("Aquaman", TypeHeroe.MENUDO_PAQUETE),
            GodBo("Zeus", "El que tira rayos"),
            GodBo("Hades", "Acho que te mata"),
            HeroesBo("Bruce Harper", TypeHeroe.MEHHHHH),
            GodBo("Jisus", "Paz y amor"),
            HeroesBo("David Hasselhof", TypeHeroe.TE_REVIENTA),
            GodBo("Tina Turner", "Te canta una saeta"),
            HeroesBo("Luffy", TypeHeroe.TE_REVIENTA),
            GodBo("Espinete", "Acho que te pincho")
        )
    }

    private fun createAdapter(): HomeAdapter {
        val list = createList()
        return HomeAdapter(itemList = list.toMutableList(), callback = { action ->
            //Try to use this case in viewModel or presenter
            when (action) {
                HomeActionView.ShowLogActionHome -> {
                    toast("El hate coding dominará el mundo")
                }

                is HomeActionView.ItemContentGodActionHome -> {
                    toast("titan: " + action.item.name)
                }

                is HomeActionView.ItemContentHeroeActionHome -> {
                    toast("mastodonte: " + action.item.name)
                }
                else -> {
                    toast("espero haberte ayudado")
                }
            }
        })
    }
}
