package com.programacionmaster.mercadolibreapijava.service;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.programacionmaster.mercadolibreapijava.helpers.RetrofitSingleton.getRetrofitInstance;

public class SiteService {

    public static class Site implements Serializable {
        public final String id;
        public final String name;

        public Site(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Site{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public interface SiteRestRepository {

        @GET("/sites")
        Call<List<Site>> all();
    }

    public static Call<List<Site>> getAll() {
        return getRetrofitInstance().create(SiteService.SiteRestRepository.class).all();
    }
}
