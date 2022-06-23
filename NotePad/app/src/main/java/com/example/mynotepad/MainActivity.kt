package com.example.mynotepad

import androidx.appcompat.app.AppCompatActivity
import com.example.mynotepad.interfaces.DrawerLoc
import com.example.mynotepad.fragments.MainFragment
import androidx.drawerlayout.widget.DrawerLayout
import android.os.Bundle
import com.example.mynotepad.fragments.LoginFragment
import android.annotation.SuppressLint
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import com.example.mynotepad.fragments.NotesFragment
import com.example.mynotepad.fragments.CitiesFragment
import com.example.mynotepad.fragments.AboutFragment
import com.example.mynotepad.fragments.SearchFragment
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.mynotepad.interfaces.IDrawerHeaderHandler

class MainActivity : AppCompatActivity(), IDrawerHeaderHandler, DrawerLoc {

    private lateinit var mainFragment: MainFragment
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActionBar()
        mainFragment = MainFragment()
        val loginFragment = LoginFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, loginFragment)
            .commit()
    }

    private fun initActionBar() {
        val toolbar = findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolbar)
        initDrawer(toolbar)
    }

    @SuppressLint("NonConstantResourceId")
    private fun initDrawer(toolbar: Toolbar) {
        drawer = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer?.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.drawer_main -> {
                    showFragment(mainFragment)
                    drawer.close()
                    return@setNavigationItemSelectedListener true
                }
                R.id.drawer_notes -> {
                    showFragment(NotesFragment())
                    drawer.close()
                    return@setNavigationItemSelectedListener true
                }
                R.id.drawer_cities -> {
                    showFragment(CitiesFragment())
                    drawer.close()
                    return@setNavigationItemSelectedListener true
                }
                R.id.drawer_sitings, R.id.drawer_photos -> {
                    drawer.close()
                    return@setNavigationItemSelectedListener true
                }
                R.id.drawer_about -> {
                    showFragment(AboutFragment())
                    drawer.close()
                    return@setNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                showFragment(AboutFragment())
                return true
            }
            R.id.menu_login -> {
                showFragment(LoginFragment())
                return true
            }
            R.id.menu_find -> {
                showFragment(SearchFragment())
                return true
            }
            R.id.menu_exit -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showFragment(incomeFragment: Fragment?) {
        val fragments = supportFragmentManager.fragments
        var isAboutShow = false
        for (fragment in fragments) {
            if (fragment.javaClass == incomeFragment!!.javaClass && fragment.isVisible) {
                isAboutShow = true
            }
        }
        if (!isAboutShow) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, incomeFragment!!)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun setName(name: String) {
        val userName = findViewById<TextView>(R.id.text_view_name)
        userName.text = name
    }

    override fun setLastName(lastName: String) {
        val userLastName = findViewById<TextView>(R.id.text_view_lastname)
        userLastName.text = lastName
    }

    override fun getName(): String {
        val userName = findViewById<TextView>(R.id.text_view_name)
        return userName?.text?.toString() ?: "Имя"
    }

    override fun getLastName(): String {
        val userLastName = findViewById<TextView>(R.id.text_view_lastname)
        return userLastName?.text?.toString() ?: "Фамилия"
    }

    override fun locDrawer() {
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun unLocDrawer() {
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }
}