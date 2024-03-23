package common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged

abstract class Store<S : State, A : Action>(
    private val middleware: Middleware<S, A>,
    private val reducer: Reducer<S, A>
) {
    private val _state: MutableSharedFlow<S?> = MutableSharedFlow(
        replay = 1,
        extraBufferCapacity = 0
    )
    val states: Flow<S?> get() = _state.distinctUntilChanged()

    fun dispatch(action: A) {
        middleware.apply(_state.replayCache.firstOrNull(), action) {
            val newState = reducer.reduce(_state.replayCache.firstOrNull(), it)
            _state.tryEmit(newState)
        }
    }
}