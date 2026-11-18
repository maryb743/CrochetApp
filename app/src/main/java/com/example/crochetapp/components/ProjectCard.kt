
package com.example.crochetapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val Jasmine = Color(0xFFFFFAF4)
//reusable project card with an image name and details button
@Composable
fun ProjectCard(
    projectName: String,
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(190.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Jasmine
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            //image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            HorizontalDivider(
                color = Color(0xFFEBEBBF),
                thickness = 1.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = projectName,
                    style = MaterialTheme.typography.bodySmall
                )
//details button
                OutlinedButton(
                    onClick = onDetailsClick,
                    contentPadding = PaddingValues(
                        horizontal = 12.dp,
                        vertical = 0.dp
                    ),
                    modifier = Modifier.height(28.dp)
                ) {
                    Text("Details")
                }
            }
        }
    }
}
