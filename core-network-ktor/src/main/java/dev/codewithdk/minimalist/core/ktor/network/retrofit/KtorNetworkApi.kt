package dev.codewithdk.minimalist.core.ktor.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.codewithdk.minimalist.core.ktor.network.NetworkDataSource
import dev.codewithdk.minimalist.core.ktor.network.model.Note
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton


private interface KtorNetworkApi {
    @GET(value = "notes")
    suspend fun getNotes(
        @Query("id") ids: List<String>?,
    ): NetworkResponse<List<Note>>
}

private const val baseUrl = "http://google.com"

@Serializable
private data class NetworkResponse<T>(
    val data: T
)

@Singleton
class KtorNetworkApiSource @Inject constructor(
    networkJson: Json
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(KtorNetworkApi::class.java)

    override suspend fun getNotes(ids: List<String>?): List<Note> = networkApi.getNotes(ids = ids).data

}
