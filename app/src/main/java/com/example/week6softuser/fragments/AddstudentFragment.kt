package com.example.week6softuser.fragments

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.week6softuser.Data
import com.example.week6softuser.MainActivity
import com.example.week6softuser.R
import com.example.week6softuser.adapter.UserAdapter

class AddstudentFragment : Fragment() {
    private lateinit var etname:EditText
    private lateinit var etage:EditText
    private lateinit var etaddress:EditText
    private lateinit var btnsave:Button
    private lateinit var rggender: RadioGroup
    private lateinit var rbmale: RadioButton
    private lateinit var rbfemale: RadioButton
    private lateinit var rbothers: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_addstudent, container, false)

        etname=view.findViewById(R.id.etname)
        etage=view.findViewById(R.id.etage)
        etaddress=view.findViewById(R.id.etaddress)
        rggender=view.findViewById(R.id.rggender)
        btnsave=view.findViewById(R.id.btnsave)
        rbmale=view.findViewById(R.id.rbmale)
        rbfemale=view.findViewById(R.id.rbfemale)
        rbothers=view.findViewById(R.id.rbothers)

        btnsave.setOnClickListener {
            if (checkEmpty()) {
                getValue()
            }
        }
        rggender.check(R.id.rbmale)
        return view
    }
    private fun getValue(){
        val name = etname.text.toString()
        val age = etage.text.toString().toInt()
        val address = etaddress.text.toString()
        var gender = ""
        if (rbmale.isChecked){
            gender= rbmale.text.toString()
        }
        else if (rbfemale.isChecked){
            gender= rbfemale.text.toString()
        }
        else if (rbothers.isChecked){
            gender= rbothers.text.toString()
        }

        HomeFragment.userdata.add(Data(name, age, gender, address))
        Toast.makeText(context, "Student Added", Toast.LENGTH_SHORT).show()
        reset()
    }

    private fun checkEmpty(): Boolean{
        var flag=true

        if(TextUtils.isEmpty(etname.text)){
            etname.setError("Please enter your name")
            etname.requestFocus()
            flag = false
        }
        else if(TextUtils.isEmpty(etage.text)){
            etage.setError("Please enter your age")
            etage.requestFocus()
            flag = false
        }
        else if(TextUtils.isEmpty(etaddress.text)){
            etaddress.setError("Please enter your address")
            etaddress.requestFocus()
            flag = false
        }
        return flag
    }
    private fun reset(){
        etname.setText("")
        etaddress.setText("")
        etage.setText("")
    }
}