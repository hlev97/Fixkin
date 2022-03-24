package hu.bme.aut.it9p0z.fixkin.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = GoldFusion700,
    primaryVariant = GoldFusion900,
    onPrimary = OnGoldFusion700,
    secondary = Independece700,
    secondaryVariant = Independece900,
    onSecondary = OnIndependece700,
    surface = GoldFusion700,
    onSurface = OnGoldFusion700,
    background = BackgroundDark,
    onBackground = BackgroundLight
)

private val LightColorPalette = lightColors(
    primary = GoldFusion200,
    primaryVariant = GoldFusion500,
    onPrimary = OnGoldFusion200,
    secondary = Independece200,
    secondaryVariant = Independece500,
    onSecondary = OnIndependence200,
    surface = GoldFusion200,
    onSurface = OnGoldFusion200,
    background = BackgroundLight,
    onBackground = BackgroundDark
)

@Composable
fun FixkinTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}