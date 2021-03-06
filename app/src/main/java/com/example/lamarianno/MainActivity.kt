package com.example.lamarianno

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.lamarianno.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding                  //data binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)          //inflam view-ul
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain2.toolbar)                                    //butonul de deschidere drawer

        val drawerLayout: DrawerLayout = binding.drawerLayout                               //referinta catre widget-ul din activity_main2
        val navView: NavigationView = binding.navView                                       //referinta catre ce apare cand apasam pe butonul de deschidere menu
        val navController = findNavController(R.id.nav_host_fragment_content_main2)         //referinta catre unde apar fragmentele in layout-ul content_main2.xml
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(                                          //referinta catre fragmentele din mobile_navigation
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_camera
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main2)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}