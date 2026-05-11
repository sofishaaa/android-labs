package com.example.twoactivities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.twoactivities.ui.theme.TwoActivitiesTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val EXTRA_MESSAGE = "com.example.twoactivities.extra.MESSAGE"
        private const val LOG_TAG = "MainActivity"
        private const val TEXT_CONTENT = "textContent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")
        setContent {
            TwoActivitiesTheme {
                var message by remember {
                    mutableStateOf(savedInstanceState?.getString(TEXT_CONTENT) ?: "")
                }
                MainScreen(
                    message = message,
                    onMessageChange = { message = it },
                    onSendClick = {
                        Log.d(LOG_TAG, "Button clicked!")
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putExtra(EXTRA_MESSAGE, message)
                        startActivity(intent)
                    }
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d(LOG_TAG, "Landscape orientation")
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(LOG_TAG, "Portrait orientation")
        }
    }
}

@Composable
fun MainScreen(
    message: String,
    onMessageChange: (String) -> Unit,
    onSendClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = onMessageChange,
            label = { Text("Enter Your Message Here") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onSendClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("SEND")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}