package classwork_32.ait.album.dao;

import classwork_32.ait.album.model.Photo;

import java.time.LocalDate;

public interface Album  {

    boolean addPhoto(Photo photo);

    boolean removePhoto(int photoId, int albumId);

    boolean updatePhoto(int photoId, int albumId, String url);

    Photo getPhotoFromAlbum(int photoId,int albumId);

    Photo[] getAllPhotosFromAlbum(int albumId);

    Photo[] getPhotosBetweenDate(LocalDate dateFrom, LocalDate dateTo);

    int size();

}
