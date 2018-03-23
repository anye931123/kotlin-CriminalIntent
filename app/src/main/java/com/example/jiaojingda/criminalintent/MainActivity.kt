package com.example.jiaojingda.criminalintent

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return CrimeFragment()
    }
    companion object{
        val EXTRA_CRIME_ID="com.example.jiaojingda.criminalintent.crime_id"
     fun newIntent(packageContext: Context,crimeId:UUID):Intent{
        val intent=Intent(packageContext,MainActivity::class.java)
        intent.putExtra(EXTRA_CRIME_ID,crimeId)

        return intent
    }
    }

}
