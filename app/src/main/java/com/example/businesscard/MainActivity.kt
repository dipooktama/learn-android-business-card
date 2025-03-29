package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                PageLayout()
            }
        }
    }
}

@Composable
fun InfoItem(text: String, imageId: Int, modifier: Modifier) {
    Row(modifier = modifier) {
        Icon(
            painter = painterResource(imageId),
            contentDescription = null
        )
        Spacer(
            Modifier.width(12.dp)
        )
        Text(
            text = text
        )
    }
}

@Composable
fun InfoList(modifier: Modifier) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InfoItem(
            text = stringResource(R.string.phone_number),
            imageId = R.drawable.baseline_phone_24,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .width(240.dp)
        )
        InfoItem(
            text = stringResource(R.string.social_tag),
            imageId = R.drawable.baseline_share_24,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .width(240.dp)
        )
        InfoItem(
            text = stringResource(R.string.email),
            imageId = R.drawable.baseline_email_24,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .width(240.dp)
        )
    }
}

@Composable
fun HeaderInfo(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.fionychimmie2_removebg_preview),
            contentDescription = "profile picture"
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 48.sp,
            lineHeight = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.job_title),
            fontSize = 16.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun PageLayout() {
    Surface(
        color = Color.hsl(
            hue = 0.21f,
            saturation = 1f,
            lightness = 0.8f,
            alpha = 0.34f
        )
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            HeaderInfo(Modifier
                .fillMaxWidth()
                .align(Alignment.Center))
            InfoList(Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        PageLayout()
    }
}