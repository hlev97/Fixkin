package hu.bme.aut.it9p0z.fixkin.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF27211B)
val md_theme_light_onPrimary = Color(0xFFffffff)
val md_theme_light_secondary = Color(0xFFA24D0C)
val md_theme_light_onSecondary = Color(0xFFffffff)
val md_theme_light_error = Color(0xFFba1b1b)
val md_theme_light_onError = Color(0xFFffffff)
val md_theme_light_background = Color(0xFFfcfcfc)
val md_theme_light_onBackground = Color(0xFF201a17)
val md_theme_light_surface = Color(0xFFfcfcfc)
val md_theme_light_onSurface = Color(0xFF201a17)

val md_theme_dark_primary = Color(0xFFffb77c)
val md_theme_dark_onPrimary = Color(0xFF4e2600)
val md_theme_dark_secondary = Color(0xFFe4c0a7)
val md_theme_dark_onSecondary = Color(0xFF422c1a)
val md_theme_dark_error = Color(0xFFffb4a9)
val md_theme_dark_onError = Color(0xFF680003)
val md_theme_dark_background = Color(0xFF201a17)
val md_theme_dark_onBackground = Color(0xFFece0da)
val md_theme_dark_surface = Color(0xFF201a17)
val md_theme_dark_onSurface = Color(0xFFece0da)

val Colors.bottomNavBarActionSelected: Color
    get() = if (isLight)  md_theme_light_secondary else md_theme_dark_secondary

val Colors.bottomNavBarActionUnselected: Color
    get() = if (isLight)  md_theme_light_onSecondary else md_theme_light_onSecondary

val Colors.chipColorSelected: Color
    get() = if(isLight) md_theme_light_secondary else md_theme_dark_secondary

val Colors.chipColorUnselected: Color
    get() = if (isLight) Color.LightGray else Color.DarkGray
