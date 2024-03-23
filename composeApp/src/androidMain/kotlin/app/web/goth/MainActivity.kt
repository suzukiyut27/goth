package app.web.goth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import di.startKoin
import org.koin.java.KoinJavaComponent.inject
import presentation.main.MainAction
import presentation.main.MainScreen
import presentation.main.MainStore

class MainActivity : ComponentActivity() {

    private val store: MainStore by inject(MainStore::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin()
        store.dispatch(MainAction.FetchItems("楽天"))
        setContent {
            MainScreen(store)
        }
    }

    override fun onDestroy() {
        store.dispatch(MainAction.CancelScope)
        super.onDestroy()
    }
}