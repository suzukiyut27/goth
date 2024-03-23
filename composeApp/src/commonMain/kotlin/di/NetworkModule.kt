package di

import infra.service.ichiba.IchibaItemService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module

@OptIn(ExperimentalSerializationApi::class)
val httpClientModule = module {
    single {
        HttpClient {
            install(Logging)
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                        explicitNulls = false
                        prettyPrint = false
                        isLenient = false
                        encodeDefaults = true
                        allowSpecialFloatingPointValues = true
                        allowStructuredMapKeys = true
                        useArrayPolymorphism = false
                    }
                )
            }
        }
    }
    single { IchibaItemService(get()) }
}