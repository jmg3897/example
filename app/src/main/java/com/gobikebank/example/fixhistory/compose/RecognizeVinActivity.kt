package com.gobikebank.example.fixhistory.compose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gobikebank.example.R

class RecognizeVinActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                CreateVinView { finish() }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CreateVinPreview() {
    CreateVinView {}
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateVinView(onBackPressed: () -> Unit) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CreateTopAppBar(
                title = stringResource(id = R.string.fix_history_text),
                onBackPressed = onBackPressed
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                fontSize = 24.sp,
                text = stringResource(id = R.string.recognize_vin_title_text),
            )

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
            ) {
                val textState = remember { mutableStateOf("") }
                OutlinedTextField(
                    placeholder = {
                        Text(text = stringResource(id = R.string.recognize_vin_insert_edittext_hint))
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.recognize_vin_yellow),
                        focusedBorderColor = colorResource(id = R.color.recognize_vin_yellow)
                    ),
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(1f, true),
                    value = textState.value,
                    onValueChange = { textValue -> textState.value = textValue })
                Button(
                    modifier = Modifier
                        .width(52.dp)
                        .fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.recognize_vin_yellow)),
                    onClick = {

                    }) {
                    Image(imageVector = Icons.Default.QrCodeScanner, contentDescription = "QR")
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = stringResource(id = R.string.recognize_vin_look_up_text))
            Spacer(modifier = Modifier.size(32.dp))
            Button(modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.recognize_vin_yellow)),
                onClick = {
                    context.startActivity(
                        Intent(
                            context,
                            FixHistoryActivity::class.java
                        )
                    )
                }) {
                Text("조회", fontWeight = FontWeight.Bold)
            }
        }
    }
}
