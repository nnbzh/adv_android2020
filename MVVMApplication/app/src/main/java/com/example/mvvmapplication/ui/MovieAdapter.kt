import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapplication.R
import com.example.mvvmapplication.data.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(
    var movies: List<Movie>? = null,
    var itemClickListener: RvItemClickListener? = null
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var number = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recy_feed, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies?.size ?: 0
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies?. get(position))
    }

    fun clearAll() {
        number = 1
        (movies as? ArrayList<Movie>)?.clear()
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val view : View): RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie?) {

            val title = view.findViewById<TextView>(R.id.tvTitle)
            val rating = view.findViewById<TextView>(R.id.tvRating)
            val releaseDate = view.findViewById<TextView>(R.id.tvReleaseDate)
            val poster = view.findViewById<ImageView>(R.id.ivBanner)


            if (movie?.position == 0) {
                movie.position = number
                number++
            }

            title.text = movie?.title
            rating.text = movie?.voteAverage.toString()
            releaseDate.text = movie?.releaseDate


            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500" + movie?.posterPath)
                .into(poster)
            view.setOnClickListener {
                movie?.let { it1 -> itemClickListener?.itemClick(adapterPosition, it1) }
            }

        }
    }


    interface RvItemClickListener {
        fun itemClick(position: Int, movie: Movie)
    }
}