package com.example.mykmpapp.data.firestore

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore

actual class FirestoreProvider {
    val db = Firebase.firestore

    actual fun saveProducts() {
        // real Firebase logic
    }
}