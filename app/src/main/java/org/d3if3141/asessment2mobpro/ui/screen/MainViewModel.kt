package org.d3if3141.asessment2mobpro.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3141.asessment2mobpro.database.PinjamanDao
import org.d3if3141.asessment2mobpro.model.Peminjaman

class MainViewModel(dao: PinjamanDao) : ViewModel() {

    val data: StateFlow<List<Peminjaman>> = dao.getPeminjaman().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}
