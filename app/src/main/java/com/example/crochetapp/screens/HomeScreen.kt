package com.example.crochetapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//colours
private val Jasmine = Color(0xFFFFFAF4)
private val TeaRose = Color(0xFFFFE8E7)
private val Oleander = Color(0xFFFFCDCC)
private val Willow = Color(0xFFB7B15A)

@Composable
fun HomeScreen(
    onNewProject: () -> Unit = {},
    onRowCounter: () -> Unit = {},
    onContinueProject: () -> Unit = {}
) {
    //screen layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TeaRose)
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(TeaRose)
                .padding(12.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Jasmine
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "What are we making today?",
                    modifier = Modifier.padding(16.dp)
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = Jasmine
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Current Project",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Text("My Granny Square Blanket")

                    Text("12 of 20 rows completed")

                    LinearProgressIndicator(
                        progress = { 0.6f },
                        modifier = Modifier.fillMaxWidth(),
                        color = Willow,
                        trackColor = TeaRose
                    )

                    Button(
                        onClick = onContinueProject,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Oleander,
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Continue Project")
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                HomeActionCard(
                    title = "New Project +",
                    modifier = Modifier.weight(1f),
                    onClick = onNewProject
                )

                HomeActionCard(
                    title = "Row Counter",
                    modifier = Modifier.weight(1f),
                    onClick = onRowCounter
                )
            }
        }
    }
}

@Composable
fun HomeActionCard(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier.height(110.dp),
        colors = CardDefaults.cardColors(
            containerColor = Jasmine
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
