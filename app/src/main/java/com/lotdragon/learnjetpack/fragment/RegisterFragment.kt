package com.lotdragon.learnjetpack.fragment

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CheckedTextView
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.lotdragon.learnjetpack.R
import com.lotdragon.learnjetpack.databinding.FragmentRegisterBinding
import com.lotdragon.learnjetpack.viewmodel.LoginRegisterViewModel

import kotlinx.coroutines.*


class RegisterFragment : Fragment() {
    private lateinit  var binding: FragmentRegisterBinding
    lateinit var viewModel: LoginRegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)
        viewModel = ViewModelProvider(this).get(LoginRegisterViewModel::class.java)


        binding.registviewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.registerKey.setOnClickListener {
            isCheck(binding.registerKey.isChecked,binding.registerPwd)
        }
        binding.registerKey1.setOnClickListener {
            isCheck(binding.registerKey1.isChecked,binding.registerPwd1)
        }
        binding.registerSub.setOnClickListener {
            viewModel.register(it)

        }
        return binding.root
    }

    fun isCheck(check:Boolean,editText: EditText) {
        if (check) {
            //显示密码
            editText.transformationMethod =
                HideReturnsTransformationMethod.getInstance()
        } else {
            //显示*
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

}