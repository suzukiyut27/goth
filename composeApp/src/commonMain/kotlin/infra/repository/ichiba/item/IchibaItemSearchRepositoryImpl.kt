package infra.repository.ichiba.item

import domain.model.ichiba.Items
import infra.entity.ichiba.item.ItemsEntity
import infra.mapper.ichiba.IchibaItemMapper
import infra.service.ichiba.IchibaItemService
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IchibaItemSearchRepositoryImpl(
    private val service: IchibaItemService
) : IchibaItemSearchRepository {
    override suspend fun getIchibaItemSearch(keyword: String): Flow<Items?> =
        service
            .getIchibaItemSearch(keyword)
            .map { response ->
                response?.let {
                    val result: ItemsEntity = response.body()
                    IchibaItemMapper.translate(result)
                }
            }

}