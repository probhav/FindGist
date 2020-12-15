package com.jldubz.gistaviewer.model.data;

import com.jldubz.gistaviewer.model.GitHubUser;
import com.jldubz.gistaviewer.model.gists.Gist;
import com.jldubz.gistaviewer.model.gists.GistComment;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IGitHubService {

    @GET("/gists/public") //https://api.github.com/gists/public?page=1
    Call<List<Gist>> getPublicGists(@Query("page") int pageNum);

    @GET("/gists")
    Call<List<Gist>> getYourGists(@Query("page") int pageNum);

    @GET("/gists/starred")
    Call<List<Gist>> getStarredGists(@Query("page") int pageNum);

    //api.github.com/gists/gistID
    @GET("/gists/{gistId}")
    Call<Gist> getGistById(@Path("gistId") String gistId);

    @GET("/gists/{gistId}/comments")
    Call<List<GistComment>> getGistCommentsById(@Path("gistId") String gistId, @Query("page") int pageNum);

    @HEAD("/gists/{gistId}/comments")
    Call<Void> getGistCommentHeadersById(@Path("gistId") String gistId);

    ///user

    @GET("/user")
    Call<GitHubUser> getLoggedInUser();

    @GET("/gists/{gistId}/star")
    Call<ResponseBody> getGistStarById(@Path("gistId") String gistId);

    @PUT("/gists/{gistId}/star")
    Call<ResponseBody> starGistById(@Path("gistId") String gistId);

    @DELETE("/gists/{gistId}/star")
    Call<ResponseBody> unstarGistById(@Path("gistId") String gistId);

    @POST("/gists/{gistId}/comments")
    Call<GistComment> createCommentOnGist(@Path("gistId") String gistId, @Body GistComment comment);
}
