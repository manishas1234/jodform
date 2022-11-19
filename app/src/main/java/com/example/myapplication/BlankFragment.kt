package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentBlankBinding
import com.example.myapplication.db.UserEntity

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    private lateinit var adapter: DataAdapter
    private lateinit var viewModel: viewModel
    private lateinit var name:String
    private lateinit var email: String
    private lateinit var hobbies:List<fence>
    private lateinit var fixit:List<fix>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentBlankBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(com.example.myapplication.viewModel::class.java)
        binding.recyc.layoutManager= LinearLayoutManager(context)
        adapter= DataAdapter()
        viewModel.readallData.observe(viewLifecycleOwner, Observer { entity ->
            if (entity != null) {
                adapter.setData(entity)
            }

        })
        binding.recyc.adapter= adapter

        binding.Button.setOnClickListener {
               insertDatatoDataBase()
        }
        return binding.root
    }

     fun insertDatatoDataBase() {
         name = binding.nameInput.text.toString()
         email = binding.email.text.toString()
        validatename(name,email)


    }

     fun validatename(name: String, email: String) {
        binding.nameInput.error= null
        binding.email.error= null

        if (TextUtils.isEmpty(name) && TextUtils.isEmpty((email)))
        {
            binding.nameInput.error="Please enter name"
            binding.email.error="Enter email"
        }
        else if (TextUtils.isEmpty(name))
        {
            binding.nameInput.error="Please enter name"
        }
        else if(TextUtils.isEmpty(email))
        {
            binding.email.error="Enter email"

        }
        else
        {
            binding.nameInput.error=null
             binding.email.error = null
             dataenter()

        }


    }

    fun dataenter() {

        fixit = listOf(fix("5","jfhjhjf","kkjdjkjdk"))
        hobbies = listOf(fence("ok","na", fixit))

        val hobbi = ArrayList<String>()
        hobbi.add("swimm")
        hobbi.add("njfhjfh")

        val entry =UserEntity(0,name,email,hobbies)
        viewModel.insertUserInfo(entry)
    }


}