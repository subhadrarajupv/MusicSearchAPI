### Choices and decisions you made ###
Technical stack used/implemented:
* Maven
* JDK 8
* Spring Boot 2
* H2 for Embedded DB
* Swagger 2 for API documentation 

* I have implemented API for handling adding/posting of singular/multiple albums at once
	* Singular album posting - `POST /artists/{artistId}/album`
	* Multiple albums posting - `POST /artists/{artistId}/albums`

### Parts you found easy and difficult ###
* Building RESTful web services API has been my regular job for sometime now, and it was easy to implement. By looking at the API that was asked, I was able to visualize how it has to be implemented.
* I haven't implemented Part 2, as I couldn't clearly understand the requirement, couldn't find the API to retrieve album information using a 3rd party service, using Discogs Music API.
* Haven't implemented Metrics and Reactive, as I haven't worked on those areas yet.

### Parts you skipped and the ones that you implemented extra ###
Below are the API's that I could implement
* REST API
  * `/artists` endpoint to manage Artist data. Required information: artist name
      * `POST /artists` to save a new artist
      * `PUT /artists/{artistId}` to update an existing artist
      * `GET /artists` lists all artists. Implement:
        * filtering by a part of artist name
        * sorting by artist name (asc/desc)
        * paging
  * `/artists/{artistId}/albums` endpoint to manage Album data. Required information: title, year of release, genres (list of tags).
      * `POST /artists/{artistId}/albums` to add a new album to an existing artist
      * `PUT /artists/{artistId}/albums/{albumId}` to update an existing album
      * `GET /artists/{artistId}/albums` lists all albums by the given artist. Implement:
        * filtering by genre(s)
        * sorting by album name and release year (asc/desc)
* Data persistence (embedded DB of your choice)
* Tests should be an integral part of your solution


Below points are pending for the implementation (due to time constraints and I got occupied with my day-to-day work).
#### Album details ####
Once you have successfully implemented the above API, extend it with an endpoint to retrieve more details about an individual album using a 3rd party service.
Implement a `GET /artists/{artistId}/albums/{albumId}` endpoint where you return the album information from your system together with a track listing taken from [Discogs API][dc-api].

* Create an Discogs account and set up a new application [link][1]
* Authenticate using Consumer key/secret [link][2]
* Find the album by Artist name and Album name (if more than one is found, you can use the one of your choice; hint: search for master releases only) [link][3]
* Get the track listing using the `resource_url` of the found album and expose it in your API (track number and title); If there are no matches, produce an empty listing

#### Extra requirements ####
Implement (a choice of) these only if you have time left or if you fancy an extra challenge

* Expose metrics:
    * Number of calls per endpoint
    * Average processing time per endpoint
    * Time taken to call Discogs
* Reactive implementation
* Dockerize your application
