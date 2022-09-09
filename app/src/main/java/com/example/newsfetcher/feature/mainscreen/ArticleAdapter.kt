package com.example.newsfetcher.feature.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.mainscreen.domain.ArticleModel

class ArticleAdapter(
  //  val OnItemClicked:(Int) ->Unit):
    private val onAddToBookmarksClicked: (Int) -> Unit
):
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {


    private var articlesData: List<ArticleModel> = emptyList()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val ivFavorite: ImageView = view.findViewById(R.id.ivFavorite)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_article, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemView.setOnClickListener {
            onAddToBookmarksClicked.invoke(position)
            notifyDataSetChanged()
            //   OnItemClicked(position)
        }

//        viewHolder.tvTitle.setOnClickListener {
//            onArticleClicked.invoke(articlesData[position])

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.tvTitle.text = articlesData[position].title
        viewHolder.tvDate.text = articlesData[position].publishedAt

        if (articlesData[position].favoriteArticlesChoice)
            viewHolder.ivFavorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
    }

    // Return the size of your dataset (invoked by the layout manager)


    override fun getItemCount() = articlesData.size
    fun setData(articles: List<ArticleModel>) {
        articlesData = articles

        notifyDataSetChanged()
    }
}
