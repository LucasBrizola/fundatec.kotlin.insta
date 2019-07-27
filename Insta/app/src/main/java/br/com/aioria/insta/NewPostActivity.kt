package br.com.aioria.insta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.example.filmes.Post
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_new_post.*
import kotlinx.android.synthetic.main.activity_new_post.txtDesc
import kotlinx.android.synthetic.main.activity_new_post.txtUsername
import kotlinx.android.synthetic.main.item_insta.*
import java.lang.reflect.Method

class NewPostActivity : AppCompatActivity() {

    private var queue : RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)
        btSend.setOnClickListener { view ->
            if (txtNome.text.toString().isEmpty()){
                txtNome.error = "Preencha um nome"
            }
            if (txtUsername.text.toString().isEmpty()){
                txtUsername.error = "Preencha um username"
            }
            if (txtUrlImage.text.toString().isEmpty()){
                txtUrlImage.error = "Preencha uma URL de imagem válida"
            }
            if (txtDesc.text.toString().isEmpty()){
                txtDesc.error = "Preencha o seu post"
            }
            if (txtNome.text.toString().isNotEmpty() && txtUsername.text.toString().isNotEmpty() &&
                txtUrlImage.text.toString().isNotEmpty() && txtDesc.text.toString().isNotEmpty()) {
                    sendPost()
            }
        }
        queue = Volley.newRequestQueue ( baseContext)
    }

    private fun sendPost() {
        var post = Post(null, txtDesc.text.toString(),null,txtUrlImage.text.toString(),0,txtNome.text.toString(),
            null, txtUsername.text.toString())
        var json = Gson().toJson(post)
        var url = "https://fundatec.dev.aioria.com.br/api/v1/post"
        var requestSendPost = GsonJsonRequest(Request.Method.POST, url, Post::class.java, json,
            Response.Listener { response -> finish();},
            Response.ErrorListener { error -> Toast.makeText(baseContext, "Erro: " + error.message, Toast.LENGTH_LONG).show()}
        )

        queue?.add(requestSendPost )
    }
}
