package com.example.mykmpapp.data.firestore

actual class FirestoreProvider {
    actual fun saveProducts() {
        // Desktop does nothing
        println("Firestore disabled on Desktop")
    }
}