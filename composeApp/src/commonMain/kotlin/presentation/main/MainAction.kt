package presentation.main

import common.Action
import domain.model.ichiba.Items

sealed interface MainAction : Action {
    data class FetchItems(val keyword: String) : MainAction
    data class FetchItemsSuccess(val items: Items, val keyword: String) : MainAction
    data class FetchItemsFailure(val errorMessage: String) : MainAction
    data object ReloadData : MainAction

    data object CancelScope : MainAction
}