package di

import org.koin.core.context.startKoin

fun startKoin() = startKoin {
    modules(appModule())
}