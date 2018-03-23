package com.example.jiaojingda.criminalintent

import android.content.Context
import java.util.*

/**
 * Created by jiaojingda on 2018/3/22.
 */
object CrimeLab {
      val mCrimes:MutableList<Crime> = mutableListOf()
    init{
        for(i in 0 until  100){
            var crime=Crime()
            crime.mTitle= "Crime #$i"
            crime.mSolved=(i%2==0)
            mCrimes.add(crime)
        }
    }
    fun getCrime(id:UUID):Crime?{
        for (crime:Crime in mCrimes){
            if(crime.mId == id){
                return crime
            }
        }
        return null
    }
}