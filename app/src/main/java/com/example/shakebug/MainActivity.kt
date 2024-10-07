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
import com.app.shakebug.services.AppRemarkService
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
                                AppRemarkService.addRemark(
                                    this@MainActivity,
                                    extraPayload = mapOf(
                                        "city" to "Surat",
                                        "state" to "Gujarat",
                                        "isFromIndia" to true
                                    ),
                                )
                            },
                        ) {
                            Text(
                                text = getString(R.string.create_new_remark),
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }
        AppRemarkService.initialize(
            this,
            options = mutableMapOf("pageBackgroundColor" to "#FFFFC5"),
        )
        // AppRemarkService.initialize( options = mutableMapOf("pageBackgroundColor" to "#FFFFC5"), shakeGestureEnable = false)
    }
}
