package br.com.fiap.locawebemailapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locawebemailapp.components.EmailTopBar
import br.com.fiap.locawebemailapp.repository.EmailRepository

@Composable
fun Email(navController: NavController, emailId: String) {
    val email = EmailRepository.listarEmailPorId(emailId)

    Scaffold (
        topBar = { EmailTopBar(navController) },
        containerColor = Color.Black
    ){
        innerPadding -> Box (modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize()){
            email?.let {
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Text(
                        text = it.assunto,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "De: ${it.remetente}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it.mensagem,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Sent on: ${it.dataEnvio}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.DarkGray,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
    }
}