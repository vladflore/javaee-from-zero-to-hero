package dev.vladflore.javaeezerotohero.service;


import dev.vladflore.javaeezerotohero.dto.PictureOfDay;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Stateless
public class NasaServiceImpl implements NasaService {

    @Inject
    @ConfigProperty(name = "nasa-api-key")
    private String nasaApiKey;

    private Client client;
    private WebTarget webTarget;

    @Override
    public PictureOfDay retrieveApod() {
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + nasaApiKey;
        return ClientBuilder.newClient()
                .target(url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(PictureOfDay.class);
    }
}
