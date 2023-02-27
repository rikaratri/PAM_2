package edu.uksw.fti.pam.pam_activity_intent.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserFirstName(private val context: Context) {

    //
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userFirstName")
        val USER_FIRSTNAME_KEY = stringPreferencesKey("userFirstName")
    }

    //Untuk Mendapatkan First Name
    val getFirstName: Flow<String?> = context.dataStore.data
        .map {preferences ->
            preferences[USER_FIRSTNAME_KEY] ?: ""
        }

    // Untuk Menyimpan First Name
    suspend fun saveFirstName(name: String){
        context.dataStore.edit {preferences ->
            preferences[USER_FIRSTNAME_KEY] = name
        }
    }
}