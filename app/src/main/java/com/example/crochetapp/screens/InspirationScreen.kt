package com.example.crochetapp.screens

//imports
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crochetapp.ui.theme.Jasmine
import com.example.crochetapp.screens.InspirationScreen

@Composable
fun InspirationScreen() {

    //creates vertical screen layout
    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Jasmine)
            .padding(20.dp)

    ) {

        //screen heading
        Text(

            text = "Inspiration",
            fontSize = 28.sp

        )
    }
}