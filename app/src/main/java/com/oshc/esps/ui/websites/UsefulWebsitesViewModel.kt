package com.oshc.esps.ui.websites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Website(var title: String, var desc: String, var url: String)

class UsefulWebsitesViewModel : ViewModel() {

    val websiteList = MutableLiveData<List<Website>>()
    val websiteListAdapter: UsefulWebsitesListAdapter

    init {
        populateWebsitelist()
        websiteListAdapter = UsefulWebsitesListAdapter(websiteList.value!!)
    }

    private fun populateWebsitelist() {
        websiteList.value = listOf(
                Website("Heart Foundation", "Healthy eating information", "http://heartfoundation.org.au/healthy-eating"),
                Website("Heart Foundation", "Physical Activity Information", "http://heartfoundation.org.au/active-living"),
                Website("Heart Foundation", "Jump Rope for Heart", "http://heartfoundation.org.au/jump-rope-for-heart-outreach-program"),
                Website("Healthy Kids", "Information on healthy eating and physical activity for children, families, educators and teachers", "http://www.healthykids.nsw.gov.au"),
                Website("Eat for Health by Australian Government", "Includes the Australian Dietary Guidelines, Australian Guide to Healthy Eating and\n" +
                        "resources you can order.", "https://www.eatforhealth.gov.au"),
                Website("Australia’s Physical Activity and Sedentary Behaviour Guidelines", "Includes information on including physical activity and resources you can order.", "http://www.health.gov.au/internet/main/publishing.nsf/content/health-pubhlth-strategphys-\n" +
                        "act-guidelines"),
                Website("A Healthy and Active Australia", "This website provides a range of information and initiatives on healthy eating and regular\n" +
                        "physical activity to assist all Australians to lead healthy and active lives.", "http://www.healthyactive.gov.au"),
                Website("Make Healthy Normal", "NSW Health website encouraging healthy eating and physical activity to encourage\n" +
                        "lifestyle changes.", "https://www.makehealthynormal.nsw.gov.au"),
                Website("The Premier’s Sporting Challenge", "The Premier’s Sporting Challenge is a NSW Government initiative facilitated by the NSW " +
                        "Department of Education that aims to engage young people in sport and physical activity " +
                        "and encourage them to lead healthy, active lifestyles. The Challenge includes a range of " +
                        "programs with one common purpose: to have more students, more active, more often!", "https://online.det.nsw.edu.au/psc/home.html"),
                Website("NSW School Sport Unit", "This Unit within the NSW Department of Education supports appropriate sport programs " +
                        "for all public school students. The website provides resources for teachers, information " +
                        "on sports safety guidelines, opportunities for students with disabilities, a calendar of " +
                        "events and links to regional school sports associations.", "http://www.sports.det.nsw.edu.au/welcome.html"),
                Website("Sporting Schools Australia", "Sporting Schools Australia offers grants to schools for sport based activities before, during and after school.",
                        "https://sportingschools.gov.au/"),
                Website("Premier's Council for Active Living", "Guidelines for using external providers for physical activity in out of school services.", "http://www.pcal.nsw.gov.au/__data/assets/pdf_file/0007/36394/Guidelines_for_using_external_providers_for_physical_activity_in_out_of_school_hours_centres.pdf"),
                Website("Eat for Health", "Useful Food Label website", "https://www.eatforhealth.gov.au/eating-well/how-understand-food-labels"),
                Website("Health Star Rating System", "Useful Food Label website", "https://www.healthstarrating.gov.au"),
                Website("NSW Food Authority", "Useful Food Label website", "https://www.foodauthority.nsw.gov.au/ip/labelling"),
                Website("Australian Government", "Useful Food Label website", "https://www.foodlabels.industry.gov.au"),
                Website("Anaphylaxis Australia","Useful Specific Dietary website","https://www.allergy.org.au"),
                Website("Diabetes Australia","Useful Specific Dietary website","https://www.diabetesaustralia.com.au"),
                Website("Asthma Management Guidelines","Useful Specific Dietary website","http://networkofcommunityactivities.org.au/wpcontent/uploads/2013/03/asthma_aware_kit.pdf"),
                Website("Coeliac Australia","Useful Specific Dietary website","https://www.coeliac.org.au"),
                Website("Coeliac NSW & ACT. Helpline 1300 458 836","Useful Specific Dietary website","https://nswact.coeliac.org.au/coeliacdisease/"),
                Website("NSW Food Authority","Useful Food Handing and Hygiene website","http://foodauthority.nsw.gov.au"),
                Website("Staying Healthy. Preventing infectious diseases in early childhood education and care services","Useful Food Handing and Hygiene website","https://www.nhmrc.gov.au/guidelines-publications/ch55")

        )
    }
}