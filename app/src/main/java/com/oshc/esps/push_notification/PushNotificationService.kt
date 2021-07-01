package com.oshc.esps.push_notification

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by Mohamed Ramshad on 27/06/2021.
 */
class PushNotificationService: FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        // todo write custom logic to handle firebase notification
    }
}