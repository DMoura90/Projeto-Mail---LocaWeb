package br.com.fiap.monitoramentodetemperatura.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.monitoramentodetemperatura.R

@Composable
fun MenuScreen(controleGeral: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF2C4EC7))
        .padding(32.dp)

    ){
        Text(
            text = "MENU",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(alignment = Alignment.TopCenter)

        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Button(
                onClick = {
                    controleGeral.navigate("Emails")
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.temp),
                    fontSize = 20.sp, color = Color.Blue)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    controleGeral.navigate("Historico")
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(text = "Histórico", fontSize = 20.sp, color = Color.Blue)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    controleGeral.navigate("login")
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(text = "Sair", fontSize = 20.sp, color = Color.Blue)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MenuScreenPreview(){
    
    MenuScreen(rememberNavController())
}