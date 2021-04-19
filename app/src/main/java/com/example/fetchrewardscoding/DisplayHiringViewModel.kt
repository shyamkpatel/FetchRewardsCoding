package com.example.fetchrewardscoding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardscoding.data.HiringNetworkRepository
import com.example.fetchrewardscoding.model.HiringModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DisplayHiringViewModel : ViewModel() {

    private val hiringRepository by lazy { HiringNetworkRepository(
            ServiceLocator.hiringApiService)
    }

    private val _hiringLiveData by lazy { MutableLiveData<List<HiringModel>>() }
    val hiringLiveData: LiveData<List<HiringModel>> by lazy { _hiringLiveData }

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = hiringRepository.getHiringData()
            withContext(Dispatchers.Main) {
                _hiringLiveData.value = data.filter {
                !it.name.isNullOrEmpty()
            }.sortedWith(compareBy<HiringModel> { it.listId }.thenBy { it.name })
            }
        }
    }
}