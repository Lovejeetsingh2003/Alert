package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var tvAlert : TextView
    lateinit var btnToast : Button
    lateinit var btnSnackbar : Button
    lateinit var btnalertDialog : Button
    lateinit var btnCoustomDialog : Button

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvAlert = findViewById(R.id.tvAlert)
        btnToast = findViewById(R.id.btnToast)
        btnSnackbar = findViewById(R.id.btnSnackbar)
        btnalertDialog = findViewById(R.id.btnalertDialog)
        btnCoustomDialog = findViewById(R.id.btnCoustomDialog)

        btnToast.setOnClickListener {
            Toast.makeText(this, "This is Toast", Toast.LENGTH_LONG).show()
        }
        btnSnackbar.setOnClickListener {
            var snackbarview = Snackbar.make(btnSnackbar, "This is Snackbar", Snackbar.LENGTH_LONG)
            snackbarview.show()
            snackbarview.setAnchorView(R.id.btnSnackbar)
            snackbarview.setAction("click") {
                Toast.makeText(this, "Snackbar", Toast.LENGTH_LONG).show()
            }
        }
        btnalertDialog.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Alert Tittle")
                .setMessage("Alert Dialog")
                .setCancelable(false)
                .setPositiveButton("Positive"){_,_->
                    Toast.makeText(this,"Positive Button Click",Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Negative"){_,_->
                    Toast.makeText(this,"Negative Button Click",Toast.LENGTH_LONG).show()
                }
                .setNeutralButton("Neutral"){_,_->
                    Toast.makeText(this,"Neutral Buttton Click",Toast.LENGTH_LONG).show()
                }
                .show()
        }
        btnCoustomDialog.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.coustom_dialog)
            dialog.show()
            var btnSet = dialog.findViewById<Button>(R.id.btnSet)
            var btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
            var etName = dialog.findViewById<EditText>(R.id.etName)

            val t1 = tvAlert.text
            etName.setText(t1)
            btnSet.setOnClickListener {

                if (etName.text.toString().isEmpty())
                {
                    etName.error = "Enter"
                }
                else{
                    Toast.makeText(this,"Set",Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                    val name = etName.text
                    tvAlert.text = name
                }

            }
            btnCancel.setOnClickListener {
                Toast.makeText(this,"Cancel",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
        }
    }
}

