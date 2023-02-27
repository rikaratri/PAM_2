package edu.uksw.fti.pam.pam_activity_intent.ui.screens


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import edu.uksw.fti.pam.pam_activity_intent.R
import edu.uksw.fti.pam.pam_activity_intent.datastore.StoreUserFirstName
import edu.uksw.fti.pam.pam_activity_intent.datastore.StoreUserLastName

import edu.uksw.fti.pam.pam_activity_intent.ui.theme.PAM_Activity_IntentTheme


@Composable
fun ProfileScreen(){
    val context = LocalContext.current
    // scope
    val scope = rememberCoroutineScope()
    // datastore First Name, Last Name
    val dataStore = StoreUserFirstName(context)
    val dataStore1 = StoreUserLastName(context)
    // get saved First Name, Last Name
    val savedFirstName = dataStore.getFirstName.collectAsState(initial = "")
    val savedLastName = dataStore1.getLastName.collectAsState(initial = "")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = savedFirstName.value!!,
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            text = savedLastName.value!!,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}
