package com.example.aulajetpackcompose.di

import com.example.aulajetpackcompose.data.remote.api.DummyAPI
import com.example.aulajetpackcompose.data.remote.repository.IUsuarioRepository
import com.example.aulajetpackcompose.data.remote.repository.UsuarioRepositoryImpl
import com.example.aulajetpackcompose.utils.Constantes.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    fun provideDummyAPI(retrofit: Retrofit): DummyAPI {
            return retrofit.create(DummyAPI::class.java)
    }

    @Provides
    fun provideUsuarioRepository(dummyAPI: DummyAPI): IUsuarioRepository {
        return UsuarioRepositoryImpl(dummyAPI)
    }
}