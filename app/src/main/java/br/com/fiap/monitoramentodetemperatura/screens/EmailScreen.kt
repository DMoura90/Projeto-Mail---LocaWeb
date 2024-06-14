package br.com.fiap.monitoramentodetemperatura.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.monitoramentodetemperatura.R

@Composable
fun EmailScreen(controleGeral: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) {
        // Barra de pesquisa
        SearchBar()

        // Lista de emails
        EmailList()

        // Botão "Novo"
        NewEmailButton()
    }
}

@Composable
fun SearchBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults
            .cardColors(containerColor = Color.LightGray),
    ) {
        Text(
            text = "Pesquisar",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(10.dp)
        )
    }
}

@Composable
fun EmailList() {
    // Simulando uma lista de emails
    val emails = listOf(
        Email("João", "Assunto do email", "Conteúdo do email"),
        Email("Maria", "Outro assunto", "Outro conteúdo"),
        // ...
    )

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        emails.forEach { email ->
            EmailItem(email)
        }
    }
}

@Composable
fun EmailItem(email: Email) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults
            .cardColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            // Ícone de usuário
            Icon(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "Ícone de usuário"
            )

            // Informações do email
            Column(
                modifier = Modifier
                    .padding(start= 10.dp)
            ) {
                Text(
                    text = email.name,
                    fontSize = 20.sp,
                    color = Color.Black
                )

                Text(
                    text = email.subject,
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun NewEmailButton() {
    Button(
        onClick = { /* criar novo email */ },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.cinza)),
        modifier = padding()
    ) {
        Text(
            text = "Novo",
            fontSize = 20.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
        )
    }
}

@SuppressLint("ModifierFactoryExtensionFunction")
private fun padding(): Modifier {
    TODO("Not yet implemented")
}

data class Email(val name: String, val subject: String, val content: String)

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun EmailScreenPreview() {
    // Inicializando controleGeral com um objeto NavHostController
    rememberNavController()
    val controleGeral = rememberNavController()
    EmailScreen(controleGeral)
}