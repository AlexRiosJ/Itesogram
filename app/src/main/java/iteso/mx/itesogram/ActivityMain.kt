package iteso.mx.itesogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.ParseObject
import com.parse.ParseQuery
import iteso.mx.itesogram.adapters.AdapterPhoto

class ActivityMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_photos_rv)
        val query: ParseQuery<ParseObject> = ParseQuery.getQuery("Feed")
        query.findInBackground { objects, e ->
            if (e == null) {
                recyclerView.adapter = AdapterPhoto(objects)
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }
    }
}