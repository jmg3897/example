package com.gobikebank.example.fixhistory.legacy

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecognizeVinViewModel @Inject constructor(
//    private val bikeBankRepository: BikeBankRepository
) : ViewModel() {

    private var _showLoadingState = MutableLiveData<Boolean>()
    val showLoadingState: LiveData<Boolean>
        get() = _showLoadingState

    private var _toolbarTitle = MutableLiveData<String>()
    val toolbarTitle: LiveData<String>
        get() = _toolbarTitle

    private var _isClearInsertedVin = MutableLiveData<Boolean>(true)
    val isClearInsertedVin: LiveData<Boolean>
        get() = _isClearInsertedVin

    var insertedVin =
        MutableLiveData<String>() // two-way binding을 사용하려면 var로 선언해야됨 (ObservableField는 LiveData로 대체 가능) // 사용자가 입력한 bike SSN

    private var bikeSSN: String = "" // API 응답값으로 온 bikeSSN ( != 사용자가 입력한 bikeSSN)

    private var _alertMessageForCoupon = MutableLiveData<String>()
    val alertMessageForCoupon: LiveData<String> get() = _alertMessageForCoupon

    private var _errorAlertDialogMessage = MutableLiveData<String>()
    val errorAlertDialogMessage: LiveData<String> get() = _errorAlertDialogMessage

//    private var _startCouponActivity = SingleLiveEvent<Unit>()
//    val startCouponActivity: LiveData<Unit>
//        get() = _startCouponActivity

    fun setToolbarTitle(title: String) {
        _toolbarTitle.value = title
    }

    fun clearInsertedVin() {
        insertedVin.value = EMPTY_INSERTED
        _isClearInsertedVin.value = true
    }

    fun changeInsertedVinState() {
        _isClearInsertedVin.value =
            insertedVin.value == EMPTY_INSERTED // isClearInsertedVin 이 true 면, 입력칸 우측 X 버튼 안 보이게 해줌. false 인 경우 우측 X 버튼 보이게 해줌
    }

    suspend fun getWarningInfo(): String {
//        val warning = bikeBankRepository.getWarning().resultData[0]
//        if (warning.msgFlag == WARNING_MESSAGE_EXISTED_STATE) {
//            return warning.msg
//        }
        return ""
    }

    /*********************************************************************************************************************
     * 쿠폰 리스트 조회 목적이 아닌, 사용자가 입력한 차량번호(혹은 차대번호)에 대해 알림창을 띄워줘야하는 경우를 체크해 알림창을 띄워주는 목적
     *  - 미수 채권이 발생된 차량
     *  - 선납 차량
     *
     * 쿠폰 리스트 조회는 CouponActivity 에서 진행될 예정
     * 따라서 getCouponList()는 RecognizeVinActivity 에서 1번째 호출, CouponActivity 에서 2번째 호출 됨
     *
     * - RecognizeVinActivity 에서 getCouponList() 호출한 뒤 쿠폰 리스트를 CouponActivity 에서 넘기면 1번 호출로 끝날텐데 2번 호출한 이유
     *      - intent 로 용량이 큰 배열 등을 넘기면 에러 발생 후 데이터 유실될 수 있다는 구글링 자료를 보고 API를 한 번 더 호출하기로 결정함..
     *********************************************************************************************************************/
//    suspend fun getCouponResponse(): String {
//        _showLoadingState.value = true

//        val response = bikeBankRepository.getCouponList(insertedVin.value ?: EMPTY_INSERTED)
//        Log.d(TAG, "ssn: ${insertedVin.value}")
//        Log.d(TAG, "coupon response: $response")
//
//        if (!response.coupons.isNullOrEmpty()) {
//            bikeSSN = response.coupons[0].bikeSsn // 응답값으로 내려온 bikeSSN 을 저장해두고 CouponActivity 에서는 차대번호, 차량번호
//        }
//
//        when (response.code) {
//            ACCOUNTS_RECEIVABLE_IS_EXIST_RESPONSE_CODE -> {
//                // 알림을 띄워야하는 경우, 알림 dialog 속 확인 버튼을 눌러야 쿠폰 리스트 화면으로 넘어가도록 구현
//                _alertMessageForCoupon.value = response.message.replace("\\n", "\n")
//            }
//
//            PREPAID_VEHICLE_RESPONSE_CODE -> {
//                _alertMessageForCoupon.value = response.message.replace("\\n", "\n")
//            }
//
//            SUCCESS_CODE -> {
//
//            }
//
//            else -> {
//                _errorAlertDialogMessage.value = response.message
//            }
//        }
//        _showLoadingState.value = false
//        return response.code
//    }

    fun setInsertedVin(vin: String) {
        insertedVin.value = vin
    }

    fun getBikeSSN(): String {
        return bikeSSN
    }

    companion object {
        const val ACCOUNTS_RECEIVABLE_IS_EXIST_RESPONSE_CODE = "11" // 미수 채권이 발생된 차량
        const val PREPAID_VEHICLE_RESPONSE_CODE = "31" // 선납 차량
        const val SUCCESS_CODE = "OK"

        private val TAG = RecognizeVinActivity::class.java.simpleName

        private const val EMPTY_INSERTED = ""
        private const val WARNING_MESSAGE_EXISTED_STATE = "Y"
    }
}