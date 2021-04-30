package com.oshc.esps.ui.menu

import android.widget.SimpleAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class CheckListData(var title: String = "", var desc: String = "")

class MenuPlanningViewModel : ViewModel() {
    val checklistData = MutableLiveData<List<CheckListData>>()
    val inAdditionData = MutableLiveData<List<CheckListData>>()
    val nevefoodData = MutableLiveData<List<String>>()
    val checklistAdapter: MenuPlanningChecklistAdapter
    val inAdditionListAdapter: MenuPlanningChecklistAdapter
    val checklistVisible = MutableLiveData<Boolean>()
    val inAdditionVisible = MutableLiveData<Boolean>()
    val foodAvoidVisible = MutableLiveData<Boolean>()
    val sampleMenuVisible = MutableLiveData<Boolean>()

    init {
        checklistVisible.value = false
        inAdditionVisible.value = false
        foodAvoidVisible.value = false
        sampleMenuVisible.value = false

        populateChecklistData()
        populateInAdditionData()
        populateNeverFoodData()
        checklistAdapter = MenuPlanningChecklistAdapter(checklistData.value!!)
        inAdditionListAdapter = MenuPlanningChecklistAdapter(inAdditionData.value!!)
    }

    /**
     * Toggle visibility
     */

    fun toggleChecklistVisibility() {
        checklistVisible.value = !checklistVisible.value!!
    }

    fun toggleInAdditionVisibility() {
        inAdditionVisible.value = !inAdditionVisible.value!!
    }

    fun toggleFoodAvoidVisiblity() {
        foodAvoidVisible.value = !foodAvoidVisible.value!!
    }

    fun toggleSampleMenuVisibility() {
        sampleMenuVisible.value = !sampleMenuVisible.value!!
    }


    private fun populateNeverFoodData() {
        nevefoodData.value = listOf(
                "Fairy bread, pastries e.g. sweet and savoury pies",
                "Sweet spreads e.g. jam",
                "Cakes, biscuits, muffins, doughnuts",
                "Sweet sauces and dressings",
                "Muesli bars",
                "Desserts, ice creams",
                "Cream/sour cream/ butter",
                "Lollies, chocolate",
                "Processed meats for e.g salami, devon, sausages, etc.",
                "Burgers, pizza, chicken nuggets, fried foods",
                "Potato chips",
                "Soft drinks and cordials",
                "Fruit juice drinks",
                "Vitamin waters and flavoured mineral waters",
                "Energy and sports drinks"
        )
    }

    private fun populateChecklistData() {
        checklistData.value = listOf(
                CheckListData("A Cereal Based Food", "Breakfast cereals (less than 15 g/100 g of sugar or less than 25 g/100 g of sugar if they contian dried fruit), breads, fruit bread, plain cracker biscuits, rice cakes and rice crackers , corn thins, muffins, fruit buns, crumpets, pikelets, pasta, rice, noodles and couscous.\nNote: Choose wholemeal/wholegrain varieties"),
                CheckListData("A Fruit", "Fresh, frozen, canned fruit (canned in unsweetened juice not syrup) or dried fruit, but not juice"),
                CheckListData("A Vegetable", "Raw or cooked vegetables including salad vegetables, fresh, canned or frozen vegetables."),
                CheckListData("Milk, Yoghurt, Cheese", "Reduced fat milks, cheese, cheese spread, yoghurt and milk alternatives (e.g. soy) with added calcium (100 mg/100 ml).\nNOte: Cream cheese, cream, sour cream and butter are not high sources of calcium."),
                CheckListData("Lean Meat, Poultry, Fish, Eggs, Tofu and Legumes", "Beef, lamb, kangaroo, pork, fish (e.g tuna), chicken, eggs, tofu, legumes (e.g. baked beans, chick peas, lentils)"),
                CheckListData("Water as a Drink", "Always serve water as a drink. Reduced fat milk is also a good choice.")
        )
    }

    private fun populateInAdditionData() {
        inAdditionData.value = listOf(
                CheckListData("Serve enough of each food group to allow each child to have a serve from each group", ""),
                CheckListData("Every week include at least three different varieties from each food group", ""),
                CheckListData("Only serve sometimes food twice a term (including vacation care)", "Sometimes food are high in fat, sugar and salt and are not needed. They can lead to tooth decay and weight gian and leave less room for healthy food.")
        )
    }
}