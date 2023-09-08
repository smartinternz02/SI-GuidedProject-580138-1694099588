package main.first.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import main.first.assignment1.ui.theme.Assignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {

                BackgroundField()

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(48.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    HeaderField()
                }

                Column(modifier = Modifier.padding(55.dp,225.dp)) {
                    LoginField()

                }

                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
                    SubmitButton()
                }
            }
        }
    }
}

@Composable
fun BackgroundField() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.images),
            contentDescription = "Login",
            modifier = Modifier
                .fillMaxSize()
                .blur(20.dp),
            contentScale = ContentScale.Crop
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .alpha(0.5f)
            .clip(
                CutCornerShape(
                    topEnd = 16.dp,
                    bottomStart = 16.dp
                )
            )
            .background(MaterialTheme.colorScheme.background)
        )
    }
}

@Composable
fun HeaderField() {
    Text(text = "Welcome Back", fontWeight = FontWeight.ExtraBold, fontSize =36.sp)
    Text(text = "Login to continue", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
}


@OptIn(ExperimentalMaterial3Api:: class)
@Composable
fun LoginField() {
    var text by remember { mutableStateOf("") }
    TextField(value = text ,
        onValueChange = { text = it },
        label = { Text(text = "User Name")},
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go)
    )

    Spacer(modifier = Modifier.height(8.dp))

    var text1 by remember {
        mutableStateOf("")
    }
    TextField(value = text1,
        onValueChange = { text1 = it},
        label = { Text(text = "Password")},
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Go))
}

@Composable
fun SubmitButton() {
    Button(onClick = { /*TODO*/ }, modifier = Modifier.height(50.dp)) {
        Text(text = "Login")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {

    BackgroundField()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(48.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderField()
    }

    Column(modifier = Modifier.padding(55.dp,225.dp)) {
        LoginField()

    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
        SubmitButton()
    }
}

