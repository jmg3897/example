package com.gobikebank.example.fixhistory.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gobikebank.example.R
import com.gobikebank.example.fixhistory.common.data.Dummy
import com.gobikebank.example.fixhistory.common.model.FixHistories


class FixHistoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { // 컴포즈 레이아웃 적용(기존 setContentView의 역할)
            CreateFixHistoryView { finish() }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CreateFixHistoryPreview() {
    CreateFixHistoryView { }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateFixHistoryView(onBackPressed: () -> Unit) {
    Scaffold(// 상단 앱바, 하단 앱바 등의 뷰의 결합을 쉽게 해주는 뷰그룹 역할
        topBar = { // scaffold의 앱바 설정
            CreateTopAppBar(
                title = stringResource(id = R.string.fix_history_text),
                onBackPressed = onBackPressed
            )
        }
    ) {
        Column { // xml의 수직 리니어 뷰그룹 역할
            SetList()
        }
    }
}

@Composable
fun SetList() {
    val data = remember { Dummy.dataProvider() }

    LazyColumn(  // xml의 리사이클러뷰 역할
        modifier = Modifier // LazyColum의 기본 설정
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.customer_app_background_grey))
    )
    {
        // 리사이클러 뷰 어뎁터의 onCreateViewHolder,onBindViewHolder 역할
        items(items = data, itemContent = {
            // LazyColum의 커스텀 아이템 뷰
            DataListItem(data = it)
        })
    }
}

@Composable
fun DataListItem(data: FixHistories.FixHistory) {
    Box( // xml의 프레임 뷰그룹 역할
        modifier = Modifier
            .background(colorResource(id = R.color.customer_app_background_grey))
            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
    ) {
        Box( // xml의 프레임 뷰그룹 역할
            modifier = Modifier.background(Color.White)
        ) {
            Row( // xml의 수평 리니어 뷰그룹 역할
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {

                Spacer(modifier = Modifier.width(8.dp))
                Column( // xml의 수직 리니어 뷰그룹 역할
                    modifier = Modifier
                        .wrapContentWidth()
                        .weight(1f, true),
                    verticalArrangement = Arrangement.Top,
                ) {
                    Row( // xml의 수평 리니어 뷰그룹 역할
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        Text( // xml의 TextView
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            text = data.corpName,
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .width(0.dp)
                                .wrapContentHeight()
                                .weight(1f, true)
                        )
                        Text( // xml의 TextView
                            color = colorResource(id = R.color.item_fix_history_shop_name_text_black),
                            text = data.repairDate,
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                        )
                    }
                    Text( // xml의 TextView
                        color = colorResource(id = R.color.item_fix_history_shop_name_text_black),
                        text = data.shopName,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .wrapContentHeight()
                            .fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        Text( // xml의 TextView
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            text = data.makerName,
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .padding(end = 8.dp)
                        )
                        Text( // xml의 TextView
                            fontSize = 14.sp,
                            text = data.bikeName,
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                                .padding(end = 8.dp)
                        )
                        Text( // xml의 TextView
                            fontSize = 14.sp,
                            text = data.bikeSsn,
                            modifier = Modifier
                                .wrapContentHeight()
                                .wrapContentWidth()
                        )
                    }
                }
            }
        }
    }
}
