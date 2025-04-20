package com.example.myapplication.Screens.account.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.UserInformation
import com.example.myapplication.repositary.AppRepository

import com.google.firebase.auth.FirebaseAuth

class AccountScreenViewmodel : ViewModel() {
    val email = FirebaseAuth.getInstance().currentUser?.email
    fun fetchUserDetails(info: (UserInformation) -> Unit, failure: (String) -> Unit) {
        if (email != null) {
            AppRepository.userInformat(email = email,
                onSuccess = {
                    info(it)
                },
                onFailure = {
                    failure(it)
                })
        }
    }

    // edit the data
    fun editData(teachergmail:String, data:HashMap<String,Any>,
                 failure: (String) -> Unit,
                 info: () -> Unit
                 ){
        AppRepository.updadeteachersData(
            documentPath =teachergmail,
            failure = {
failure(it)
            },
            successfull = {
info()
            },
            data = data
        )
    }

fun addFeedBack(emailtrim:String,hashMap: HashMap<String,String>,
             success:()->Unit,
                failure: (String) -> Unit
                ){
    AppRepository.addfeedback(
        collectionName = "Feedback",
        documentPath = emailtrim,
        hashMap = hashMap,
        failure = {
failure(it)
        },
        successfull = {
success()
        }
    )

}




}