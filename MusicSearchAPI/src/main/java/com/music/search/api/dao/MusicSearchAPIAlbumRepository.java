package com.music.search.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.search.api.model.Album;

@Repository
public interface MusicSearchAPIAlbumRepository extends JpaRepository<Album, Integer> {

}
