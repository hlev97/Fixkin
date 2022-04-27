package hu.bme.aut.it9p0z.fixkin.presentation.screens.main.component.bottom_navigation

import hu.bme.aut.it9p0z.fixkin.R

sealed class BottomNavigationItem(var title:String, var icon:Int, var screen_route:String){
    object History: BottomNavigationItem("History",R.drawable.ic_baseline_history_24,"history")
    object Statistics: BottomNavigationItem("Statistics",R.drawable.ic_baseline_statistics_24,"statistics")
}