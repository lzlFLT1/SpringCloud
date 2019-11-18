package kasei.springcloud.webflux.service;

import kasei.springcloud.webflux.repository.entity.Log;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LogService {
    <S extends Log> List<S> insert(Iterable<S> entities);
}
