package dev.dineshktech.app.starter.database

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.dineshktech.app.starter.database.dao.NotesDao

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesNoteDao(
        database: NotesDatabase,
    ): NotesDao = database.noteDao()
}
