package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)
        viewModel= ViewModelProvider(this).get(ViewModel::class.java)
        binding.viewmodel = viewModel
        binding.mContext = this
        binding.lifecycleOwner = this

        viewModel.textData.value = "Test Data"
        viewModel.emailText.observe(this, Observer{
            if (viewModel.isEmailValid(it.toString())){
                Log.e("Email Text",it.toString())
                viewModel.error2.value= null
            }else {
                viewModel.error2.value="This email is not Valid"
            }

        })

        viewModel.editText.observe(this, Observer {
            Log.e("TextWatcher",it.toString())
        })

        viewModel.imageUrl.value = getString(R.string.string_picture)
    }
}