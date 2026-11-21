package com.example.crochetapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.crochetapp.R
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

//colour imports
import com.example.crochetapp.ui.theme.Jasmine
import com.example.crochetapp.ui.theme.TeaRose
import com.example.crochetapp.ui.theme.Oleander
import com.example.crochetapp.ui.theme.Willow
import com.example.crochetapp.ui.theme.Primula

@Composable

//navigation between all the diff screens
fun HomeScreen(
    onNewProject: () -> Unit = {},
    onRowCounter: () -> Unit = {},
    onContinueProject: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {

    //background
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TeaRose)
    )
    {
    //spacing between screen sections
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(TeaRose)
                .padding(12.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            //align profile pic and welcome message
            Row(

                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {

                //welcome message card
                Card(

                    modifier = Modifier
                        .weight(1f)
                        .height(65.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Jasmine

                    )

                ) {

                    Box(

                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 12.dp),
                        contentAlignment = Alignment.CenterStart

                    ) {

                        Text(

                            text = "What are we making today?",
                            fontSize = 14.sp

                        )
                    }
                }

                //makes profile image clickable and displays it
                Box(

                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                        .background(Jasmine)
                        .clickable { onProfileClick() },
                    contentAlignment = Alignment.Center

                ) {

                    Image(

                        painter = painterResource(R.drawable.profile_icon),
                        contentDescription = "Open profile",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop

                    )

                }
            }

//displays current project and progress
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

                    Text("Hat")

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

            //new project and row counter cards
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

//reusable homescreen card with onclick actions
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
