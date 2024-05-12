package org.d3if3141.asessment2mobpro.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")

    data object FormBaru : Screen("detailScreen")
}
