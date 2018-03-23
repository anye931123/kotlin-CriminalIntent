package com.example.jiaojingda.criminalintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_list)

        val fm=supportFragmentManager
        var fragment=fm.findFragmentById(R.id.fragment_container)
        if(fragment==null){
            fragment=createFragment()
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit()
        }
    }

    abstract fun createFragment():Fragment
}
