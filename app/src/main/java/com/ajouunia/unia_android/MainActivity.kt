package com.ajouunia.unia_android

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ajouunia.core.designsystem.UniAAndroidTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ajouunia.unia_android.ui.UniAApp
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        AndroidThreeTen.init(this)
        setContent {
            UniAAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UniAApp()
                }
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            newBase?.let {
                it.createConfigurationContext(
                    it.resources.configuration.apply {
                        setLocale(Locale.ENGLISH)
                    }
                )
            } ?: newBase
        )
    }

}