package com.oshc.esps.ui.food

import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.oshc.esps.ui.home.Feed
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Food(var img: String, var title: String, var desc: String, var filters: List<String>, var prepTime: Int, var cookTime: Int,
                var ingredientsList: @RawValue List<Ingredient>, var method: String): Parcelable


data class Ingredient(var item: String, var qty: String)

class FoodViewModel : ViewModel() {

    private val _foodList = MutableLiveData<MutableList<Food>>()
    val isSearchVisible = MutableLiveData<Boolean>()
    // search text two way data binded to edittext
    val query = MutableLiveData<String>()


    init {
        populateData()
        query.value = ""
        isSearchVisible.value = false
    }

    // applies search filter to the list and updates it
    val foodList = Transformations.switchMap(query) { searchString ->
        if (searchString.isBlank()) {
            _foodList
        } else {
            val dataListFiltered = MutableLiveData<MutableList<Food>>()
            dataListFiltered.value = mutableListOf()
            _foodList.value?.forEach {
                if (it.title.contains(searchString, ignoreCase = true))
                    dataListFiltered.value?.add(it)
            }

            dataListFiltered
        }
    }

//    // update the search text
//    fun setFilterText(filterText: String) {
//        query.value = filterText
//        Log.d("HomeViewModel", "Filter: ${query.value}")
//    }

    // Change the visibility value of searchbar
    fun toggleSearchVisibility(isVisible: Boolean) {
        if (!isVisible)
            query.value = ""

        isSearchVisible.value = isVisible
    }

