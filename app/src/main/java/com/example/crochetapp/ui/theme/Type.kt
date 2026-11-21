package com.example.crochetapp.ui.theme

//imports
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.crochetapp.R

//headings/titles
val Grandstander = FontFamily(
    Font(R.font.grandstander_regular)
)

//font for labels and project names
val PatrickHand = FontFamily(
    Font(R.font.patrick_hand_regular)
)

//buttons/descriptions etc
val DMSans = FontFamily(
    Font(R.font.dm_sans_regular)
)

//universal text styles
val TextStyles = Typography(
    headlineLarge = TextStyle(
        fontFamily = Grandstander,
        fontSize = 30.sp,
        fontWeight = FontWeight.Normal

    ),

    headlineMedium = TextStyle(
        fontFamily = Grandstander,
        fontSize = 24.sp
    ),

    titleMedium = TextStyle(
        fontFamily = PatrickHand,
        fontSize = 20.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = DMSans,
        fontSize = 16.sp

    ),

    bodyMedium = TextStyle(
        fontFamily = DMSans,
        fontSize = 14.sp
    ),

    labelLarge = TextStyle(
        fontFamily = DMSans,
        fontSize = 14.sp

    )

)
