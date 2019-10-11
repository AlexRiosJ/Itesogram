package iteso.mx.itesogram.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parse.ParseObject
import iteso.mx.itesogram.R
import kotlinx.android.synthetic.main.activity_login.view.*

class AdapterPhoto (private val names: List<ParseObject>): RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int = names.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(names[position])
    }
}

class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val username: TextView = view.findViewById(R.id.item_photo_username_tv)
    private val photo: ImageView = view.findViewById(R.id.item_photo_photo_iv)
    private val likes: TextView = view.findViewById(R.id.item_photo_likes_tv)

    fun bind(user: ParseObject) {
        var feed = Feed()

        username.text = feed.username

    }
}