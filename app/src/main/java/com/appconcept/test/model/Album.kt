package com.appconcept.test.model

data class Album(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
fun Album.toDatabaseModel(): com.appconcept.test.database.Album {
    return com.appconcept.test.database.Album(
        id = this.id,
        albumId = this.albumId,
        title = this.title,
        url = this.url,
        thumbnailUrl = this.thumbnailUrl
    )
}
fun com.appconcept.test.database.Album.toDomainModel(): Album {
    return Album(
        id = this.id,
        albumId = this.albumId,
        title = this.title,
        url = this.url,
        thumbnailUrl = this.thumbnailUrl
    )
}