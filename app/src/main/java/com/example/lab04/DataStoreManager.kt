package com.example.lab04

import android.graphics.Color
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>) {
    suspend fun saveNoteBackgroundColor(noteBackgroundColor: String) {
        dataStore.edit { preferences ->
            preferences[NOMBRE] = noteBackgroundColor
        }
    }

    val backgroundColor: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[NOMBRE] ?: Color.CYAN.toString()
        }

    companion object {
        const val PREFS_NAME = "PREFS_NAME"
        private val NOMBRE = stringPreferencesKey("nombre_key")

    }
}