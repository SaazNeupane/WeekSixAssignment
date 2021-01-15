package com.example.week6softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.week6softuser.fragments.AboutusFragment
import com.example.week6softuser.fragments.AddstudentFragment
import com.example.week6softuser.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var listtitle: ArrayList<String>
    private lateinit var listfragments: ArrayList<Fragment>
    private lateinit var llhome: LinearLayout
    private lateinit var lladd: LinearLayout
    private lateinit var llabout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llhome = findViewById(R.id.llhome)
        lladd = findViewById(R.id.lladd)
        llabout = findViewById(R.id.llabout)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.llcontent, HomeFragment())
            addToBackStack(null)
            commit()
        }

        llhome.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.llcontent, HomeFragment())
                addToBackStack(null)
                commit()
            }
        }
        lladd.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.llcontent, AddstudentFragment())
                addToBackStack(null)
                commit()
            }
        }
        llabout.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.llcontent, AboutusFragment())
                addToBackStack(null)
                commit()
            }
        }

//        viewpager= findViewById(R.id.viewpager)
//        tablayout= findViewById(R.id.tablayout)
////
//        populateList()
//        val adapter = ViewPagerAdapter(listfragments,supportFragmentManager,lifecycle)
////
//        viewpager.adapter=adapter
//        TabLayoutMediator(tablayout,viewpager){ tab,position ->
//            tab.text=listtitle[position]
//            for (i in listtitle.indices){
//                tablayout.getTabAt(i)?.setIcon(listicon[i])
//            }
//        }.attach()
////    }
//    private fun populateList(){
//        listtitle=ArrayList<String>()
//        listtitle.add("Home")
//        listtitle.add("Add Student")
//        listtitle.add("About Us")
//        listfragments=ArrayList<Fragment>()
//        listfragments.add(HomeFragment())
//        listfragments.add(AddstudentFragment())
//        listfragments.add(AboutusFragment())
//    }
    }
}