package com.example.mykmpapp.data.firestore

actual class FirestoreProvider {
    actual fun saveProducts() {
        println("Firestore disabled on Desktop")
    }
}