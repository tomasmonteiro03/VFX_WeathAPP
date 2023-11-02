package com.tmo.weatherappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.tmo.weatherappfinal.ui.theme.WeatherAppFinalTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun MainApp(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 5.dp)){
        HeaderPreview()
        BoasVindasUser()
    }

}



@Preview(showBackground = true, widthDp = 390)
@Composable
fun HeaderPreview(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 16.dp)
    ) {
        Button(
            onClick = {/*TODO*/},
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = modifier
                .size(38.dp)
                .clip(CircleShape)
        )
        {
            Image(painter = painterResource(id = R.drawable.search), contentDescription = null)
        }
        Button(
            onClick = {/*TODO*/},
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = modifier
                .size(38.dp)
                .clip(CircleShape)
        )
        {
            Image(painter = painterResource(id = R.drawable.batman), contentDescription = null)
        }

    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun BoasVindasUser(username: String= "Tomás")
{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {

        Row(modifier = Modifier.fillMaxWidth())  {
            Text("Olá",
                fontSize= TextUnit(25f, TextUnitType.Sp ),
                color= MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Light )
            Text(" $username",
                fontWeight = FontWeight.Bold,
                color= MaterialTheme.colorScheme.primary,
                fontSize= TextUnit(25f, TextUnitType.Sp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth())  {
            Text(formatData(Calendar.getInstance().time),
                fontSize= TextUnit(18f, TextUnitType.Sp ),
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.secondary)
        }
        Row(modifier = Modifier.fillMaxWidth())  {
            Text("Glória do Ribatejo",
                fontSize= TextUnit(18f, TextUnitType.Sp ),
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.secondary)
        }
    }
}


// Helpers
fun formatData(data: Date): String {
    val format = SimpleDateFormat("dd MMMM, EEEE yyyy", Locale("pt", "PT"))
    return format.format(data)
}
