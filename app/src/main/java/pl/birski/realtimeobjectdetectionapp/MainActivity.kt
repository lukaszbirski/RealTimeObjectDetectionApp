package pl.birski.realtimeobjectdetectionapp

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import pl.birski.realtimeobjectdetectionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var requestSinglePermission = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        it.entries.forEachIndexed() { index, _ ->
            PermissionUtil.returnPermissionsArray()[index]
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        askForPermissions()

        setContentView(binding.root)
    }

    private fun askForPermissions() {
        requestSinglePermission.launch(
            PermissionUtil.returnPermissionsArray()
        )
    }
}
