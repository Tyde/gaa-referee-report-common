package eu.gaelicgames.referee.data.api

import ExtractedPlayer
import kotlinx.serialization.Serializable

@Serializable
data class PlayerDEO(
    val name: String,
    val jerseyNumber: Int? = null,
    val playerNumber: Long?
)
@Serializable
data class TeamsheetUploadSuccessDEO(
    val players: List<PlayerDEO>,
    val fileKey: String
) {
    companion object {}
}

sealed interface TeamsheetFailure {
    @Serializable
    data class ExtractionFailedButUploadedDEO(
        val fileKey: String
    ) : TeamsheetFailure {
        companion object {}
    }

    @Serializable
    class TeamsheetStorageFailedDEO() : TeamsheetFailure{
        companion object {}
    }
}



@Serializable
data class TeamsheetWithClubAndTournamentDataDEO(
    val players: List<PlayerDEO>,
    val clubId: Long,
    val tournamentId: Long,
    val fileKey: String,
    val registrarMail: String,
    val registrarName: String,
    val codeId: Long
)

@Serializable
data class TeamsheetFileKeyDEO(
    val fileKey: String
) {
    companion object {}
}

