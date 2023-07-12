package com.example.artworkapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artworkapp.ui.theme.ArtWorkAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtWorkAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    cars()
                }
            }
        }
    }
}

@Composable
fun cars() {
    var index by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (index) {
            1 -> {
                content(
                    painter = R.drawable.audi,
                    contentDescription = null,
                    name = "Audi ",
                    description = R.string.audi
                )
            }

            2 -> {
                content(
                    painter = R.drawable.bmw,
                    contentDescription = null,
                    name = " BMW",
                    description = R.string.bmw
                )
            }

            3 -> {
                content(
                    painter = R.drawable.mercedes,
                    contentDescription = null,
                    name = "Mercedes Benz",
                    description = R.string.mercedes
                )
            }

            4 -> {
                content(
                    painter = R.drawable.royce,
                    contentDescription = null,
                    name = "Rolls Royce",
                    description = R.string.royce
                )
            }

            5 -> {
                content(
                    painter = R.drawable.tesla,
                    contentDescription = null,
                    name = "Tesla ",
                    description = R.string.tesla
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                ButtonFunction(
                    "Previous",
                    onClick = {
                        index--
                        if (index < 1) {
                            index = 1
                        }

                    })
            }
            Row(
                horizontalArrangement = Arrangement.End,
            ) {
                ButtonFunction(
                    "next",
                    onClick = {
                        index++
                        if (index > 5) {
                            index = 1
                        }

                    })

            }

        }

    }

}

@Composable
fun content(
    @DrawableRes painter: Int,
    contentDescription: String?,
    name: String,
    @SuppressLint("SupportAnnotationUsage") @StringRes description: Int,

    ) {
    Image(
        painter = painterResource(id = painter), contentDescription = contentDescription,
        modifier = Modifier
            .border(3.dp, Color.DarkGray)
            .padding(20.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(text = name, fontWeight = FontWeight.Bold)
        Text(text = stringResource(id = description))
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun ButtonFunction(
    buttonText: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.size(width = 150.dp, height = 50.dp)
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtWorkAppTheme {
        cars()
    }
}