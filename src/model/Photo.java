package model;

public class Photo {
    private String url, name_telescope;
    // private Calendar date;

    public Photo(String url, String name_telescope) {
        this.url = url;
        this.name_telescope = name_telescope;

    }

    @Override
    public String toString() {
        return "Photo [url=" + url + ", name_telescope=" + name_telescope + "]";
    }

}