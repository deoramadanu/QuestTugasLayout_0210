package com.example.tugaslayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
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
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
    }
}
// Judul Atas
Text(
text = stringResource(id = R.string.fakultas),
fontWeight = FontWeight.Bold,
fontSize = 20.sp
)Text(
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
// === FUNGSI WIDGET CARD (Dibuat terpisah sesuai Aturan 2) ===
@Composable
fun ProfileCardWidget(
    namaRes: Int,
    hpRes: Int?,
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
    }
}