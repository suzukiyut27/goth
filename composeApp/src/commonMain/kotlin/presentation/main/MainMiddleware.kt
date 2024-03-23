package presentation.main

import common.Middleware
import infra.repository.ichiba.item.IchibaItemSearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainMiddleware(
    private val ichibaItemSearchRepository: IchibaItemSearchRepository
) : Middleware<MainState, MainAction> {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    override fun apply(state: MainState?, action: MainAction, dispatch: (MainAction) -> Unit) {
        when (action) {
            is MainAction.FetchItems -> {
                coroutineScope.launch {
                    ichibaItemSearchRepository.getIchibaItemSearch(action.keyword)
                        .collect { items ->
                            if (items == null) {
                                dispatch(MainAction.FetchItemsFailure("データの取得ができませんでした。通信環境の良いところで再度お試しください。"))
                            } else {
                                dispatch(MainAction.FetchItemsSuccess(items, action.keyword))
                            }
                        }
                }
            }

            is MainAction.ReloadData -> {
                val mainState = state as? MainState.Success
                if (mainState == null) {
                    dispatch(MainAction.FetchItemsFailure("データの取得ができませんでした。通信環境の良いところで再度お試しください。"))
                    return
                }
                coroutineScope.launch {
                    ichibaItemSearchRepository.getIchibaItemSearch(mainState.keyword)
                        .collect { items ->
                            if (items == null) {
                                dispatch(MainAction.FetchItemsFailure("データの取得ができませんでした。通信環境の良いところで再度お試しください。"))
                            } else {
                                dispatch(
                                    MainAction.FetchItemsSuccess(
                                        items,
                                        mainState.keyword
                                    )
                                )
                            }
                        }
                }
            }

            is MainAction.FetchItemsSuccess, is MainAction.FetchItemsFailure -> {
                // Do nothing
            }

            is MainAction.CancelScope -> {
                coroutineScope.cancel()
            }
        }
    }
}