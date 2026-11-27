package com.example.crochetapp.components

//imports
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crochetapp.ui.theme.Jasmine
import com.example.crochetapp.ui.theme.Primula

@Composable
fun InspirationCard(
    projectName: String,
    difficulty: String,
    onClick: () -> Unit = {}
) {

    //creates clickable inspiration card
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Jasmine
        )
    ) {

        Column {

            //placeholder for inspiration image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Primula)
            )

            //displays project information
            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Text(
                    text = projectName,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = difficulty,
                    fontSize = 12.sp
                )
            }
        }
    }
}