package hu.bme.aut.it9p0z.fixkin.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.ui.graphics.Color

val light_primary = Color(0xFF27211B)
val light_onPrimary = Color(0xFFffffff)
val light_secondary = Color(0xFFA24D0C)
val light_onSecondary = Color(0xFFffffff)
val light_error = Color(0xFFba1b1b)
val light_onError = Color(0xFFffffff)
val light_background = Color(0xFFfcfcfc)
val light_onBackground = Color(0xFF201a17)
val light_surface = Color(0xFFfcfcfc)
val light_onSurface = Color(0xFF201a17)

val dark_primary = Color(0xFFffb77c)
val dark_onPrimary = Color(0xFF4e2600)
val dark_secondary = Color(0xFFe4c0a7)
val dark_onSecondary = Color(0xFF422c1a)
val dark_error = Color(0xFFffb4a9)
val dark_onError = Color(0xFF680003)
val dark_background = Color(0xFF201a17)
val dark_onBackground = Color(0xFFece0da)
val dark_surface = Color(0xFF201a17)
val dark_onSurface = Color(0xFFece0da)

val Colors.bottomNavBarActionSelected: Color
    get() = if (isLight)  light_secondary else dark_secondary

val Colors.bottomNavBarActionUnselected: Color
    get() = if (isLight)  light_onSecondary else light_onSecondary

val Colors.chipColorSelected: Color
    get() = if(isLight) light_secondary else dark_secondary

val Colors.chipColorUnselected: Color
    get() = if (isLight) Color.LightGray else Color.DarkGray

val Colors.CharColor1: Color
    get() = if (isLight) Color(0xFFF9B9F2) else Color(0xFF380532)

val Colors.CharColor2: Color
    get() = if (isLight) Color(0xFFBCA0BC) else Color(0xFF3C2A3C)

val Colors.CharColor3: Color
    get() = if (isLight) Color(0xFF2B3D41) else Color(0xFF5A7E87)

val Colors.CharColor4: Color
    get() = if (isLight) Color(0xFF4C5F6B) else Color(0xFF93A7B4)

val Colors.CharColor5: Color
    get() = if (isLight) Color(0xFFBCD8C1) else Color(0xFF4B8155)

val Colors.CharColor6: Color
    get() = if (isLight) Color(0xFFA3B18A) else Color(0xFF4B5639)

val Colors.CharColor7: Color
    get() = if (isLight) Color(0xFFDBD56E) else Color(0xFFB4AD2D)

val Colors.CharColor8: Color
    get() = if (isLight) Color(0xFF88AB75) else Color(0xFF557246)

val Colors.CharColor9: Color
    get() = if (isLight) Color(0xFF2D93AD) else Color(0xFF195361)

val Colors.CharColor10: Color
    get() = if (isLight) Color(0xFFAF1B3F) else Color(0xFF580E20)
