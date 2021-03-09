package com.oshc.esps.ui.pa

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

enum class ACTIVITY_TYPE {
    INDOOR, OUTDOOR, INDOOR_OUTDOOR
}

@Parcelize
data class Activity(var type: ACTIVITY_TYPE, var title: String, var equipments: List<String>, var activities: List<String>) :
    Parcelable

class ActivityViewModel : ViewModel() {

    val activityList = MutableLiveData<List<Activity>>()
    val activityListAdapter: ActivityListAdapter

    init {
        populateActivityData()
        activityListAdapter = ActivityListAdapter(activityList.value!!)
    }

    private fun populateActivityData() {
        activityList.value = listOf(
            Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
                    "Circuit Training",
                    listOf("Skippig ropes, hoops or balls, craft materials to make cue cards"),
                    listOf("Set up training station in a circuit around the room. Put cue sings with each station with picture cures and word cues. For example, in four corners of the room have:\n• skipping\n" +
                            "• hoping on the spot on one leg\n" +
                            "• jumping up to touch a balloon suspended from the ceiling\n" +
                            "• twirling a hoop around the waist\n" +
                            "• Allow children to spend at least 60 seconds per station before instructing them to\n" +
                            "move on to the next station. You could have music playing during the circuit training.")),
            Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
                "Frisbee",
                    listOf("Frisbee or paper plate"),
                    listOf("Get the children to play with a paper plate!",
                           "Get children to throw a frisbee outside. Groups can practise their frisbee skills. Challenge children to try to:\n" +
                                   "• count the number of times they can pass the frisbee to each other without it touching the ground\n" +
                                   "• throw the longest distance\n" +
                                   "• relay around a circle\n" +
                                   "• throw frisbees through goal posts.")),
            Activity(ACTIVITY_TYPE.INDOOR,
            "Dance Off",
            listOf("Space and music"),
            listOf("Have children make up a routine or dance to music. Get them to make up a theme, for " +
                    "example, football theme songs during football finals week, top of the charts or jungle " +
                    "boogie. Hold a performance at the end of the week for those who want to participate.")),

            Activity(ACTIVITY_TYPE.OUTDOOR,
            "Frisbee Golf",
            listOf("Frisbee"),
            listOf("Set up a frisbee golf course! Children can ‘hit off’ from a set point (the first tee) and " +
                    "count the number of turns taken to reach a pre-determined target (the first hole).\n" +
                    "Encourage children to make their own scorecards as a craft activity and then they can " +
                    "play ‘9 holes’.")),
                Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
                        "Circuit Training",
                        listOf("Skippig ropes, hoops or balls, craft materials to make cue cards"),
                        listOf("Set up training station in a circuit around the room. Put cue sings with each station with picture cures and word cues. For example, in four corners of the room have:\n• skipping\n" +
                                "• hoping on the spot on one leg\n" +
                                "• jumping up to touch a balloon suspended from the ceiling\n" +
                                "• twirling a hoop around the waist\n" +
                                "• Allow children to spend at least 60 seconds per station before instructing them to\n" +
                                "move on to the next station. You could have music playing during the circuit training.")),
                Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
                        "Frisbee",
                        listOf("Frisbee or paper plate"),
                        listOf("Get the children to play with a paper plate!",
                                "Get children to throw a frisbee outside. Groups can practise their frisbee skills. Challenge children to try to:\n" +
                                        "• count the number of times they can pass the frisbee to each other without it touching the ground\n" +
                                        "• throw the longest distance\n" +
                                        "• relay around a circle\n" +
                                        "• throw frisbees through goal posts.")),
                Activity(ACTIVITY_TYPE.INDOOR,
                        "Dance Off",
                        listOf("Space and music"),
                        listOf("Have children make up a routine or dance to music. Get them to make up a theme, for " +
                                "example, football theme songs during football finals week, top of the charts or jungle " +
                                "boogie. Hold a performance at the end of the week for those who want to participate.")),

                Activity(ACTIVITY_TYPE.OUTDOOR,
                        "Frisbee Golf",
                        listOf("Frisbee"),
                        listOf("Set up a frisbee golf course! Children can ‘hit off’ from a set point (the first tee) and " +
                                "count the number of turns taken to reach a pre-determined target (the first hole).\n" +
                                "Encourage children to make their own scorecards as a craft activity and then they can " +
                                "play ‘9 holes’."))
        )
    }
}