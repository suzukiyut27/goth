import androidx.compose.ui.window.ComposeUIViewController
import presentation.main.MainScreen
import presentation.main.MainStore

fun MainViewController(store: MainStore) = ComposeUIViewController { MainScreen(store) }