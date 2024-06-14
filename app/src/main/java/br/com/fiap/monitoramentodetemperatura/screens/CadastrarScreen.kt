package br.com.fiap.monitoramentodetemperatura.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun CadastrarScreen(
    controleGeral: NavController
) {
    var nome by remember {
        mutableStateOf("")
    }

    var senhaCadastro by remember {
        mutableStateOf("")
    }
    var confirmar by remember {
        mutableStateOf("")
    }
    var emailCadastro by remember {
        mutableStateOf("")
    }

    val tamanhoMaximo = 8

    var erroNome by remember {
        mutableStateOf(false)
    }

    var erroSenha by remember {
        mutableStateOf(false)
    }

    var erroConfirmar by remember {
        mutableStateOf(false)
    }

    var erroEmail by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF242020))
            .padding(32.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)

        ) {
            Text(
                text = stringResource(id = R.string.TituloCadastro),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)

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
                        value = nome,
                        onValueChange = {
                            nome = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = stringResource(id = R.string.nome),
                                color = Color.White
                            )
                        },
                        isError = erroNome
                        )
                    if (erroNome){
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "O nome é obrigatorio",
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Right
                        )

                    }

                    
                  //  Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = senhaCadastro,
                        onValueChange = {
                            if (it.length <= tamanhoMaximo)
                                senhaCadastro = it
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
                        isError = erroSenha,
                        visualTransformation = PasswordVisualTransformation()
                    )
                    if (erroSenha){
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "A senha é obrigatorio",
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Right
                        )


                    }


                   // Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = confirmar,
                        onValueChange = {
                            if (it.length <= tamanhoMaximo)
                                confirmar = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = stringResource(id = R.string.confirmar),
                                color = Color.White
                            )

                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        isError = erroConfirmar,
                        visualTransformation = PasswordVisualTransformation(),
                        )
                    
                    if (erroConfirmar){
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "A senha é obrigatorio",
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Right
                        )
                    }

                    //Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = emailCadastro,
                        onValueChange = {
                            emailCadastro = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = stringResource(id = R.string.email),
                                color = Color.White
                            )
                        },
                        isError = erroEmail
                    )

                    if (erroEmail){
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "A senha é obrigatorio",
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.Right
                        )

                    }

                   // Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {

                            if (nome.isEmpty() || emailCadastro.isEmpty() || senhaCadastro.isEmpty() || confirmar.isEmpty()) {
                                erroNome = true
                                erroSenha = true
                                erroConfirmar = true
                                erroEmail = true
                            } else
                                controleGeral.navigate("login")

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.preto))
                    ) {
                        Text(
                            text = stringResource(id = R.string.botaoConfirmar),
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }


                }
            }
        }
    }

}

@Preview
@Composable
fun CadastrarScreenPreview() {

     CadastrarScreen(rememberNavController())

}