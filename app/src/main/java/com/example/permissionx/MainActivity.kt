package com.example.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.permissionx.databinding.ActivityMainBinding
import com.permissionx.zhouguangwendev.PermissionX

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.makeCallBtn.setOnClickListener {
            PermissionX.request(this, Manifest.permission.CALL_PHONE){
                allGranted,deniedList->
                if (allGranted){
                    call()
                }else{
                    Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun call(){
        val intent=Intent(Intent.ACTION_CALL)
        intent.data=Uri.parse("tel:10086")
        startActivity(intent)
    }
}