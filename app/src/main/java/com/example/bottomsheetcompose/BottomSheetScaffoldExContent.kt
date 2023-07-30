package com.example.bottomsheetcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomSheetScaffoldExContent(
    onCloseBottomSheet: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.jci),
                contentDescription = stringResource(R.string.jetpack_compose_logo)
            )
            Text(
                text = stringResource(R.string.jetpack_compose_logo),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                ),
                maxLines = 2, modifier = Modifier.padding(bottom = 12.dp),
            )
            OutlinedButton(
                onClick = {
                    onCloseBottomSheet()
                },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(text = "Close Bottom Sheet")
            }
        }
    }
}