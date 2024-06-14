package br.com.fiap.monitoramentodetemperatura.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.monitoramentodetemperatura.R


@Composable
fun EmailScreen(controleGeral: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)

    )
    {

     Card(modifier = Modifier
         .size(400.dp, 70.dp)
         .padding(8.dp)
     ) {

      Column {

          Text(
              text = stringResource(id = R.string.temp),
              fontSize = 32.sp,
              fontWeight = FontWeight.Bold,
              color = Color.Red,
              modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

      }
     }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center)

        ) {

            Spacer(modifier = Modifier.height(100.dp))





                Text(
                    text = "Sensor 1",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "32°C",
                    fontSize = 50.sp,
                    color = Color.Red,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )


                Spacer(modifier = Modifier.height(32.dp))






                Text(
                    text = "Sensor 2",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "28°C",
                    fontSize = 50.sp,
                    color = Color.Yellow,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )


                Spacer(modifier = Modifier.height(32.dp))






        }
        Button(
            onClick = {
                controleGeral.navigate("menu")},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.cinza)),
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(5.dp)
        ){
            Text(
                text = "Voltar",
                fontSize = 20.sp,
                color = Color.Blue,
                textAlign = TextAlign.Center,
                )}

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun EmailScreenPreview() {

    EmailScreen(rememberNavController())

}
