package com.gobikebank.example.fixhistory.compose

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.gobikebank.example.R

@Preview
@Composable
fun CreateTopAppBarPreview(){
    CreateTopAppBar(title = "title") { }
}

@Composable
fun CreateTopAppBar(title: String, onBackPressed: () -> Unit) {

    TopAppBar(
        backgroundColor = colorResource(id = R.color.toolbar_background_black),
        // 앱바 타이틀 설정
        title = {
            // xml의 TextView 역할)
            Text(
                color = Color.White,
                text = title
            )
        },
        // 레이아웃 기본 설정(xml의 뷰 그룹 설정 역할)
        modifier = Modifier
            .wrapContentHeight(),
        // 네비게이션 버튼 설정
        navigationIcon = {
            // 네비게이션 버턴 설정
            IconButton(
                // 네비게이션 버튼 클릭 이벤트 설정
                onClick = {
                    onBackPressed()
                }
            ) {
                // 네비게이션 아이콘 설정
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    )
}