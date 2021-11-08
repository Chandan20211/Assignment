package com.sample.assignment.data.api


import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import com.google.common.truth.Truth.assertThat
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumAPIServiceTest {

    private lateinit var service: AlbumAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AlbumAPIService::class.java)


    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)

    }

    @Test
    fun getAlbum_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("album_response.json")
            val responseBody = service.getAlbums().body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/albums")


        }
    }


    @Test
    fun getAlbumList_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("album_response.json")
            val responseBody = service.getAlbums().body()
            val albumList = responseBody!!
            val album = albumList[0]
            assertThat(album.userId.toString()).isEqualTo("1")
            assertThat(album.id.toString()).isEqualTo("1")
            assertThat(album.title).isEqualTo("quidem molestiae enim")


        }
    }


    @After
    fun tearDown() {
        server.shutdown()
    }
}