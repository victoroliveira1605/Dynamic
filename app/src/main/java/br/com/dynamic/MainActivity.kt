package br.com.dynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import org.json.JSONObject
import androidx.constraintlayout.widget.ConstraintSet




class MainActivity : AppCompatActivity() {

    private val obj:JSONObject = JSONObject(
        """
        {
        "name":"InputType.TYPE_CLASS_TEXT", 
        "sobrenome":"InputType.TYPE_CLASS_TEXT", 
        "telefone":InputType.TYPE_CLASS_NUMBER
        }
        """
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintSet  = ConstraintSet()
        val constraintLayout = findViewById<ConstraintLayout>(R.id.main_constraint)

        val objIterator = obj.keys().iterator()
        while (objIterator.hasNext()) {

            val edit = EditText(this)
            edit.id = View.generateViewId()
            edit.setText(objIterator.next())
            constraintLayout.addView(edit)

            constraintSet.clone(constraintLayout);
            constraintSet.applyTo(constraintLayout);

            Toast.makeText(this,objIterator.next(),Toast.LENGTH_LONG).show()
        }
    }
}