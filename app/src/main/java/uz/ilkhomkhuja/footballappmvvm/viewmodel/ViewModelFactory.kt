package uz.ilkhomkhuja.footballappmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.ilkhomkhuja.footballappmvvm.repositories.FootballRepository
import uz.ilkhomkhuja.footballappmvvm.utils.NetworkHelper

class ViewModelFactory(
    private val footballRepository: FootballRepository,
    private val networkHelper: NetworkHelper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FootballViewModel::class.java)) {
            return FootballViewModel(footballRepository, networkHelper) as T
        }
        throw IllegalArgumentException("Error")
    }
}