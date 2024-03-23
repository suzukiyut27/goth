package presentation.main

import common.State
import domain.model.ichiba.Items

sealed class MainState : State {
    data object Loading : MainState()
    data class Success(
        val items: Items?,
        val keyword: String
    ) : MainState()

    data class Error(
        val errorMessage: String
    ) : MainState()
}