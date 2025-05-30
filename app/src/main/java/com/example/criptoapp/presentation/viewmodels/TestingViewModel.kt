package com.example.criptoapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class TestingViewModel @Inject constructor(
    private val testing : String
) : ViewModel(){

    init {
        Log.i("TestingViewModel",testing)
    }
}

@HiltViewModel
class OtroTestingViewModel @Inject constructor(
    private val testing : String
) : ViewModel(){

    init {
        Log.i("OtroTestingViewModel",testing)
    }
}