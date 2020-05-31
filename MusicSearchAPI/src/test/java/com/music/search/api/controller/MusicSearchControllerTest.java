package com.music.search.api.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.music.search.api.model.Album;
import com.music.search.api.model.Artist;
import com.music.search.api.service.MusicSearchAPIService;

@WebMvcTest(value = MusicSearchController.class)
@ActiveProfiles("test")
class MusicSearchControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MusicSearchAPIService musicSearchControllerService;
	
	
	
	
	
	
	@Test
	public void retrieveAllArtists() throws Exception {
		String artistJson1 = "{\"artistId\":1,\"artistName\":\"Michael Jackson\"}";
		String artistJson2 = "{\"artistId\":2,\"artistName\":\"Unknown\"}";

		Artist mockArtist1 = new Artist(1, "Michael Jackson");
		Artist mockArtist2 = new Artist(2, "Unknown");

		
		when(musicSearchControllerService.retrieveAllArtists()).thenReturn(Arrays.asList(mockArtist1, mockArtist2));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/artists").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Actual Result=> " + result.getResponse().getContentAsString());
		
		String expectedResult = "["+artistJson1+","+artistJson2+"]";
		System.out.println("Expected Result=> " + expectedResult);
		
		System.out.println(expectedResult.equals(result.getResponse().getContentAsString()));
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void retrieveArtistById() throws Exception {
		String artistJson1 = "{\"artistId\":1,\"artistName\":\"Michael Jackson\"}";
		
		Artist mockArtist1 = new Artist(1, "Michael Jackson");
		
		when(musicSearchControllerService.retrieveArtistById(1)).thenReturn(mockArtist1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/artists/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Actual Result=> " + result.getResponse().getContentAsString());
		
		System.out.println(artistJson1.equals(result.getResponse().getContentAsString()));
		
		JSONAssert.assertEquals(artistJson1, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void retrieveAllAlbumsByArtistId() throws Exception {
		
		Album mockAlbum1 = new Album(1, "Dangerous", "1997", "Pop");
		Album mockAlbum2 = new Album(2, "BAD", "1991", "Pop");
		
		String albumJson1 = "{\"albumId\":1,\"title\":\"Dangerous\",\"yearOfRelease\":\"1997\",\"genre\":\"Pop\"}";
		String albumJson2 = "{\"albumId\":2,\"title\":\"BAD\",\"yearOfRelease\":\"1991\",\"genre\":\"Pop\"}";
		
		when(musicSearchControllerService.retrieveAllAlbumsByArtistId(1)).thenReturn(Arrays.asList(mockAlbum1, mockAlbum2));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/artists/1/albums").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Actual Result=> " + result.getResponse().getContentAsString());
		
		String expectedResult = "["+albumJson1+","+albumJson2+"]";
		System.out.println("Expected Result=> " + expectedResult);
		
		System.out.println(expectedResult.equals(result.getResponse().getContentAsString()));
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
}
