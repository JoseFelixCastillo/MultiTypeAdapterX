package org.murcianapps.sample

data class HeroesBo(val name: String,
                    val type: TypeHeroe): HomeItem.HomeHeroeItem()

data class GodBo(val name: String,
                 val description: String): HomeItem.HomeGodItem()