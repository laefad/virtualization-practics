package part2.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ImageService {

    public Mono<DataBuffer> getImageByName(java.lang.String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            byte[] bytes = is.readAllBytes();
            DataBuffer imageData = DefaultDataBufferFactory.sharedInstance.wrap(bytes);
            return Mono.just(imageData);
        } catch (IOException e) {
            System.out.println(e);
        }
        return Mono.empty();
    }

}
