package dev.codewithdk.minimalist.core.database.dao

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesNotesDatabase(
        @ApplicationContext context: Context,
    ): NotesDatabase = Room.databaseBuilder(
        context,
        NotesDatabase::class.java,
        "notes-database"
    ).build()
}
