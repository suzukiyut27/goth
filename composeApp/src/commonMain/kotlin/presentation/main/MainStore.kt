package presentation.main

import common.Store

data class MainStore(
    val middleware: MainMiddleware,
    val reducer: MainReducer
) : Store<MainState, MainAction>(middleware, reducer)