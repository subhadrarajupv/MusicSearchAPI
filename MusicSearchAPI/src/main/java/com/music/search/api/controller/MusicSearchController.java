package com.music.search.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.music.search.api.model.Album;
import com.music.search.api.model.Artist;
import com.music.search.api.service.MusicSearchAPIService;

@RestController
@RequestMapping("/artists")
public class MusicSearchController {

	@Autowired
	MusicSearchAPIService musicSearchApiService;
	
	@GetMapping
	public List<Artist> retrieveAllArtists() {
		List<Artist> artistsList = musicSearchApiService.retrieveAllArtists();
		return artistsList;
	}
	
	@GetMapping("/{artistId}")
	public Artist retrieveArtistById(@PathVariable Integer artistId) {
		return musicSearchApiService.retrieveArtistById(artistId);
	}
	
	@GetMapping("/{artistId}/albums")
	public List<Album> retrieveAllAlbumsByArtistId(@PathVariable Integer artistId) {
		return musicSearchApiService.retrieveAllAlbumsByArtistId(artistId);
	}
	
	@PostMapping
	public ResponseEntity<?> saveArtist(@RequestBody Artist artist) {
		musicSearchApiService.saveArtist(artist);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{artistId}").buildAndExpand(artist.getArtistId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/{artistId}/albums")
	public ResponseEntity<?> saveAlbumsByArtistId(@RequestBody List<Album> albums, @PathVariable Integer artistId) {
		musicSearchApiService.saveAlbumsByArtistId(albums, artistId);
		return ResponseEntity.ok().body(albums);
	}
	
	@PostMapping("/{artistId}/album")
	public ResponseEntity<?> saveAlbumByArtistId(@RequestBody Album album, @PathVariable Integer artistId) {
		musicSearchApiService.saveAlbumByArtistId(artistId, album);
		return ResponseEntity.ok().body(album);
	}
	
	@PutMapping("/{artistId}")
	public ResponseEntity<?> updateArtistById(@PathVariable Integer artistId, @RequestBody Artist artist) {
		artist.setArtistId(artistId);
		musicSearchApiService.saveArtist(artist);
		return ResponseEntity.ok().body(artist);
	}
	
	@PutMapping("/{artistId}/albums/{albumId}")
	public ResponseEntity<?> saveAlbumByAlbumId(@PathVariable Integer artistId, @PathVariable Integer albumId, @RequestBody Album album) {
		album.setAlbumId(albumId);
		musicSearchApiService.saveAlbumByArtistId(artistId, album);
		return ResponseEntity.ok().body(album);
	}
	
}
