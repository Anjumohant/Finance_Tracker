package com.example.finance_tracker.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.finance_tracker.MainActivity
import com.example.finance_tracker.R
import com.example.finance_tracker.databinding.FragmentUserDetailsBinding

class UserDetails : Fragment() {

    lateinit var binding:FragmentUserDetailsBinding
    lateinit var userDetails: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        getActivity()?.getWindow()?.setStatusBarColor(ContextCompat.getColor(requireActivity(), R.color.background))
        binding=  FragmentUserDetailsBinding.inflate(inflater, container, false)
        setData()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {

        userDetails = requireActivity().getSharedPreferences("UserDetails", AppCompatActivity.MODE_PRIVATE)
        binding.next.setOnClickListener {
            saveUserData()
        }
    }

    private fun goToNextScreen() {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
    }

    private fun saveUserData() {
        val monthly_budget = binding.editMoney.text.toString()
        val yearly_budget = binding.editYearMoney
        if(monthly_budget.equals("") || yearly_budget.text.toString().equals("")) {
            Toast.makeText(requireActivity(), "Enter all details to continue...", Toast.LENGTH_SHORT).show()
        }else{
            val editor: SharedPreferences.Editor = userDetails.edit()
            editor.putBoolean("isFirstTime", false)
            editor.putString("MonthlyBudget", monthly_budget)
            editor.putString("YearlyBudget", yearly_budget.text.toString())
            editor.apply()
            goToNextScreen()
        }
    }



}