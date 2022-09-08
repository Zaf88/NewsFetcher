package com.example.newsfetcher.feature.mainscreen.articleInfoFragment.di

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.newsfetcher.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import java.util.concurrent.Executors

class ArticleInfoFragment: Fragment(R.layout.fragment_news_info)  {

    private val viewModel: ArticleInfoViewModel by viewModel()
    private val articleImage: ImageView by lazy { requireActivity().findViewById(R.id.newImage) }
    private val btnBack: ImageView by lazy { requireActivity().findViewById(R.id.btnBackToArticleList) }
    private val collToolBar: CollapsingToolbarLayout by lazy { requireActivity().findViewById(R.id.main_collapsing)}
    private val descriptionInfo: TextView by lazy { requireActivity().findViewById(R.id.tvNewInfo) }
    private val urlInfo: TextView by lazy { requireActivity().findViewById(R.id.tvNewUrl) }

    companion object {
        fun getNewInstance(args: Bundle?) : ArticleInfoFragment {
            val articleInfoFragment = ArticleInfoFragment()
            articleInfoFragment.arguments = args
            return articleInfoFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)


        val title = arguments?.get("title").toString()
        val author = arguments?.get("author").toString()
        val url = arguments?.get("url").toString()
        val content = arguments?.get("content").toString()
        val description = arguments?.get("description").toString()
        val publishedAt = arguments?.get("publishedAt").toString()
        val urlToImage = arguments?.get("urlToImage").toString()

        viewModel.processUiEvent(DataEvent.ShowArticle(title,description, url, urlToImage))


        urlInfo.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)

        }


        btnBack.setOnClickListener {

            parentFragmentManager.beginTransaction().remove(this).commit()
        }


    }
    private fun render(viewState: ViewState) {
        collToolBar.title = viewState.articleTitle
        descriptionInfo.text = viewState.articleDescription
        urlInfo.text = viewState.articleLink
        viewState.articleUrlToImage?.let { getImageOfArticleFromUrl(it) }
    }



    private fun getImageOfArticleFromUrl(urlToImage: String) {
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap?
        executor.execute {
            try {
                val `in` = java.net.URL(urlToImage).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    articleImage.setImageBitmap(image)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}
