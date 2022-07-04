package online.vapcom.themeviewer.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness6
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import online.vapcom.themeviewer.ui.theme.ViewerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorsScreen(onChangeDarkTheme: () -> Unit, modifier: Modifier = Modifier) {

    val colorSamples = listOf(
        ColorSampleDescription("Primary", MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.onPrimary),
        ColorSampleDescription("On Primary", MaterialTheme.colorScheme.onPrimary, MaterialTheme.colorScheme.primary),
        ColorSampleDescription("Secondary", MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.onSecondary),
        ColorSampleDescription("On Secondary", MaterialTheme.colorScheme.onSecondary, MaterialTheme.colorScheme.secondary),
        ColorSampleDescription("Tertiary", MaterialTheme.colorScheme.tertiary, MaterialTheme.colorScheme.onTertiary),
        ColorSampleDescription("On Tertiary", MaterialTheme.colorScheme.onTertiary, MaterialTheme.colorScheme.tertiary),
        ColorSampleDescription("Error", MaterialTheme.colorScheme.error, MaterialTheme.colorScheme.onError),
        ColorSampleDescription("On Error", MaterialTheme.colorScheme.onError, MaterialTheme.colorScheme.error),
        ColorSampleDescription("Background", MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.onBackground),
        ColorSampleDescription("On Background", MaterialTheme.colorScheme.onBackground, MaterialTheme.colorScheme.background),
        ColorSampleDescription("Primary Container", MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.onPrimaryContainer),
        ColorSampleDescription("On Primary Container", MaterialTheme.colorScheme.onPrimaryContainer, MaterialTheme.colorScheme.primaryContainer),
        ColorSampleDescription("Secondary Container", MaterialTheme.colorScheme.secondaryContainer, MaterialTheme.colorScheme.onSecondaryContainer),
        ColorSampleDescription("On Secondary Container", MaterialTheme.colorScheme.onSecondaryContainer, MaterialTheme.colorScheme.secondaryContainer),
        ColorSampleDescription("Tertiary Container", MaterialTheme.colorScheme.tertiaryContainer, MaterialTheme.colorScheme.onTertiaryContainer),
        ColorSampleDescription("On Tertiary Container", MaterialTheme.colorScheme.onTertiaryContainer, MaterialTheme.colorScheme.tertiaryContainer),
        ColorSampleDescription("Error Container", MaterialTheme.colorScheme.errorContainer, MaterialTheme.colorScheme.onErrorContainer),
        ColorSampleDescription("On Error Container", MaterialTheme.colorScheme.onErrorContainer, MaterialTheme.colorScheme.errorContainer),
        ColorSampleDescription("Surface", MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.onSurface),
        ColorSampleDescription("On Surface", MaterialTheme.colorScheme.onSurface, MaterialTheme.colorScheme.surface),
        ColorSampleDescription("Surface-Variant", MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.colorScheme.onSurfaceVariant),
        ColorSampleDescription("On Surface-Variant", MaterialTheme.colorScheme.onSurfaceVariant, MaterialTheme.colorScheme.surfaceVariant),
        ColorSampleDescription("Outline", MaterialTheme.colorScheme.outline, MaterialTheme.colorScheme.onBackground)
    )

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("M3 Theme Viewer") },
                actions = {
                    IconButton(onClick = onChangeDarkTheme) {
                        Icon(
                            imageVector = Icons.Filled.Brightness6,
                            contentDescription = "Switch theme"
                        )
                    }
                }
            )
        }
    ) { paddings ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            modifier = modifier
                .fillMaxSize()
                .padding(paddings)
        ) {
            items(count = colorSamples.size) { index ->
                ColorSample(desc = colorSamples[index])
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Colors Screen Light")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Colors Screen Dark")
@Composable
fun ColorsScreenPreview() {
    ViewerTheme {
        ColorsScreen( {} )
    }
}

data class ColorSampleDescription (
    val name: String,
    val color: Color,       // sample rectangle's color
    val onColor: Color      // name's color
)

@Composable
fun ColorSample(desc: ColorSampleDescription, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .padding(4.dp)
        .height(72.dp)
        .background(desc.color)) {
        Text(
            text = desc.name,
            color = desc.onColor,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        )
    }
}
