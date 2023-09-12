package com.reactivespring.service;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repository.MovieInfoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieInfoService {

    private MovieInfoRepository movieInfoRepository;

    public MovieInfoService(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository=movieInfoRepository;
    }
    public Mono<MovieInfo> addMovieInfo(MovieInfo movieInfo) {
        return movieInfoRepository.save(movieInfo);
    }

    public Flux<MovieInfo> getAllMoviesInfos() {
        return movieInfoRepository.findAll();
    }

    public Mono<MovieInfo> getAllMoviesInfoById(String id) {
        return movieInfoRepository.findById(id);
    }

    public Mono<MovieInfo> updateMovieInfo(MovieInfo updatedMovieInfo, String id) {
        return movieInfoRepository.findById(id).flatMap(movieInfo -> {
            movieInfo.setCast(updatedMovieInfo.getCast());
            movieInfo.setName(updatedMovieInfo.getName());
            movieInfo.setReleaseDate(updatedMovieInfo.getReleaseDate());
            movieInfo.setYear(updatedMovieInfo.getYear());
            return movieInfoRepository.save(movieInfo);
        });
    }

    public Mono<Void> deleteMovieInfo(String id) {
        return movieInfoRepository.deleteById(id);
    }

    public Flux<MovieInfo> getInfoMovieByYear(Integer year) {
        return movieInfoRepository.findByYear(year);
    }
}
