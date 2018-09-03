package core.legion.qicket.main_screen

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import core.legion.qicket.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainFacade.View {

    @Inject lateinit var presenter: MainFacade.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener { presenter.onAddClick() }
        btnCheck.setOnClickListener { presenter.onCheckClick() }
    }

    override fun showQR(qr: Bitmap) {
        ivImage.setImageBitmap(qr)
    }

    override fun showToast(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }
}
