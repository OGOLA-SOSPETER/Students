package projects.ogolasospeter.students.filepackages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import projects.ogolasospeter.students.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StudentProfilePage(navController: NavHostController) {
    // define state variables
    val name = remember { mutableStateOf("John Doe") }
    val email = remember { mutableStateOf("john.doe@example.com") }
    val age = remember { mutableStateOf(18) }
    val profilePicture = remember { mutableStateOf(R.drawable.apps) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student Profile") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // profile picture
            Image(
                painter = painterResource(id = profilePicture.value),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            // name
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = name.value,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            // email
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = email.value,
                fontSize = 16.sp
            )

            // age
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Age: ${age.value}",
                fontSize = 16.sp
            )

            // edit button
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Edit")
            }
        }
    }
}

@Preview
@Composable
fun PreviewStudentProfilePage() {
    StudentProfilePage(navController = rememberNavController())
}
