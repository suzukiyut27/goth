package presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import presentation.common.ProgressIndicator

@Composable
fun MainScreen(store: MainStore) {
    val mainState = store.states.collectAsState(initial = MainState(null, "", "")).value
    MaterialTheme {
        val items = mainState?.items?.items
        if (mainState != null && mainState.errorMessage.isNotBlank()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(mainState.errorMessage)
                    Button(onClick = { store.dispatch(MainAction.ReloadData) }) {
                        Text("Retry")
                    }
                }
            }
        }
        if (items == null) {
            ProgressIndicator(modifier = Modifier)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(items.size) { index ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(8.dp)
                        ) {
                            KamelImage(
                                resource = asyncPainterResource(items[index].mediumImageUrls.lastOrNull()?.imageUrl.orEmpty()),
                                modifier = Modifier.fillMaxSize().aspectRatio(1.5f),
                                contentDescription = null,
                                onLoading = {
                                    CircularProgressIndicator()
                                }
                            )
                            Text(items[index].itemName)
                        }
                    }
                }
            }
        }
    }
}