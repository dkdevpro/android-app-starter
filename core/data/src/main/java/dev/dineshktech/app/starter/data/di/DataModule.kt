package dev.dineshktech.app.starter.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.dineshktech.app.starter.data.repository.NotesRepository
import dev.dineshktech.app.starter.data.repository.OfflineFirstNotesRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsNotesyRepository(
        notesRepository: OfflineFirstNotesRepository,
    ): NotesRepository
}
