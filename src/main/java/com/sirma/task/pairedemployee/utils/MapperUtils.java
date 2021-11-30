package com.sirma.task.pairedemployee.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtils {

    @Autowired
    private ModelMapper modelMapper;

    public <T, G> G map(T source, Class<G> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public <T, G> List<G> mapList(List<T> sourceList, Class<G> targetClass) {
        return sourceList.stream()
                .map(source -> modelMapper.map(source, targetClass))
                .collect(Collectors.toList());
    }
}
