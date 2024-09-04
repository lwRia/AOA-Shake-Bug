package com.example.shakebug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.shakebug.services.AppsOnAirServices
import com.app.shakebug.services.ShakeBugService
import com.example.shakebug.ui.theme.ShakeBugTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShakeBugTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(getString(R.string.app_name)) },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = Color.DarkGray,
                                titleContentColor = Color.White
                            )
                        )
                    },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center,
                    ) {
                        Button(
                            elevation = ButtonDefaults.elevatedButtonElevation(8.dp), // Define elevation
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Yellow,
                                contentColor = Color.Black
                            ),
                            onClick = {
                                ShakeBugService.shakeBug(
                                    this@MainActivity,
                                    raiseNewTicket = true,
                                    extraPayload = mapOf(
                                        "title" to "Initial Demo",
                                        "city" to "Surat",
                                        "state" to "Gujarat"
                                    )
                                )
                            },
                        ) {
                            Text(
                                text = getString(R.string.create_new_ticket),
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }

        AppsOnAirServices.setAppId("---------app-id-------------", true)

        ShakeBugService.shakeBug(this)
    }
}
