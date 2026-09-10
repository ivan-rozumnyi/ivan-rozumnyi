package com.example.myapplicationivan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var checkBox1 by remember { mutableStateOf(false) }
            var checkBox2 by remember { mutableStateOf(false) }

            val selectedText = when {
                checkBox1 && checkBox2 -> "CheckBox 1, CheckBox 2"
                checkBox1 -> "CheckBox 1"
                checkBox2 -> "CheckBox 2"
                else -> "Nothing Selected"
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Default Check Box",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkBox1,
                        onCheckedChange = { checkBox1 = it }
                    )
                    Text(text = "New CheckBox")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkBox2,
                        onCheckedChange = { checkBox2 = it }
                    )
                    Text(text = "New CheckBox")
                }

                Spacer(modifier = Modifier.height(25.dp))

                Divider()

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Custom Check Box",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(
                        2.dp,
                        if (checkBox1) Color.Green else Color.Black
                    )
                ) {
                    Checkbox(
                        checked = checkBox1,
                        onCheckedChange = { checkBox1 = it }
                    )
                }

                Text(
                    text = "CheckBox 1",
                    fontSize = 16.sp
                )

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(
                        2.dp,
                        Color.Black
                    )
                ) {
                    Checkbox(
                        checked = checkBox2,
                        onCheckedChange = { checkBox2 = it }
                    )
                }

                Text(
                    text = "CheckBox 2",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = {
                        Toast.makeText(
                            this@MainActivity,
                            selectedText,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Text(text = selectedText)
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        val message = when {
                            checkBox1 && checkBox2 ->
                                "Вибрані: CheckBox 1 та CheckBox 2"

                            checkBox1 ->
                                "Вибраний: CheckBox 1"

                            checkBox2 ->
                                "Вибраний: CheckBox 2"

                            else ->
                                "Жоден CheckBox не вибрано"
                        }

                        Toast.makeText(
                            this@MainActivity,
                            message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                ) {
                    Text(text = "SHOW CHECKED")
                }
            }
        }
    }
}