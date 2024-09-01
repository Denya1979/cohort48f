package classwork_32.ait.album.dao;


import classwork_32.ait.album.model.Photo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AlbumImpl implements Album{

    // хранилище (repository)
    private Photo[] photos;
    private int size;

    public AlbumImpl(int capacity) {
        this.photos = new Photo[capacity];
    }

    // Comparator sort by albumId then by photoId
    Comparator<Photo> comparator = (p1, p2) -> {
        int res = Integer.compare(p1.getAlbumId(), p2.getAlbumId());
        return res != 0 ? res : Integer.compare(p1.getPhotoId(), p2.getPhotoId());
    };

    @Override
    public boolean addPhoto(Photo photo) {
        if(photo == null || size == photos.length || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null){
            return false;
        }
        int index = Arrays.binarySearch(photos, 0, size, photo, comparator);
        index = index >=0 ? index : -index -1;
        System.arraycopy(photos, index, photos, index + 1, size - index);
        photos[index] = photo;
        size++;
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if(photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId){
                System.arraycopy(photos, i + 1, photos, i , size - i - 1);
                photos[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        Photo photo = getPhotoFromAlbum( photoId, albumId);
        if(photo == null) {
            return false;
        }
        photo.setUrl(url);
        return true;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if(photos[i].getAlbumId() == albumId && photos[i].getPhotoId() == photoId){
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotosFromAlbum(int albumId) {
        return findPhotosByPredicate(p -> p.getAlbumId() == albumId);
    }

    @Override
    public Photo[] getPhotosBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return findPhotosByPredicate(p -> p.getDate().toLocalDate().isAfter(dateFrom.minusDays(1)) && p.getDate().toLocalDate().isBefore(dateTo.plusDays(1)));
    }

    @Override
    public int size() {
        return size;
    }

    private Photo[] findPhotosByPredicate(Predicate<Photo> predicate) {
        Photo[] res = new Photo[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                res[j++] = photos[i];
            }
        }
        return Arrays.copyOf(res, j);
    }



}
