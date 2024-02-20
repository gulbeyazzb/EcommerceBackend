package com.workintech.ecommerce.ecommerce.service;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public interface ModelMapperService {
        ModelMapper forResponse();
        ModelMapper forRequest();

}
