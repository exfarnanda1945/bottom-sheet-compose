package com.example.bottomsheetcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    scope:CoroutineScope,
    modifier:Modifier = Modifier
) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }

    // if skipPartiallyExpanded false, the bottom sheet will show half a screen
    // if true, the bottom sheet will automatically show fullscreen
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(18.dp), contentAlignment = Alignment.Center
    ) {
        Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { openBottomSheet = !openBottomSheet }) {
                Text(text = "Open Bottom Sheet")
            }
        }
    }

    if (openBottomSheet) {
        BottomSheetContent(onClose = {
            openBottomSheet = it
        }, sheetState = bottomSheetState, scope = scope)
    }
}