package br.com.fiap.monitoramentodetemperatura.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.monitoramentodetemperatura.R
import br.com.fiap.monitoramentodetemperatura.R.string.login
import br.com.fiap.monitoramentodetemperatura.R.string.subtitle



@Composable
fun LoginScreen(controleGeral: NavController)
{

    var email by remember() {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var erroEmail by remember {
        mutableStateOf(false)
    }

    var erroPassoword by remember {
        mutableStateOf(false)
    }

    val tamanhoMaximo = 8




    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF242020))
        .padding(32.dp)
    ){

        Column(
            modifier = Modifier.padding(16.dp)

        ) {
            Text(
                text = stringResource(id = login),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                color = Color.Red

                )
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = stringResource(id = subtitle),
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                color = Color.White
            )


            Spacer(modifier = Modifier.height(40.dp))


            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults
                    .cardColors(containerColor = Color.DarkGray)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                                email = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = stringResource(id = R.string.email),
                                color = Color.White
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        isError = erroEmail
                    )



                    if (erroEmail) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "O email é obrigatorio",
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Right
                        )
                    }


                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            if (it.length <= tamanhoMaximo)
                                password = it

                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = stringResource(id = R.string.password),
                                color = Color.White
                            )

                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        isError = erroPassoword,

                        visualTransformation = PasswordVisualTransformation()


                    )

                    if (erroPassoword) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "A senha é obrigatorio",
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Right
                        )
                    }




                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = {
                          // if (email.isEmpty()) erroEmail = true
                           // if (password.isEmpty()) erroPassoword = true
                            if (email.isEmpty()||password.isEmpty()) {
                                erroEmail = true
                                erroPassoword = true
                            }
                            else
                                controleGeral.navigate("menu")

                            },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.preto))
                    ) {
                        Text(
                            text = stringResource(id = R.string.enter),
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(
                        onClick = {
//                            controleGeral.navigate("cadastre-se")
                            controleGeral.navigate("novoEmail")
                        },
                        modifier = Modifier
                            .height(30.dp)
                            .width(300.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.azul))

                    ){
                        Text(text = "Cadastre-se",
                            fontSize = 10.sp,
                            color = Color.Black

                            )

                    }
                }
            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {

    LoginScreen(rememberNavController())

}