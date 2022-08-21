package com.otaman.weather.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.otaman.weather.R

// Set of Material typography styles to start with
private val fontFamilyOverpass = FontFamily(
    listOf(
        Font(
            resId = R.font.overpass
        ),
        Font(
            resId = R.font.overpass,
            weight = FontWeight.Light
        )
    )
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fontFamilyOverpass,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),
    body2 = TextStyle(
        fontFamily = fontFamilyOverpass,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color.White
    ),
    h1 = TextStyle(
        fontFamily = fontFamilyOverpass,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color.White,
        shadow = Shadow(
            color = Color.Black.copy(alpha = 0.15f),
            offset = Offset(-5.0f, 5.0f),
            blurRadius = 1f
        )
    ),
    h2 = TextStyle(
        fontFamily = fontFamilyOverpass,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color.White,
        shadow = Shadow(
            color = Color.Black,
            offset = Offset(-15.0f, 15.0f),
            blurRadius = 200f
            )
    ),
    h3 = TextStyle(
        fontFamily = fontFamilyOverpass,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color.White,
        shadow = Shadow(
            color = Color.Black.copy(alpha = 0.15f),
            offset = Offset(-5.0f, 5.0f),
            blurRadius = 1f
        )
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)