package projects.ogolasospeter.students.filepackages

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardPage(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            )
        },
        content = {
            DashboardContent(navController = rememberNavController())
        }
    )
}

@Composable
fun DashboardContent(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // welcome text
        Text(
            text = "Welcome back, John!",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        // buttons
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DashboardButton(
                icon = Icons.Filled.Build,
                label = "Classes",
                onClick = { /* TODO */ }
            )
            DashboardButton(
                icon = Icons.Filled.Create,
                label = "Assignments",
                onClick = { /* TODO */ }
            )
            DashboardButton(
                icon = Icons.Filled.List,
                label = "Grades",
                onClick = { /* TODO */ }
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun DashboardButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
fun PreviewDashboardPage() {
    DashboardPage(navController = rememberNavController())
}