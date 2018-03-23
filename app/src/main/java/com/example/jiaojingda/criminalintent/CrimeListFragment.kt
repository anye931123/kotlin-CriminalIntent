package com.example.jiaojingda.criminalintent


import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.TextViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_crime_list.*
import kotlinx.android.synthetic.main.list_item_crime.*
import org.jetbrains.anko.find


/**
 * A simple [Fragment] subclass.
 */
class CrimeListFragment : Fragment() {

    lateinit var crimeAdapter: CrimeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_crime_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        crime_recycler_view.layoutManager = LinearLayoutManager(activity)
        updateUI()

    }

    private fun updateUI() {
        val crimeLab = CrimeLab.mCrimes
        crimeAdapter = CrimeAdapter(crimeLab)
        crime_recycler_view.adapter = crimeAdapter
    }


    inner class CrimeHolder(inflater: LayoutInflater?,
                           parent: ViewGroup?,
                           itemView: View = inflater!!.inflate(R.layout.list_item_crime, parent, false)) : RecyclerView.ViewHolder(itemView) {
        val mTitleText=itemView.find<TextView>(R.id.crime_title)
        val mDateText=itemView.find<TextView>(R.id.crime_date)
        val mSolvedImage=itemView.find<ImageView>(R.id.crime_solved)





        fun bind(crime: Crime) {
            mTitleText.text = crime.mTitle
            mDateText.text = crime.mDate.toString()
            mSolvedImage.visibility=if(crime.mSolved) View.VISIBLE else View.GONE
            itemView.setOnClickListener { startActivity(MainActivity.newIntent(activity,crime.mId)) }
        }



    }


    inner class CrimeAdapter(val mCrimes: MutableList<Crime>) : RecyclerView.Adapter<CrimeHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)= CrimeHolder(LayoutInflater.from(activity), parent)


        override fun getItemCount()= mCrimes.size


        override fun onBindViewHolder(holder: CrimeHolder?, position: Int)=holder!!.bind(mCrimes.get(position))

        override fun getItemViewType(position: Int): Int {
            return super.getItemViewType(position)
        }

    }

}// Required empty public constructor
