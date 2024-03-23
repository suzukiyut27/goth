package di

import infra.repository.ichiba.item.IchibaItemSearchRepository
import infra.repository.ichiba.item.IchibaItemSearchRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<IchibaItemSearchRepository> { IchibaItemSearchRepositoryImpl(get()) }
}