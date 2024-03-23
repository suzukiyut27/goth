package di

import org.koin.dsl.module
import presentation.main.MainMiddleware
import presentation.main.MainReducer
import presentation.main.MainStore

val presentationModule = module {
    single { MainReducer() }
    single { MainStore(get(), get()) }
    single { MainMiddleware(get()) }
}