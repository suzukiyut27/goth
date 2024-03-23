package infra.service.ichiba

import app.web.goth.BuildKonfig
import infra.runApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath

class IchibaItemService(
    private val httpClient: HttpClient
) {
    suspend fun getIchibaItemSearch(keyword: String) = runApiCall {
        httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = BuildKonfig.RAKUTEN_API_HOST
                encodedPath = "services/api/IchibaItem/Search/20220601"
                parameters.append("format", "json")
                parameters.append("applicationId", BuildKonfig.APPLICATION_ID)
                parameters.append("keyword", keyword)
            }
        }
    }
}