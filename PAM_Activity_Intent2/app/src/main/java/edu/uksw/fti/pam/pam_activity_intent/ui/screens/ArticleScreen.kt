package edu.uksw.fti.pam.pam_activity_intent.ui.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.uksw.fti.pam.pam_activity_intent.R
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.Green500
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.Green700
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.PAM_Activity_IntentTheme
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.TextWhite


@Composable
fun MainScreen1(){

//    BottomNavigationMainScreenView()
    val navController = rememberNavController()

    Scaffold(
        topBar = {TopBar() },
        bottomBar = {
            BottomNavigationBar(navController)
        },

        ) {
        Navigation(navController)

    }
    Column(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .width(0.dp)
                .height(25.dp)
                .background(color = Color.LightGray, shape = CircleShape)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .width(400.dp)
                    .border(border = BorderStroke(width = 1.dp, Color.DarkGray))
                    .background(Color(0xFFF5F5F5), shape = CircleShape)
                    .padding(vertical = 10.dp, horizontal = 15.dp)

            ){
                Row{
                    Icon(Icons.Default.Search,  null)
                    Spacer(modifier = Modifier.width(30.dp))
                    Text("Cari layanan, makanan, & tujuan", style = TextStyle(color = Color.Gray))

                }
            }
            Spacer(modifier = Modifier.height(10.dp))

        }
        Spacer (modifier = Modifier.height(5.dp))
        ScreenHome1()
        Spacer (modifier = Modifier.height(4.dp))
        BestSellerSection()
        Spacer (modifier = Modifier.height(5.dp))
        BestSellerSection1()
    }

}


@Composable
fun ScreenHome1(){
    Column{
        ChipSection1(chips = listOf("Apa aja","GoFood","GoBils","GoPay","GoPayLater"))
    }
}

@Composable
fun ChipSection1(chips: List<String>){
    var selectedChipIndex by remember{
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 10.dp, top = 15.dp, bottom = 15.dp)
                    .clickable{
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        if(selectedChipIndex == it)
                            Green700
                        else Green500
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun BestSellerSection(){
    Column(){
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Best Sellers", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}){
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }
        BestSellerItems()
    }
}

@Composable
fun BestSellerItems(){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.a),
                title = "Pizza Hut",
                price = "15.000",
                discountPercent = 10
            )
        }
        item{
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.b),
                title = "FriendChiken",
                price = "25.000" ,
                discountPercent = 5
            )
        }
        item{
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.d),
                title = "Nasi Bakar",
                price = "15.000",
                discountPercent = 15
            )
        }
    }
}

@Composable
fun BestSellerItem(
    title: String="",
    price:String = "",
    discountPercent: Int = 0,
    imagePainter : Painter
){
    Card(
        Modifier.width(160.dp)
    ){
        Column(
            Modifier.padding(bottom = 32.dp)
        ){
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier.fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier.fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ){
                Text(text = title, fontWeight = FontWeight.Bold)
                Row{
                    Text(
                        "Rp.${price}",
                        textDecoration = if(discountPercent >0)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                        color = if(discountPercent>0) Color.Gray else Color.Black
                    )
                    if (discountPercent>0){
                        Text(text = "[$discountPercent%", color = MaterialTheme.colors.primary)
                    }
                }
            }
        }
    }
}

@Composable
fun BestSellerSection1(){
    Column(){
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Promo menarik buat kamu", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}){
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }
        BestSellerItems1()
    }
}

@Composable
fun BestSellerItems1(){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item{
            BestSellerItem1(
                imagePainter = painterResource(id = R.drawable.c),
                title = "Burger",
                price = "50.000",
                discountPercent = 20
            )
        }
        item{
            BestSellerItem1(
                imagePainter = painterResource(id = R.drawable.e),
                title = "Seblak Jontor",
                price = "25.000" ,
                discountPercent = 15
            )
        }
        item{
            BestSellerItem1(
                imagePainter = painterResource(id = R.drawable.c),
                title = "Ayam Bakar",
                price = "15.000",
                discountPercent = 15
            )
        }
    }
}

@Composable
fun BestSellerItem1(
    title: String="",
    price: String = "",
    discountPercent: Int = 0,
    imagePainter : Painter
){
    Card(
        Modifier.width(160.dp)
    ){
        Column(
            Modifier.padding(bottom = 32.dp)
        ){
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier.fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier.fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ){
                Text(text = title, fontWeight = FontWeight.Bold)
                Row{
                    Text(
                        "Rp.${price}",
                        textDecoration = if(discountPercent >0)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                        color = if(discountPercent>0) Color.Gray else Color.Black
                    )
                    if (discountPercent>0){
                        Text(text = "[$discountPercent%", color = MaterialTheme.colors.primary)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BebasActivityFormPreview(){
    PAM_Activity_IntentTheme {
        MainScreen1()
    }
}

