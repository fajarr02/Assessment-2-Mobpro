package org.d3if3141.asessment2mobpro.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.d3if3141.asessment2mobpro.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, id: Long? = null) {
    val viewModel: DetailViewModel = viewModel()

    var nama by remember { mutableStateOf("") }
    var jumlah by remember { mutableStateOf("") }
    var tenggat by remember { mutableStateOf("") }


    val radioOptions = listOf(
        stringResource(id = R.string.tigabln),
        stringResource(id = R.string.enambln)
    )

    if (id != null) {
        val data = viewModel.getPeminjaman(id)
        nama = data.nama
        jumlah = data.jumlah
        tenggat = data.tenggat
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.kembali),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    if (id == null)
                        Text(text = stringResource(id = R.string.tambah_peminjaman))
                    else
                        Text(text = stringResource(id = R.string.edit_peminjaman))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = stringResource(id = R.string.simpan),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { padding ->
        FormPeminjaman(
            nama = nama,
            onNamaChange = { nama = it },
            jumlah = jumlah,
            onJumlahChange = { jumlah = it },
            tenggat = tenggat,
            onTenggatChange = { tenggat = it },
            radioOptions = radioOptions,
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun FormPeminjaman(
    nama: String, onNamaChange: (String) -> Unit,
    jumlah: String, onJumlahChange: (String) -> Unit,
    tenggat: String, onTenggatChange: (String) -> Unit,
    radioOptions: List<String>,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = nama,
            onValueChange = { onNamaChange(it) },
            label = { Text(text = stringResource(R.string.nama)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = jumlah,
            onValueChange = { onJumlahChange(it) },
            label = { Text(text = stringResource(R.string.jumlah)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ) {
            radioOptions.forEach{ text ->
                PeminjamanOption(
                    label = text,
                    isSelected = tenggat == text,
                    onOptionSelected = { onTenggatChange(text)},
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun PeminjamanOption(
    label: String,
    isSelected: Boolean,
    onOptionSelected: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier.clickable (onClick = onOptionSelected),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null // RadioButton di-handle oleh onClick di Row
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {
    MaterialTheme {
        DetailScreen(rememberNavController())
    }
}


