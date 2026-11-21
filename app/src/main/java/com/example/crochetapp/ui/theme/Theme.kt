package com.example.crochetapp.ui.theme

//imports
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//colours and colours of text on top
private val CrochetColours = lightColorScheme(
    primary = Willow,
    onPrimary = Color.Black,
    secondary = Oleander,
    onSecondary = Color.Black,
    tertiary = TeaRose,
    background = Jasmine,
    onBackground = Color.Black,
    surface = Jasmine,
    onSurface = Color.Black,
    surfaceVariant = Primula,
    onSurfaceVariant = Color.DarkGray
)
//add app colours to screen and UI
@Composable
fun CrochetAppTheme(

    content: @Composable () -> Unit

)
{
    //variables for colour palette&text styles
    MaterialTheme(

        colorScheme = CrochetColours,
        typography = TextStyles,
        content = content

    )
}
