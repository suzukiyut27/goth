package presentation.main

import common.Reducer

class MainReducer : Reducer<MainState, MainAction> {

    override fun reduce(state: MainState?, action: MainAction): MainState {
        return when (action) {
            is MainAction.FetchItems, is MainAction.ReloadData, is MainAction.CancelScope -> {
                state ?: INSTANCE
            }

            is MainAction.FetchItemsSuccess -> {
                state?.copy(
                    items = action.items,
                    keyword = action.keyword,
                    errorMessage = ""
                ) ?: INSTANCE.copy(
                    items = action.items,
                    keyword = action.keyword,
                    errorMessage = ""
                )
            }

            is MainAction.FetchItemsFailure -> {
                state?.copy(
                    errorMessage = action.errorMessage
                ) ?: INSTANCE.copy(
                    errorMessage = action.errorMessage
                )
            }
        }
    }

    companion object {
        private val INSTANCE = MainState(
            null,
            "",
            ""
        )
    }
}