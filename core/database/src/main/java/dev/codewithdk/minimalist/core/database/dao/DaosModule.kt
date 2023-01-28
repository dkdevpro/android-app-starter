package dev.codewithdk.minimalist.core.database.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.codewithdk.minimalist.core.database.dao.dao.NotesDao

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesNoteDao(
        database: NotesDatabase,
    ): NotesDao = database.noteDao()

}
