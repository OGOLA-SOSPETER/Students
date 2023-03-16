package projects.ogolasospeter.students

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import projects.ogolasospeter.students.filepackages.GalleryScreen
import projects.ogolasospeter.students.ui.theme.StudentsTheme
import projects.ogolasospeter.students.routes.NavStudent

class MainActivity : ComponentActivity() {
    private val READ_EXTERNAL_STORAGE_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavStudent()
                }
            }
        }
        requestExternalStoragePermission()
    }



        private fun requestExternalStoragePermission() {
            // Check if the permission is already granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
            ) {

                // Request the permission
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    READ_EXTERNAL_STORAGE_REQUEST_CODE
                )
            }
        }

        // Handle the result of the permission request
        override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, do nothing
                } else {
                    // Permission denied, show a message or take appropriate action
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }







//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    StudentsTheme {
//
//    }
//}