package com.example.jiaojingda.criminalintent

import java.util.*

/**
 * Created by jiaojingda on 2018/3/22.
 */
data class Crime(val mId:UUID= UUID.randomUUID()){
    lateinit var mTitle:String
    var mSolved:Boolean = false
    var mDate:Date=Date()
}