package part2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import part2.service.ImageService;
import reactor.core.publisher.Mono;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(path = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public Mono<DataBuffer> doGet() {
        return imageService.getImageByName("/mirea.png");
    }
}
