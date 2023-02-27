package edu.uksw.fti.pam.pam_activity_intent.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import edu.uksw.fti.pam.pam_activity_intent.R

//sealed class ButtonNavItems (
//    val title: String,
//    val icon: ImageVector,
//    val screen_route: String,
//){
//    object Home: ButtonNavItems("Home", Icons.Default.Home, "home")
//    object Article: ButtonNavItems("Article", Icons.Default.Search, "artikel")
//    object Profile: ButtonNavItems("Profile", Icons.Default.Person, "profile")
//}

sealed class Navigation (val route: String, val icon: Int, val title: String)
{
    object Beranda : Navigation("home", R.drawable.ic_home, "Beranda")
    object Pesanan : Navigation("pesanan", R.drawable.ic_list, "Pesanan")
    object Chat : Navigation("chat", R.drawable.ic_chat, "Chat")
    object MyAccount : Navigation("myaccount", R.drawable.ic_account, "MyAccount")
    object Notification : Navigation("notification", R.drawable.ic_notifications, "")
    object Border : Navigation("border", R.drawable.ic_border, "")
    object Logo : Navigation("logo", R.drawable.logo, "")
}