package com.rahul.aamyahealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rahul.aamyahealth.presentation.screen.MainScreen
import com.rahul.aamyahealth.ui.theme.AamyaHealthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AamyaHealthTheme {
                MainScreen()
            }
        }
    }
}
