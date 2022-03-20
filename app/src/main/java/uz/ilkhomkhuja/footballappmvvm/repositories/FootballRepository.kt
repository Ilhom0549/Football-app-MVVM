package uz.ilkhomkhuja.footballappmvvm.repositories

import kotlinx.coroutines.flow.flow
import uz.ilkhomkhuja.footballappmvvm.network.ApiService

class FootballRepository(private val apiService: ApiService) {

    suspend fun getAllLeagues() = flow { emit(apiService.getAllLeagues()) }

    suspend fun getItemFootballClub(id: String) = flow { emit(apiService.getItemFootballClub(id)) }
}