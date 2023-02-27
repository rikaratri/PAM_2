package edu.uksw.fti.pam.pam_activity_intent.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.uksw.fti.pam.pam_activity_intent.Profile
import edu.uksw.fti.pam.pam_activity_intent.R
//import edu.uksw.fti.pam.pam_activity_intent.ui.ButtonNavItems

//@Composable
//fun NavigationGraph(
//    navController: NavHostController
//) {
//    NavHost(
//        navController = navController,
//        startDestination = ButtonNavItems.Home.screen_route
//    ) {
//        composable(ButtonNavItems.Home.screen_route) {
//            HomeScreen()
//        }
//        composable(ButtonNavItems.Article.screen_route) {
////            ArticleScreen()
//        }
//        composable(ButtonNavItems.Profile.screen_route) {
//            ProfileScreen()
//        }
//    }
//}
//
//@Composable
//fun BottomNavigation(
//    navController: NavController
//){
//    val items = listOf(
//        ButtonNavItems.Home,
//        ButtonNavItems.Article,
//        ButtonNavItems.Profile
//    )
//    androidx.compose.material.BottomNavigation(
//        backgroundColor = colorResource(id = R.color.teal_200),
//        contentColor = Color.Black
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//
//        items.forEach { item ->
//            BottomNavigationItem(
//                icon = { Icon(
//                    imageVector = item.icon,
//                    contentDescription = "${item.title} icon")
//                },
//                label = {
//                    Text(text = item.title,
//                        fontSize = 9.sp)
//                },
//                selectedContentColor = Color.Black,
//                unselectedContentColor = Color.Black.copy(0.4f),
//                alwaysShowLabel = true,
//                selected = currentRoute == item.screen_route,
//                onClick = {
//                    navController.navigate(item.screen_route) {
//                        navController.graph.startDestinationRoute?.let { screen_route ->
//                            popUpTo(screen_route) {
//                                saveState = true
//                            }
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun BottomNavigationMainScreenView(){
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            BottomNavigation(
//                navController = navController,
//            )
//        }
//    ) {
//        NavigationGraph(navController = navController)
//    }
//}

@Composable
fun Navigation(navController : NavHostController){
    NavHost(navController, startDestination = edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.Beranda.route){
        composable(edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.Beranda.route){
            MainScreen()
        }
        composable(edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.Pesanan.route){
            MainScreen1()
        }
        composable(edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.Chat.route){
            ProfileScreen()
        }
        composable(edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.MyAccount.route){
            Profile()
        }

    }
}
@Composable
fun TopBar(){

    val context = LocalContext.current

    TopAppBar(
//        title = {
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Image(
//                    painterResource(id = R.drawable.logo), "Logo",
//                    modifier = Modifier.size(80.dp).align(Alignment.Center)
//                )
//            }
//        },


        title = {
            Text(text = "          GOJEK", fontSize = 30.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },

        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Default.Menu, "Menu")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Default.Notifications, "Menu")
            }
        },
        backgroundColor = Color.Green,
        contentColor = Color.White,
    )

}

@Composable
fun BottomNavigationBar(navController: NavController){
    val items = listOf(
        edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.Beranda,
        edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.Pesanan,
        edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.Chat,
        edu.uksw.fti.pam.pam_activity_intent.ui.Navigation.MyAccount,
    )

    BottomNavigation(
        backgroundColor = Color.Green,
        contentColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { items ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = items.icon), contentDescription = items.title) },
                label = { Text(text = items.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == items.route,
                onClick = {
                    navController.navigate(items.route){
                        navController.graph.startDestinationRoute?.let{ route ->
                            popUpTo(route = route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun BottomNavigationMainScreenView(){
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            BottomNavigationBar(
//                navController = navController,
//            )
//        }
//    ) {
//        Navigation(navController = navController)
//    }
//}
