package com.gobikebank.example.fixhistory.common.data

import com.gobikebank.example.fixhistory.common.model.FixHistories

// 테스트 더미 데이터
object Dummy {
    fun dataProvider(): List<FixHistories.FixHistory> =
        listOf(
            FixHistories.FixHistory(
                "XR202306260410",
                "주식회사 쌍용모터스",
                "-",
                "2023-06-26",
                "0",
                "0",
                "0",
                "KR모터스",
                "그란투스",
                "RFGLFB301NSB02760",
                "대구달서자0501"
            ),
            FixHistories.FixHistory(
                "C23032400221",
                "대구서구대리점",
                "-",
                "2023-03-24",
                "0",
                "0",
                "0",
                "KR모터스",
                "그란투스",
                "RFGLFB301NSB02760",
                "대구달서자0501"
            ),
            FixHistories.FixHistory(
                "XR202306260410",
                "주식회사 쌍용모터스",
                "-",
                "2023-06-26",
                "0",
                "0",
                "0",
                "KR모터스",
                "그란투스",
                "RFGLFB301NSB02760",
                "대구달서자0501"
            ),
            FixHistories.FixHistory(
                "XR202306260410",
                "주식회사 쌍용모터스",
                "-",
                "2023-06-26",
                "0",
                "0",
                "0",
                "KR모터스",
                "그란투스",
                "RFGLFB301NSB02760",
                "대구달서자0501"
            ),
        )
}