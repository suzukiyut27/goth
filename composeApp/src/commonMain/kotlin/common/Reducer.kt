package common

interface Reducer<S : State, A : Action> {
    val instance: S

    fun reduce(state: S?, action: A): S?
}