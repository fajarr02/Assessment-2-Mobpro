package org.d3if3141.asessment2mobpro.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3141.asessment2mobpro.database.PinjamanDao
import org.d3if3141.asessment2mobpro.ui.screen.MainViewModel


class ViewModelFactory(
    private val dao: PinjamanDao
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}
