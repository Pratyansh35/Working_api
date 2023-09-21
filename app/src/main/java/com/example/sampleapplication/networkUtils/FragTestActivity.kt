package com.example.sampleapplication.networkUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.sampleapplication.databinding.ViewpagerTestBinding
import com.example.sampleapplication.fragments.FragmentHome
import com.example.sampleapplication.fragments.FragmentPost
import com.example.sampleapplication.fragments.FragmentSearch
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


// Todo: Add theme -> Dark and Light (select Colors for the themes as Well)
class FragTestActivity : AppCompatActivity(){

/*    private  val fragBinding by lazy {
        ActivityFragTestBinding.inflate(layoutInflater)
    }*/
    private val viewpagerBinding by lazy {
        ViewpagerTestBinding.inflate(layoutInflater)
}
    private lateinit var onPageChangeCallback: OnPageChangeCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewpagerBinding.root)

        viewpagerBinding.viewpager.adapter = ViewpagerAdapter(supportFragmentManager, lifecycle)

        viewpagerBinding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewpagerBinding.viewpager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

        onPageChangeCallback = object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewpagerBinding.tabLayout.selectTab(viewpagerBinding.tabLayout.getTabAt(position))
            }
        }

        viewpagerBinding.viewpager.registerOnPageChangeCallback(onPageChangeCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewpagerBinding.viewpager.unregisterOnPageChangeCallback(onPageChangeCallback)
    }

/*       fragBinding.bottomNav.setOnItemSelectedListener {
           when(it.itemId){
               R.id.botNavHome -> setFragmentContainer(FragmentHome())
               R.id.botNavSearch -> setFragmentContainer(FragmentSearch())
               R.id.botNavPost ->  setFragmentContainer(FragmentPost())
               R.id.botNavProfile -> setFragmentContainer(FragmentProfile())
               else -> setFragmentContainer(FragmentHome())
       }
                true
           }
        }
        private fun setFragmentContainer(fragment: Fragment){
            supportFragmentManager.beginTransaction()
                .replace(fragBinding.fragContainer.id,fragment)
                .commit()
        }*/
class ViewpagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentHome()
            1 -> FragmentSearch()
            2 -> FragmentPost()
            else -> FragmentHome()
            }
        }
    }
}
