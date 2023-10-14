package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun CenterCard(title: String, subtitle: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier
                .padding(16.dp)
                .background(Color.DarkGray)
                .size(120.dp)
        )
        Text(
            text = title,
            fontSize = 36.sp,
        )
        Text(
            text = subtitle,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xff006400),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun BottomCard(phone: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        CustomIconItem(
            icon = Icons.Rounded.Phone,
            contentDescription = "Phone",
            text = phone
        )
        Spacer(modifier = Modifier.size(10.dp))
        CustomIconItem(
            icon = Icons.Rounded.Share,
            contentDescription = "Share",
            text = socialMedia
        )
        Spacer(modifier = Modifier.size(10.dp))
        CustomIconItem(
            icon = Icons.Rounded.Email,
            contentDescription = "Email",
            text = email
        )
    }
}

@Composable
fun CustomIconItem(icon: ImageVector, contentDescription: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Icon(
            icon,
            contentDescription = contentDescription,
            modifier = Modifier.weight(1.5f)
        )
        Text(
            text = text,
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        Modifier.fillMaxSize()
    ) {
        CenterCard(
            title = stringResource(id = R.string.title_name_main),
            subtitle = stringResource(id = R.string.subtitle_main),
            modifier = Modifier.weight(5f)
        )
        BottomCard(
            phone = stringResource(R.string.phone_number_main),
            socialMedia = stringResource(R.string.socmed_main),
            email = stringResource(R.string.email_main),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}