    private fun populateData() {
        _foodList.value = mutableListOf()
        _foodList.value?.run {

            add(Food("recipe_corn_fritters", "Corn fritters",
            "These fritters are full of vegetables and are delicious served on wholemeal bread with salt reduced tomato sauce.",
            listOf("Vegetarian", "Serves 10", "Afternoon tea recipe"),
            15,
            10,
            listOf(Ingredient("Frozen sweet corn kernels", "1.5 cups – 405 g"), Ingredient("Spring onions – with green tops, sliced", "4 onions"), Ingredient("Capsicum – seeds removed - chopped", "1 small – 200g"),
                Ingredient("Parsley or chives – chopped", "1/4 cup – 15 g"),
                Ingredient("Black pepper, coarsely ground", "Pinch"),
                Ingredient ("Sweet chilli sauce", "1 tbsp"),
                Ingredient("Eggs, beaten", "2"),
                Ingredient("Milk", "1/2 cup – 125 mL"),
                Ingredient("Wholemeal self-raising flour", "1 cup – 140g"),
                Ingredient("Canola oil for cooking", "1 tbsp – 20mL") ),
            "1. Using a wooden spoon, combine corn, onions, capsicum, parsley (or chives), pepper, sweet chilli sauce, eggs and milk in a large mixing bowl.\n2. Stir in the wholemeal self-raising flour. \n3. Heat a frying (or electric) pan with 2 teaspoons of oil and cook the mixture in ¼ cupfuls (this will produce fritters about 7 cm in diameter). \n4. Cook until golden brown, about 2 minutes each side, and serve as soon as possible. \n5. If not using at once, cover and store in the refrigerator for up to 3 days.  \n Alternatively, transfer to a freezer storage container and freeze for several weeks."))

            add(Food("recipe_quick_creamy_porridge", "Quick, creamy porridge",
            "Serve warm in winter with sultanas or sliced bananas",
            listOf("Vegetarian", "Serves 10", "Egg free", "Breakfast recipe"),
                5,
            15,
            listOf(Ingredient("Quick-cooking oats", "3 cups – 250 g"),
                Ingredient("Water", "3 cups – 750 mL"),
                Ingredient("Milk – any milk of your choice", "4 cups – 1L")),
                "1. Put the quick-cooking oats in a large saucepan and add the water and milk. \n2. Bring to the boil over medium–high heat, stirring every now and then. \n3. Reduce the heat, cover and cook gently until thick and creamy, about 12 minutes, stirring occasionally. \n4. Serve at once with dried fruit, sliced fresh fruit or canned fruit in unsweetened juice, and a little honey or brown sugar if desired."))


            add(Food("recipe_broccoli_and_green_pea_soup",
                "Broccoli and green pea soup",
            "Serve in cups with toast fingers to dip in the soup.",
            listOf("Vegetarian", "Serves 10", "Egg free", "Dairy free", "Gluten free", "Afternoon tea recipe"),
            15,
            15,
            listOf(Ingredient("Olive oil", "1 tbsp – 20mL"),
                Ingredient("Onions, chopped", "1"),
                Ingredient("Celery, chopped", "2 sticks"),
                Ingredient("Broccoli, trimmed and chopped", "350 g"),
                Ingredient("Frozen peas",  "1 cup"),
                Ingredient ("Minced garlic", "1 tsp"),
                Ingredient("Homemade no added salt or salt reduced vegetable stock", "1.5 cups – 375 mL"),
                Ingredient("Dried basil", "1 tsp"),
                Ingredient("Reduced fat milk", "1.5 cups- 375 mL"),
                Ingredient("Pepper, coarsely ground", "Pinch")),
            "1. Heat the oil in a large pan and stir-fry the onions and celery for 2 minutes. \n2. Turn the heat to very low, put the lid on the pan and cook gently for 5 minutes while you chop the broccoli. \n3. Add the broccoli, peas and garlic to the pan and stir to combine with the onions and celery. Cover the pan and continue to cook gently. \n4. Add the hot stock to the pan and bring the soup to the boil. \n5. Reduce the heat, cover and simmer until the broccoli is tender, about 10 minutes (see Quick tip). \n6. Add the basil. \n7. If you have a blender, blend the soup in batches, adding a cup or so of the milk to each batch to cool the soup while blending. Return the soup to the pan and reheat. \n8. Alternatively, if you have a hand-held blender, simply blend the soup in the pot, then stir in the milk and reheat gently. \n9. Season with pepper and serve in cups with spoons. \n Great colour and texture be sure to cook the broccoli only until it is tender — it should still be a nice shade of green. If you overcook broccoli it will develop an olive green colour and a strong flavour. The addition of the peas helps liven up the colour and also creates a thick, satisfying texture."))


            add(Food("recipe_beany_melts",
                "Beany melts",
            "This recipe spices up beans with vegetables and cheese.",
            listOf("Vegetarian", "Serves 20", "Egg free", "Afternoon tea recipe"),
            11,
            15,
            listOf(Ingredient("No added salt or salt reduced baked beans", "2 x 425 g cans"),
                Ingredient("Spring onions, with green tops – sliced", "8 onions"),
                Ingredient("Frozen sweet corn kernels", "1.5 cups"),
                Ingredient("Red capsicums, seeds removed, chopped", "1"),
                Ingredient("Sweet chilli sauce",  "1.5 tbsp"),
                Ingredient (" or Tabasco sauce", "1/4 tsp"),
                Ingredient("Wholemeal English muffins", "10"),
                Ingredient("Grated cheddar cheese", "2 cups"),
                Ingredient("Black pepper, coarsely ground", "1/4 tsp") ),
            "1. Preheat oven to 200°C. \n 2. Using a wooden spoon, combine the baked beans, spring onions, sweet corn, capsicums and sweet chilli sauce (or Tabasco sauce) in a large mixing bowl. \n 3. Using a small sharp knife, split the muffins in half. \n 4. Arrange the muffin halves on a clean work surface. \n 5. Divide the baked bean mixture between muffins and spread out evenly on each one. \n 6. Sprinkle with the grated cheese and pepper. \n 7. Arrange on baking trays and bake until they are heated through and the cheese is a light golden brown, about 15 minutes."))


            add(Food("recipe_vegetable_couscous",
                "Vegetable couscous",
                    "This is a quick and easy one dish meal and is great for cooler months. Served cold, this recipe makes a tasty salad.",
            listOf("Vegetarian", "Serves 10", "Egg free", "Dairy free", "Afternoon tea recipe"),
            5,
            15,
                listOf(Ingredient("Olive oil", "1 tbsp"),
                        Ingredient("Onion, chopped finely", "2"),
                    Ingredient("Celery, chopped finely", "3 stalks"),
                    Ingredient("Frozen peas", "1 cup"),
                    Ingredient("Semi-dried tomatoes (not in oil), chopped",  "1/2 cup"),
                    Ingredient ("Ground coriander", "2 tsp"),
                    Ingredient("Ground chilli powder", "1/4 tsp"),
                    Ingredient("Couscous – see Quick tip below", "1.5 cups"),
                    Ingredient("Homemade no added salt or salt reduced vegetable stock", "1.5 cups") ),
            "1. Heat a large saucepan over medium–high heat. Add the oil and stir-fry the onion, celery and peas for 2 minutes. \n 2. Stir in the semi-dried tomatoes, coriander and chilli powder and cook for 1 minute. \n 3. Stir in the vegetable stock and bring to the boil over high heat, stirring once or twice. \n 4. Stir in the couscous and cook for 1 minute, then cover pan with lid and remove from the heat. Allow the couscous to stand until it has absorbed the stock and is tender, 5–10 minutes. \n 5. Serve hot or refrigerate to serve cold. \n Quick tip: Couscous consists of tiny pellets made from semolina (the inner part of wheat) and water, coated with flour. Try wholemeal couscous to add variety and extra nutrients. \n Convenience: When preparing more than 20 serves, you will need to use large pans for cooking the couscous."))


            add(Food("recipe_banana_piklet",
                "Banana pikelets",
            "Serve hot or cold with margarine spread or top with sliced bananas and sprinkle with cinnamon. Also suitable for breakfast",
            listOf("Vegetarian", "Serves 20", "Breakfast recipe"),
                5,
                10,
                listOf(Ingredient("Bananas, peeled, mashed – see Quick tip below", "2"),
                    Ingredient("Brown sugar", "2 tbsp"),
                    Ingredient("Eggs, beaten", "2"),
                    Ingredient("Milk of your choice", "1.5 cups"),
                    Ingredient("Vanilla essence", "1 tsp"),
                    Ingredient ("Wholemeal self-raising flour", "2 1/3 cups – 325 g"),
                    Ingredient("Margarine spread for cooking", "2 tsp")),
            "1. Mash the bananas (see Quick tip below). Combine with the sugar, eggs, milk and vanilla, then stir in the flour. \n 2. Allow the mixture to stand for a few minutes so the flour absorbs some of the milk and the mixture thickens slightly (see Quick tip). \n 3. Heat a frying pan over medium–high heat. Add 1 teaspoon margarine spread (or spray with canola oil) and cook mixture in ¼ cupfuls. \n 4. When bubbles rise on the uncooked surface, about 1½ minutes, the pikelets are ready to turn over. \n 5. Turn pikelets and cook for a further 2 minutes on other side. \n 6. Put cooked pikelets on paper towels until ready to use. \n 7. If not using at once, cover with paper towels to prevent the pikelets from drying out. \n 8. Continue making the pikelets until you have used up all the mixture, adding 1 teaspoon more of the margarine spread (or canola oil spray) to the pan after cooking five pikelets. \n Quick tip: The correct consistency of the uncooked mixture should be that of thick pouring custard. If the mixture becomes too thick stir in a little extra milk. When mashing several bananas, use a potato masher."))


            add(Food("recipe_tomato_red_lentil_and_vegetable_soup",
                "Tomato, red lentil and vegetable soup",
            "Serve in cups with toast fingers to dip in the soup.",
            listOf("Vegetarian", "Serves 10", "Dairy free", "Egg free", "Gluten free", "Afternoon tea recipe"),
                11,
            20,
            listOf(Ingredient("Olive oil", "1 tbsp"),
                Ingredient("Onions, chopped", "1"),
                Ingredient("Split red lentils", "3/4 cup – 150 g"),
                Ingredient("Boiling water", "2.5 cups – 625 mL"),
                Ingredient("Jap pumpkin, peeled and chopped", "200g"),
                Ingredient ("Salt reduced tomato paste sauce", "2.5 cups - 625 mL"),
                Ingredient("Dried basil", "1.5 tsp"),
                Ingredient("Minced garlic", "1.5 tsp"),
                Ingredient("Frozen peas", "1 cup – 145 g"),
                Ingredient("Pepper, coarsely ground", "Pinch") ),
                "1. Heat the oil in a large pan and stir-fry the onions for 1–2 minutes. \n 2. Turn the heat to very low, put the lid on the pan and cook the onions gently for 5 minutes while you rinse the lentils. \n 3. To rinse the lentils, put them in a mixing bowl, cover with cold water and stir. Drain as much water as possible from the lentils. \n 4. Add the lentils to the onions, then stir in the boiling water. \n 5. Bring the soup to the boil, using a large serving spoon to remove and discard any foam that rises to the surface. \n 6. Chop the pumpkin and add it to the soup, along with the pasta sauce, basil, garlic and peas. \n 7. Once the soup has come to the boil, reduce the heat, cover and simmer until the vegetables are tender, about 15 minutes. \n 8. Season with pepper and serve in cups with spoons."))

            add(Food("recipe_baked_meatballs",
                "Baked meatballs",
            "Baking meatballs keeps the fat to a minimum. These make great dippers to serve with a tasty sauce. Also try serving with pita pocket bread, lettuce and tomato",
            listOf("Serves 20", "Dairy free", "Afternoon tea recipe"),
            20,
            20,
            listOf(Ingredient("Lean minced beef", "600 g"),
                Ingredient("Eggs, beaten", "2"),
                Ingredient("Onions, chopped finely", "1"),
                Ingredient("Garlic cloves, crushed", "2"),
                Ingredient("Carrots, peeled and grated", "1"),
                Ingredient ("Zucchini, grated", "1"),
                Ingredient("No added salt tomato paste", "2 tbsp"),
                Ingredient("Sweet chilli sauce", "1 tbsp"),
                Ingredient("Dried breadcrumbs", "2 cups – 180 g"),
                Ingredient("Olive oil cooking spray for cooking", ""),
                Ingredient("Super salsa – see recipe or sweet chilli sauce (To Serve)", "(1/2 cup)" )),
            "1. Preheat oven to 230°C. \n 2. Combine the beef, eggs, onion, garlic, carrot, zucchini, tomato paste and sweet chilli sauce. Use your hands to combine the mixture, adding enough breadcrumbs to bring the mixture to a hamburger consistency. \n 3. Spray the baking trays with oil. Spray more oil on the palms of your hands and use your hands to form the mixture into small balls about 3 cm in diameter. \n 4. Arrange meatballs on the prepared baking trays. Bake until cooked through and lightly browned on the outside, 15–20 minutes. \n 5. Remove from the baking trays and serve with Super salsa (see recipe) or sweet chilli sauce. \n Variety: For a variation, try replacing the sweet chilli sauce in the meatball mixture with a little curry powder."))

            add(Food("recipe_super_salsa",
                "Super salsa",
            "This salsa is perfect for dipping with bread or meatballs",
            listOf("Serves 20", "Dairy free", "Afternoon tea recipe", "Vegetarian", "Egg free", "Gluten free"),
                15,
            20,
            listOf(Ingredient("Olive oil", "2 tbsp"),
                Ingredient("Onions, chopped", "1"),
                Ingredient("Capsicums, chopped", "11/2"),
                Ingredient("Minced garlic", "1 tsp"),
                Ingredient("Ground cumin", " 3/4 tsp"),
                Ingredient ("Canned no added salt chopped tomatoes", "2 x 400g cans"),
                Ingredient("Sweet chilli sauce", "2 tbsp"),
                Ingredient("Ground pepper", "1/8 tsp")),
                "1. Heat a saucepan over medium heat and add the oil. Stir-fry the onion, capsicum, garlic and cumin for 2 minutes over medium heat. \n 2. Stir in the tomatoes and sweet chilli sauce. \n 3. Cover and cook over low-medium heat, stirring occasionally, until the vegetables are soft, about 10–15 minutes. \n 4. Season to taste with the pepper. \n 5. Serve at once or cover and store in the refrigerator for a maximum of 2–3 days."))

            add(Food("recipe_hash_browns",
                "Hash browns",
            "These are good on a cold winter's morning. Serve with salt reduced tomato sauce or super salsa",
            listOf("Dairy free", "Breakfast recipe", "Vegetarian", "Gluten free"),
            10,
            20,
            listOf(Ingredient("Potatoes, grated", "8"),
                Ingredient("Onions, grated", "1"),
                Ingredient("Eggs, beaten", "4"),
                Ingredient("Ground pepper", "1/4 tsp"),
                Ingredient("Sunflower oil for cooking", "4 tbsp")),
                "1. Grate the potatoes, then place in a large sieve or colander to drain excess liquid. \n 2. Combine the grated potato with the onion, eggs and pepper. \n 3. Heat a frying pan over medium–high heat (200°C if using an electric frying pan). \n 4. Add 1 tablespoon of oil and cook five hash browns at one time (use ¼ cup of the mixture for each hash brown and press the mixture flat against the pan using a spatula to keep them thin and crispy). \n 5. Cook until golden brown on both sides, about 2 minutes each side. \n 6. Serve at once or transfer to a plate and keep warm in oven until needed. \n 7. Continue making the hash browns until you have used up all the mixture, adding 1 tablespoon more of sunflower oil to the pan after cooking five hash browns. \n Vegie variety: Try using half quantity potato and half quantity grated carrot, pumpkin or sweet potato."))

            add(Food("recipe_carrot_and_sultana_muffins",
                "Carrot and sultana muffins",
            "These are really moist and fruity, and are great served warm from the oven or cold.",
            listOf("Breakfast recipe", "Afternoon tea recipe", "Vegetarian"),
                15,
            20,
            listOf(Ingredient("Canola oil, plus extra for greasing", "1/4 cup"),
                Ingredient("Carrots, grated", "2"),
                Ingredient("Honey", "1/4 cup – 75 g"),
                Ingredient("Brown sugar", "1/4 cup – 45 g"),
                Ingredient("Eggs, beaten", "2"),
                Ingredient("Sultanas", "1/3 cup – 65 g"),
                Ingredient("Milk – any milk of your choice", "1/4 cup – 65 mL"),
                Ingredient("White self-raising flour", "1 cup – 135 g"),
                Ingredient ("Wholemeal self-raising flour", "3/4 cup – 105 g"),
                Ingredient ("Ground cinnamon", "1 tsp")),
                "1. Preheat oven to 200°C. Brush a little of the oil over muffin pans. \n 2. Combine the carrots, oil, honey, brown sugar, eggs, sultanas and milk. \n 3. Sift the flours and cinnamon and stir into the carrot mixture until just combined (over mixing can cause tough muffins). \n 4. Divide the mixture between the prepared muffin pans. \n 5. Bake until risen, cooked through and golden brown, about 15 - 20 minutes. \n Measuring honey in a cup: When measuring the oil, do not rinse the cup before using to measure the honey - the honey will easily slip out of the cup \n Reminder: This recipe is suitable for involving children!\n\n Time saving tips: To save on washing muffins trays, buy muffin paper cases to pop into the pans. It makes them quick and easy to remove from the pans. You won’t need to brush the trays with oil or melted margarine spread and there’s no washing up."))

        }
    }
}