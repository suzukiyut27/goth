package common

interface Middleware<S : State, A : Action> {
    fun apply(state: S?, action: A, dispatch: (A) -> Unit)
}