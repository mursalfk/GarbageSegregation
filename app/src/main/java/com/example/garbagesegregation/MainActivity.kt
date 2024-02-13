package com.example.garbagesegregation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.garbagesegregation.ui.theme.GarbageSegregationTheme
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.garbagesegregation.ui.login.LoginActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GarbageSegregationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SigninButton()
                        Spacer(modifier = Modifier.height(16.dp))
                        SignupButton()
                    }
                }
            }
        }
    }
}

@Composable
fun SigninButton() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }) {
        Text("Login")
    }
}

@Composable
fun SignupButton() {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, RegisterActivity::class.java))
    }) {
        Text("Signup")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    GarbageSegregationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SigninButton()
            Spacer(modifier = Modifier.height(16.dp))
            SignupButton()
        }
    }
}
