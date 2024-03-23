package infra

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> runApiCall(
    apiCall: suspend () -> T
): Flow<T?> {
    return flow {
        try {
            emit(apiCall())
        } catch (e: Exception) {
            emit(null)
        }
    }
}