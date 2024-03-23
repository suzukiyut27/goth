package presentation.main

import common.State
import domain.model.ichiba.Items

data class MainState(
    val items: Items?,
    val keyword: String,
    val errorMessage: String
) : State