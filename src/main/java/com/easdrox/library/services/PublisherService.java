package com.easdrox.library.services;

import org.springframework.stereotype.Service;

import com.easdrox.library.model.Publisher;
import com.easdrox.library.repository.PublisherRepository;

@Service
public class PublisherService {
    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    public Publisher findPublisherById(int id){
        return publisherRepository.findById(id);
    }

    public Iterable<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher savePublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(int id){
        publisherRepository.deleteById(id);
    }

}
