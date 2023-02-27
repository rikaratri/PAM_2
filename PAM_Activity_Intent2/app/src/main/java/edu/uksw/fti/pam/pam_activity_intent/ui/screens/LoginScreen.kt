package edu.uksw.fti.pam.pam_activity_intent.ui.screens

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.pam_activity_intent.HomeActivity
import edu.uksw.fti.pam.pam_activity_intent.contracts.SignUpContract
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.PAM_Activity_IntentTheme
import edu.uksw.fti.pam.pam_activity_intent.R


internal fun doAuth(
    username:String,
    password:String,
):Boolean{
    return (username.equals("admin")&& password.equals("admin"))
}

@Composable
fun LoginForm(){
    val lContext = LocalContext.current
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    val getUsernameFromSignedUpFrom = rememberLauncherForActivityResult(
        contract = SignUpContract(),
        onResult = { usernameInput = it!!}
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        TextField(
            value =usernameInput.toString() ,
            onValueChange = {usernameInput = it } ,
            label = { Text(text= stringResource(R.string.label_username)) },
            modifier = Modifier.fillMaxWidth(),
        )
        TextField(
            value = passwordInput.toString(),
            onValueChange = {passwordInput = it },
            label = { Text(text= stringResource(R.string.label_password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
        )
        Row(

        ) {
            Button(onClick = {
                val isAuthenticated = doAuth(usernameInput, passwordInput)
                if(isAuthenticated) {
                    lContext.startActivity(
                        Intent(lContext, HomeActivity::class.java)
                            .apply {
                                putExtra("username", usernameInput)
                            }
                    )
                }
            }
            )
            {
                Text(text = stringResource(R.string.btn_login_title))
            }
            Button(onClick = {
                getUsernameFromSignedUpFrom.launch("")
            }
            )
            {
                Text(text = stringResource(R.string.btn_signup_title))
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LoginFormPreview(){
    PAM_Activity_IntentTheme {
        LoginForm()
    }
}