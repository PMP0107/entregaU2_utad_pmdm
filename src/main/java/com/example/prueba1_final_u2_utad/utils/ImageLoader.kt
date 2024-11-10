import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageLoader {
    fun loadImage(view: ImageView, imageResource: Int) {
        Glide.with(view.context)
            .load(imageResource)
            .into(view)
    }
}
