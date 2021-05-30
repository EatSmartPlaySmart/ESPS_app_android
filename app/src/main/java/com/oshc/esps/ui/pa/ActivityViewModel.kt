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
                    listOf("Skipping ropes, hoops or balls, craft materials to make cue cards"),
                    listOf("Set up training station in a circuit around the room. Put cue signs with each station with picture cues and word cues. For example, in four corners of the room have:\n\n• Skipping\n" +
                            "\n• Hoping on the spot on one leg\n" +
                            "\n• Jumping up to touch a balloon suspended from the ceiling\n" +
                            "\n• Twirling a hoop around the waist\n" +
                            "\n• Allow children to spend at least 60 seconds per station before instructing them to " +
                            "move on to the next station. You could have music playing during the circuit training.")),
            Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
                "Frisbee",
                    listOf("Frisbee or paper plate"),
                    listOf("Get the children to play with a paper plate!",
                           "Get children to throw a frisbee outside. Groups can practise their frisbee skills. Challenge children to try to:\n" +
                                   "\n• Count the number of times they can pass the frisbee to each other without it touching the ground\n" +
                                   "\n• Throw the longest distance\n" +
                                   "\n• Relay around a circle\n" +
                                   "\n• Throw frisbees through goal posts.")),
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
                    "\nEncourage children to make their own scorecards as a craft activity and then they can " +
                    "play ‘9 holes’.")),

                Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
                        "Ships Ahoy!",
                        listOf("Not required!"),
                        listOf("Have children line up in the centre of a room (or outdoor area) and instruct them that the room (or outdoor area) is a ship. Tell them that left is the ship’s port and right is the ship’s starboard.\n\n" +
                                "Directions given are:\n" +
                                "\n• Port: group runs to the left\n" +
                                "\n• Starboard: group runs to the right\n" +
                                "\n• Captain coming: all stand and salute\n" +
                                "\n• Scrub the deck: crouch and ‘wash the deck’\n" +
                                "\n• Man overboard: all lie face down on the ground • Climb the rigging: all pretend to climb the ladder.\n\n" +
                                "If someone makes a mistake, they collect a card containing one of the letters P, L, A, N or K. If a child collects all five they have to ‘walk the plank’ before rejoining the group (make them power walk around the ‘ship’).")),


            Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
            "Triangle Tag",
            listOf("Cones to identify playing area"),
            listOf("Have children form groups of three and join hands. The fourth group member will be outside the circle of three. He or she will be the chaser. Designate one person in the circle as the person that the chaser will try and tag. On the leader’s signal, the chaser will try and tag the designated person. The group holding hands will work together to try and protect the taggee. Play for a designated amount of time. When the taggee is tagged, switch roles.\n")),

            Activity(ACTIVITY_TYPE.INDOOR_OUTDOOR,
            "Loop da Hoop",
            listOf("One or more plastic hoops"),
            listOf("Instruct players to hold hands in a circle " +
                    "with a hoop hanging over a pair of hands more between two people. On the leader’s signal, " +
                    "tell the group to pass the hoop around the " +
                    "circle without letting any hands go.\n\n" +
                    "Encourage players to use different strategies to help their neighbours’ position the hoop. The task is finished when the hoop returns to its first position.\n\n" +
                    "With eight or more players, add a second hoop of a different colour across from the first hoop. Once the group has completed the task, score the game by how many hoops a group can pass around in a specified time frame. Continue passing the same hoop/s around successive times until time expires.\n\n" +
                    "Make sure to give feedback to the group about how well they are cooperating or not cooperating."))

        )
    }
}