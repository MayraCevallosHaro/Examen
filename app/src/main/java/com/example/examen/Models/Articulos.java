package com.example.examen.Models;

public class Articulos {
    private String section, publication_id, title, date_published;
    private Galeys galeys;

    public Articulos(String section, String publication_id, String title, String date_published, Galeys galeys) {
        this.section = section;
        this.publication_id = publication_id;
        this.title = title;
        this.date_published = date_published;
        this.galeys = galeys;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public Galeys getGaleys() {
        return galeys;
    }

    public void setGaleys(Galeys galeys) {
        this.galeys = galeys;
    }

    public class Galeys{
        private String galley_id, label, UrlViewGalley;

        public Galeys(String galley_id, String label, String urlViewGalley) {
            this.galley_id = galley_id;
            this.label = label;
            UrlViewGalley = urlViewGalley;
        }

        public String getGalley_id() {
            return galley_id;
        }

        public void setGalley_id(String galley_id) {
            this.galley_id = galley_id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getUrlViewGalley() {
            return UrlViewGalley;
        }

        public void setUrlViewGalley(String urlViewGalley) {
            UrlViewGalley = urlViewGalley;
        }
    }

}
