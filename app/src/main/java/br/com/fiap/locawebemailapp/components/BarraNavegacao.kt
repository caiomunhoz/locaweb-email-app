package br.com.fiap.locawebemailapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BarraNavegacao(navController: NavController) {
    var itemSelecionado by remember { mutableIntStateOf(0) }
    val itens = listOf(
        "Caixa de Entrada",
        "Calendário",
        "Novo email"
    )
    val icones = listOf(
        Icons.Filled.Email,
        Icons.Filled.DateRange,
        Icons.Filled.Add
    )
    val cores = listOf(
        Color.Gray,
        Color.Gray,
        Color.Gray
    )
    NavigationBar(
        containerColor = Color.Black
    ) {
        itens.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icones[index], contentDescription = item, tint = cores[index]) }, // Define a cor do ícone
                label = { Text(text = item, color = cores[index]) }, // Define a cor do texto
                selected = itemSelecionado == index,
                onClick = {
                    itemSelecionado = index
                    when (itemSelecionado) {
                        0 -> {
                            if (navController.currentDestination?.route != "principal") {
                                navController.navigate("principal")
                            }
                        }

                        1 -> {
                            //Calendário
                        }

                        2 -> {
                            navController.navigate("novoEmail")
                        }
                    }
                },
            )
        }
    }
}
