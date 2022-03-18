package com.isroot.schemecallee

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.isroot.schemecallee.databinding.ActivityCalleeBinding

class CalleeActivity : AppCompatActivity() {
    lateinit var binding : ActivityCalleeBinding
    var resultData = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_callee)

        val intent = intent
        if (intent.action.equals(Intent.ACTION_VIEW)) {
            val uri = intent.data
            val responseData1 = uri?.getQueryParameter("data1")!!.toInt()
            val responseData2 = uri.getQueryParameter("data2")!!.toInt()
            resultData = responseData1 + responseData2
        }

        binding.button.setOnClickListener {
            requestTestApp()
        }
    }

    private fun requestTestApp() {
        val schemeUrl = "scheme_test://test_action_result?result=$resultData"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(schemeUrl))
        startActivity(intent)
    }
}