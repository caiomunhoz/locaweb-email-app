package br.com.fiap.locawebemailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.locawebemailapp.screens.Email
import br.com.fiap.locawebemailapp.screens.NovoEmail
import br.com.fiap.locawebemailapp.screens.Principal
import br.com.fiap.locawebemailapp.ui.theme.LocaWebEmailAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocaWebEmailAppTheme {
                Surface {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "principal") {
                        composable(route = "principal") {
                            Principal(navController)
                        }
                        composable(route = "email/{emailId}") {
                            Email(navController, it.arguments?.getString("emailId")!!)
                        }
                        composable(route = "novoEmail") {
                            NovoEmail(navController)
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Preview() {
//    Principal(emails = listarEmailsMockados().sortedByDescending { it.dataEnvio })
//}
