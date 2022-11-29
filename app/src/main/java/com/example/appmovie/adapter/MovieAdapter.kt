package com.example.appmovie.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.appmovie.DetailMovieActivity
import com.example.appmovie.R
import com.example.appmovie.databinding.ItemRowBinding
import com.example.appmovie.response.MovieList

class MovieAdapter :  RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    private lateinit var binding: ItemRowBinding
    private lateinit var context: Context

    //Адаптер создает каждый новый элемент списка, возвращаем объект класса ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemRowBinding.inflate(inflater,parent, false)
        context = parent.context
        return ViewHolder()
    }

    //обновление элемента списка RecyclerView в конкретной позиции
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    //Адаптер должен знать количество элементов в RecyclerView
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    //inner класс имеет доступ к свойствам и функциям внешнего класса
    inner class ViewHolder: RecyclerView.ViewHolder(binding.root){
        // здесь заполняются данные из response во View
        fun bind(item: MovieList.Item){
            binding.apply {
                tvMovieName.text = item.title
                tvRate.text = item.imDbRating
                val moviePosterURL =  item.image
                imgMovie.load(moviePosterURL){
                    crossfade(true)
                    placeholder(R.drawable.poster_placeholder)
                    scale(Scale.FILL)
                }
                tvCrew.text = item.rankUpDown
                tvDate.text = item.year

                root.setOnClickListener {
                   val intent = Intent(context, DetailMovieActivity::class.java)
                  intent.putExtra("id", item.id)
                 context.startActivity(intent)
                }
            }
        }
    }

    private val differCallback = object :
        DiffUtil.ItemCallback<MovieList.Item>(){

        //проверяем два объекта из нового и старого списка по времени публикации
        //что они представляют один и тот же элемент
        override fun areItemsTheSame(
            oldItem: MovieList.Item,
            newItem: MovieList.Item
        ): Boolean {
            return oldItem.id == newItem.id
        }

        //проверяем два объекта из нового и старого списка на одинаковые данные
        //вызывается когда areItemsTheSame() вернет true
        override fun areContentsTheSame(
            oldItem: MovieList.Item,
            newItem: MovieList.Item
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
}