package dev.codewithdk.minimalist.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.codewithdk.minimalist.core.data.repository.NotesRepository
import dev.codewithdk.minimalist.core.data.repository.OfflineFirstNotesRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsNotesRepository(
        notesRepository: OfflineFirstNotesRepository
    ): NotesRepository

}
