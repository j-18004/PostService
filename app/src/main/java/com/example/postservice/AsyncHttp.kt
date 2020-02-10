package com.example.postservice

import android.os.AsyncTask

import android.util.Log


import java.io.IOException

import java.io.OutputStream

import java.net.HttpURLConnection

import java.net.MalformedURLException

import java.net.URL


/**
 *
 * Created by shiozaki on 2017/02/06.
 *
 */


class AsyncHttp(internal var name: String, internal var value: Double) : AsyncTask<String, Int, Boolean>() {
    internal var urlConnection: HttpURLConnection? = null
    internal var flg: Boolean? = false
    //非同期処理ここから
    override fun doInBackground(vararg contents: String): Boolean? {
        val urlinput = "http://10.206.0.227/upload/post.php"
        try {
            val url = URL(urlinput)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection!!.requestMethod = "POST"
            urlConnection!!.doOutput = true
            //POST用パラメータ
            val postDataSample = "name=$name&text=$value"
            //POSTパラメータ設定
            val out = urlConnection!!.outputStream
            out.write(postDataSample.toByteArray())
            out.flush()
            out.close()
            Log.d("test", postDataSample)
            //レスポンスを受け取る
            urlConnection!!.inputStream
            flg = true
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return flg
    }

}

