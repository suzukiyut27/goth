package presentation.main

import common.Reducer

class MainReducer : Reducer<MainState, MainAction> {

    override val instance: MainState
        get() = MainState.Loading

    override fun reduce(state: MainState?, action: MainAction): MainState {
        return when (action) {
            is MainAction.FetchItems, is MainAction.ReloadData, is MainAction.CancelScope -> {
                state ?: instance
            }

            is MainAction.FetchItemsSuccess -> {
                if (state is MainState.Success) {
                    state.copy(
                        items = action.items,
                        keyword = action.keyword
                    )
                } else {
                    MainState.Success(
                        items = action.items,
                        keyword = action.keyword
                    )
                }
            }

            is MainAction.FetchItemsFailure -> {
                if (state is MainState.Error) {
                    state.copy(
                        errorMessage = action.errorMessage
                    )
                } else {
                    MainState.Error(
                        errorMessage = action.errorMessage
                    )
                }
            }
        }
    }
}