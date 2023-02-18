package dev.dineshktech.app.starter.database

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.dineshktech.app.starter.database.dao.NotesyDao

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesNotesyDao(
        database: NotesDatabase,
    ): NotesyDao = database.notesyDao()
}
