package online.vapcom.themeviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import online.vapcom.themeviewer.ui.ColorsScreen
import online.vapcom.themeviewer.ui.theme.ViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            ViewerTheme(darkTheme = darkTheme) {
                ColorsScreen(onChangeDarkTheme = { darkTheme = !darkTheme })
            }
        }
    }
}
