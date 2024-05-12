package org.d3if3141.asessment2mobpro.navigation

import org.d3if3141.asessment2mobpro.ui.screen.KEY_ID_PEMINJAMAN
sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")

    data object FormBaru : Screen("detailScreen")

    data object FormUbah : Screen("detailScreen/{$KEY_ID_PEMINJAMAN}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}
