package projects.ogolasospeter.students

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomePage(navController: NavHostController) {
    var drawerState by remember { mutableStateOf(DrawerValue.Closed) }

    val context = LocalContext.current
    var scaffoldState = rememberScaffoldState().also {

        Scaffold(
            scaffoldState = it,
            topBar = {
                TopAppBar(backgroundColor = DefaultTintColor) {
                    IconButton(
                        onClick = { drawerState = DrawerValue.Open }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu",)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.favorite),
                            contentDescription = "favorite", modifier = Modifier.size(25.dp))
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    IconButton(
                        onClick = { navController.navigate("settings") }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.settings),
                            contentDescription = "settings", modifier = Modifier.size(25.dp))
                    }
                    Spacer(modifier = Modifier.width(10.dp))


                    IconButton(
                        onClick = { navController.navigate("gallery") }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.gallery),
                            contentDescription = "gallery", modifier = Modifier.size(25.dp))
                    }
                }
            },
            drawerContent = {
                DrawerContent(
                    onClose = { drawerState = DrawerValue.Closed  }
                )
            },
            content = {
                Column {
                    LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),
                        horizontalArrangement = Arrangement.spacedBy(3.dp),
                        verticalArrangement = Arrangement.spacedBy(3.dp),
                        content = {
                            items(50) { index ->
                                Card(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier.size(100.dp),
                                    elevation = 3.dp
                                ) {
                                    Column (verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally){
                                        Text(text = "Student $index")
                                    }
                                }
                                Spacer(
                                    modifier = Modifier
                                        .height(3.dp)
                                        .width(3.dp)
                                )
                            }
                        })
                }
            },

            bottomBar = {
                BottomAppBar(backgroundColor = androidx.compose.ui.graphics.Color.Gray, content = {
                    Spacer(modifier = Modifier.width(50.dp))

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.AccountBox, contentDescription = "User", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(50.dp))
                    IconButton(onClick = { navController.navigate("land") }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(50.dp))

                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(Icons.Filled.Person, contentDescription = "person", tint = Color.White)
                    }

                })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Image(painterResource(id = R.drawable.person_add),
                        contentDescription = "add", modifier = Modifier.size(25.dp))

                }
            }, floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = false

        )
    }
}

@Preview
@Composable
fun PreviewHome(){
    HomePage(navController = rememberNavController())
}

@Composable
fun DrawerContent(onClose: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Drawer Content",
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = onClose,
        ) {
            Text("Close Drawer")
        }
    }
}