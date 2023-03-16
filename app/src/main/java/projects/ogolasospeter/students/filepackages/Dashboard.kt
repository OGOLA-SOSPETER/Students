package projects.ogolasospeter.students.filepackages

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import projects.ogolasospeter.students.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomePages(navController: NavHostController) {
    var scaffoldState = rememberScaffoldState()
    Scaffold (
        scaffoldState = scaffoldState,
       content = {
           var studentname by rememberSaveable{mutableStateOf("")}
           var studentregno by rememberSaveable{mutableStateOf("") }
           var studentemail by rememberSaveable{ mutableStateOf("") }
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(16.dp),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
           ) {

               Text(text = "Welcome to SkyLiners High School")
               Text(text = "Kindly Proceed by Logging in..")
               Image(painter = painterResource(id = R.drawable.log),
                   contentDescription = "Login image", modifier = Modifier.size(150.dp) )

               OutlinedTextField(value = TextFieldValue(),
                   onValueChange = {studentname = it.text },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 20.dp, end = 20.dp),
                   label = { Text(text = "Student Name: ")},
                   placeholder = {Text(" John Maina Mburu")},
                   trailingIcon = {Icon(Icons.Filled.Person, contentDescription = "Trail image")},
                   singleLine = true,
                   keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words,autoCorrect = false,
                       KeyboardType.Text)
               )
               OutlinedTextField(value = TextFieldValue(),
                   onValueChange = {studentregno = studentregno},
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 20.dp, end = 20.dp),
                   label = { Text(text = "Student Registration: ")},
                   placeholder = {Text("98765")},
                   trailingIcon = {Icon(Icons.Filled.Info, contentDescription = "Trail image")},
                   singleLine = true,
                   keyboardOptions = KeyboardOptions(KeyboardCapitalization.Characters,autoCorrect = false,
                       KeyboardType.Number)
               )

               OutlinedTextField(value = TextFieldValue(),
                   onValueChange = {studentemail = it.text},
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 20.dp, end = 20.dp),
                   label = { Text(text = "Student Email: ")},
                   placeholder = {Text("johnmainamburu@gmail.com")},
                   trailingIcon = {Icon(Icons.Filled.Email, contentDescription = "Trail image")},
                   singleLine = true,
                   keyboardOptions = KeyboardOptions(KeyboardCapitalization.None,autoCorrect = false,
                       KeyboardType.Email)
               )

               Button(
                   onClick = { navController.navigate("home") },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 20.dp, end = 20.dp),
                   interactionSource = MutableInteractionSource(),
                   colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
               ) {
                   Text(text = "Login")
               }
               Button(onClick = { /*TODO*/ },
                   colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
               ) {
                   Text(
                       text = "Register.",
                       textDecoration = TextDecoration.Underline,
                       color = Color.Blue,
                   )
               }


           }
       }
    )

}


@Preview
@Composable
fun PreviewDashboardPages() {
        WelcomePages(navController = rememberNavController())
}