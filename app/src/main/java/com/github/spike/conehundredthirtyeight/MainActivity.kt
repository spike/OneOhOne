package com.github.spike.conehundredthirtyeight

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.spike.conehundredthirtyeight.ui.theme.OneOhOneTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var temp = "testing testing"
        setContent {
            OneOhOneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(temp)
                }
            }
        }
        val api = RetrofitHelper.getInstance().create(CharactersApi::class.java)
        GlobalScope.launch {
            Log.d("Rick: ", "Launching coroutine")
            val result = api.getCharacterById(3)
            if (result != null) {
                temp = result.body()!!.name
                Log.d("Rick: ", result.body()!!.name)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OneOhOneTheme {
        Greeting("Android")
    }
}