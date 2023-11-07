package com.tmo.weatherappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable._86449326_37c2256216_b),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.4f),
            contentScale = ContentScale.Crop)
    }
    Column(modifier = Modifier

        .fillMaxSize()
        .padding(vertical = 5.dp)){
        HeaderPreview()
        BoasVindasUser()
        ImagemCentro()
        ProxDias()

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
                fontSize= TextUnit(30f, TextUnitType.Sp ),
                color= MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Normal )
            Text(" $username",
                fontWeight = FontWeight.ExtraBold,
                color= MaterialTheme.colorScheme.primary,
                fontSize= TextUnit(30f, TextUnitType.Sp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth())  {
            Text(formatData(Calendar.getInstance().time),
                fontSize= TextUnit(20f, TextUnitType.Sp ),
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.secondary)
        }
        Row(modifier = Modifier.fillMaxWidth())  {
            Text("Glória do Ribatejo",
                fontSize= TextUnit(20f, TextUnitType.Sp ),
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun ImagemCentro(temperatura: Int = 23, estadoTempo: String = "Limpo", @DrawableRes iconResource: Int= R.drawable.sun)
{
    Row(modifier =
    Modifier
        .padding(vertical = 25.dp)
        .height(300.dp)
        .fillMaxWidth()
        .background(color = Color.Transparent),
        Arrangement.Center) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .size(250.dp)
                .shadow(80.dp, CircleShape, spotColor = Color.Transparent)
                .clip(CircleShape)
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            Pair(0.2f, MaterialTheme.colorScheme.tertiaryContainer),
                            Pair(1f, MaterialTheme.colorScheme.primaryContainer)
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(contentAlignment = Alignment.TopCenter, modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp)){
                Box( modifier = Modifier
                    .height(140.dp)
                    .padding(top = 0.dp)){
                    Image(
                        painter = painterResource(id = iconResource),
                        contentDescription = null
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 90.dp)){
                    Text("$temperatura"+"º",
                        modifier = Modifier.padding(0.dp,0.dp,100.dp, 0.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize= TextUnit(55f, TextUnitType.Sp))
                }
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 90.dp)){
                    Text("$estadoTempo",
                        fontWeight = FontWeight.ExtraLight,color= MaterialTheme.colorScheme.primary,
                        fontSize= TextUnit(15f, TextUnitType.Sp),
                        modifier = Modifier.padding(145.dp,23.dp,0.dp, 0.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 390)
@Composable
fun ProxDias()
{
    Column(modifier = Modifier.height(210.dp)) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Próximos 7 dias",
                fontSize= TextUnit(28f, TextUnitType.Sp ),
                color= MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold )
        }

        LazyRow(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(listaDeTemperaturas) { item ->
                // Conteúdo a ser exibido para cada item da lista
                DiasFuturos(item)
            }
        }
    }
}

data class TemperaturaDia(val Temperatura:Int, val Estado:String, val Resource:Int)
val listaDeTemperaturas = listOf(
    TemperaturaDia(-3, "Neve", R.drawable.snowy),
    TemperaturaDia(33, "Limpo", R.drawable.sun),
    TemperaturaDia(13, "Chuva", R.drawable.rainy),
    TemperaturaDia(16, "Tempestade", R.drawable.storm),
    TemperaturaDia(15, "Chuva", R.drawable.rainy),
    TemperaturaDia(13, "Chuva", R.drawable.rainy),
    TemperaturaDia(1, "Neve", R.drawable.snowy)
)

@Composable
fun DiasFuturos(day: TemperaturaDia)
{
    Box(
        modifier = Modifier
            .padding(5.dp)
            .size(100.dp, 200.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier =
        Modifier
            .fillMaxSize()
            .background(color = Color.Transparent),
            Arrangement.Center) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .shadow(10.dp, CircleShape, spotColor = MaterialTheme.colorScheme.tertiaryContainer)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.tertiaryContainer),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Box(contentAlignment = Alignment.TopCenter, modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)){
                    Box( modifier = Modifier
                        .height(60.dp)
                        .padding(top = 15.dp)){
                        Image(
                            painter = painterResource(id = day.Resource),
                            contentDescription = "ehll"
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 0.dp)){
                        Text("${day.Temperatura}"+"º",
                            modifier = Modifier.padding(0.dp,0.dp,0.dp, 0.dp),
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize= TextUnit(25f, TextUnitType.Sp))
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 50.dp)){
                        Text("${day.Estado}",
                            fontWeight = FontWeight.ExtraLight,color= MaterialTheme.colorScheme.primary,
                            fontSize= TextUnit(13f, TextUnitType.Sp),
                            modifier = Modifier.padding(0.dp,0.dp,0.dp, 0.dp))
                    }
                }
            }
        }

    }
}


fun formatData(data: Date): String {
    val format = SimpleDateFormat("dd MMMM, EEEE yyyy", Locale("pt", "PT"))
    return format.format(data)
}
