


package com.example.tugaslayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugaslayout.ui.theme.TugasLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// === TAMPILAN UTAMA ===
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Judul Atas
        Text(
            text = stringResource(id = R.string.fakultas),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = stringResource(id = R.string.universitas),
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Memanggil fungsi Card (Syarat Tugas: Reusability)
        ProfileCardWidget(
            namaRes = R.string.nama_1,
            hpRes = null,
            alamatRes = R.string.alamat_1,
            bgColorRes = R.color.bg_grey
        )

        ProfileCardWidget(
            namaRes = R.string.nama_2,
            hpRes = R.string.hp_2,
            alamatRes = R.string.alamat_2,
            bgColorRes = R.color.bg_purple
        )

        ProfileCardWidget(
            namaRes = R.string.nama_3,
            hpRes = R.string.hp_3,
            alamatRes = R.string.alamat_3,
            bgColorRes = R.color.bg_blue
        )

        ProfileCardWidget(
            namaRes = R.string.nama_4,
            hpRes = R.string.hp_4,
            alamatRes = R.string.alamat_4,
            bgColorRes = R.color.bg_green
        )

        Spacer(modifier = Modifier.weight(1f))

        // Tulisan Copyright di bawah
        Text(
            text = stringResource(id = R.string.copyright),
            fontSize = 10.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

// === FUNGSI WIDGET CARD (Dibuat terpisah sesuai Aturan 2) ===
@Composable
fun ProfileCardWidget(
    namaRes: Int,
    hpRes: Int?, // Nullable karena ada yang tidak pakai nomor HP
    alamatRes: Int,
    bgColorRes: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource(id = bgColorRes))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Logo UMY Kiri
        Image(
            painter = painterResource(id = R.drawable.logo_umy),
            contentDescription = null,
            modifier = Modifier.size(45.dp)
        )

        // Teks di Tengah
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(id = namaRes),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            // Cek kalau nomor HP ada isinya (tidak null)
            if (hpRes != null) {
                Text(
                    text = stringResource(id = hpRes),
                    color = colorResource(id = R.color.text_cyan),
                    fontSize = 12.sp
                )
            }
            Text(
                text = stringResource(id = alamatRes),
                color = Color.White,
                fontSize = 12.sp
            )
        }

        // Logo UMY Kanan
        Image(
            painter = painterResource(id = R.drawable.logo_umy),
            contentDescription = null,
            modifier = Modifier.size(45.dp)
        )
    }
}