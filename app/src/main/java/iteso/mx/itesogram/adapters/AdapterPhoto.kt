package iteso.mx.itesogram.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parse.ParseFile
import com.parse.ParseObject
import iteso.mx.itesogram.R

class AdapterPhoto (private val users: List<ParseObject>) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(users[position])
    }
}

class PhotoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val username: TextView = view.findViewById(R.id.item_photo_username_tv)
    private val image: ImageView = view.findViewById(R.id.item_photo_photo_iv)
    private val comments: TextView = view.findViewById(R.id.item_photo_likes_tv)

    fun bind(user: ParseObject) {
        val parseFile: ParseFile = user.get("photo") as ParseFile
        Glide.with(view).load(parseFile.url).into(image)
        username.text = user.get("username") as String
        comments.text = user.get("comments") as String
    }
}