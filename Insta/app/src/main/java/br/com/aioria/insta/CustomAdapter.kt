package com.example.filmes;

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.aioria.insta.MainActivity
import br.com.aioria.insta.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_insta.view.*


class CustomAdapter(var context: Context, var postList: ArrayList<Post>) : androidx.recyclerview.widget.RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_insta, parent, false)
        return ViewHolder(v, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(postList[position])
    }


    override fun getItemCount(): Int {
        return postList.size
    }

    fun updateList(list:ArrayList<Post>){
        postList = list;
        notifyDataSetChanged()

    }

    fun clearList(){
        postList.clear();
        notifyDataSetChanged()
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View, var ctx: Context) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Post) {

            itemView.txtName.text = item.name
            itemView.txtUsername.text = "@" + item.username
            Picasso.get().load( item.image ).fit().centerCrop().into( itemView.imagePhoto )
            itemView.txtLikes.text = item.likes.toString()
            //itemView.setOnClickListener {
                // Toast the values
            //    Toast.makeText(ctx,
             //       "Position :$adapterPosition\nItem Value : $item", Toast.LENGTH_LONG)
             //       .show()
           // }
            itemView.txtDesc.text = item.desc
            itemView.btExcluir.setOnClickListener{view ->
                if ( ctx is MainActivity){
                    ( ctx as MainActivity).deletePost( item.id)
                }

            }
            itemView.imagePhoto.setOnLongClickListener{ view ->
                if ( ctx is MainActivity){
                    ( ctx as MainActivity).likePost( item.id)
                }
                true
        }
            itemView.btLike.setOnClickListener { view ->
                if ( ctx is MainActivity){
                    ( ctx as MainActivity).likePost( item.id)
                } }
            }
        }
    }