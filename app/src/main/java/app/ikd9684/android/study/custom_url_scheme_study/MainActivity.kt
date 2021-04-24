package app.ikd9684.android.study.custom_url_scheme_study

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.ikd9684.android.study.custom_url_scheme_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        if (intent.action == Intent.ACTION_VIEW) {
            intent.data?.let { uri ->
                val string = uri.scheme + "\n" +
                        uri.host + "\n" +
                        uri.path + "\n" +
                        "param_a=${uri.getQueryParameter("param_a")},\n" +
                        "param_b=${uri.getQueryParameter("param_b")},\n"

                binding.textView.text = string
            }
        }
    }
}
