package infra.repository.ichiba.item

import domain.model.ichiba.Items
import kotlinx.coroutines.flow.Flow

interface IchibaItemSearchRepository {
    suspend fun getIchibaItemSearch(keyword: String): Flow<Items?>
}