package com.example.jiaojingda.criminalintent


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast

import kotlinx.android.synthetic.main.fragment_crime.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class CrimeFragment : Fragment() {

    lateinit var mCrime:Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val crimeId:UUID= activity.intent.getSerializableExtra(MainActivity.EXTRA_CRIME_ID) as UUID
        mCrime= CrimeLab.getCrime(crimeId)!!
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return  inflater!!.inflate(R.layout.fragment_crime, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        crime_title.hint=mCrime.mTitle
        crime_date.text=mCrime.mDate.toString()
        crime_solved.isChecked=mCrime.mSolved
        crime_title?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun afterTextChanged(p0: Editable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        crime_date?.text=mCrime.mDate.toString()
        crime_date?.isEnabled=false
        crime_solved?.setOnCheckedChangeListener { _, p1 -> mCrime.mSolved=p1 }
    }

}// Required empty public constructor
