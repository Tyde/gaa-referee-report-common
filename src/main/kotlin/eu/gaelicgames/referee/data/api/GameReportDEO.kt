package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime


@Serializable
data class GameReportDEO(
    val id: Long? = null,
    val report: Long? = null,
    val teamA: Long? = null,
    val teamB: Long? = null,
    val teamAGoals: Int? = null,
    val teamBGoals: Int? = null,
    val teamAPoints: Int? = null,
    val teamBPoints: Int? = null,
    @Serializable(with = LocalDateTimeSerializer::class)
    val startTime: LocalDateTime? = null,
    val gameType: Long? = null,
    val extraTime: Long? = null,
    val umpirePresentOnTime: Boolean? = null,
    val umpireNotes: String? = null,
    val generalNotes: String? = null,
)
@Serializable
data class DeleteGameReportDEO(
    val id: Long? = null
)
@Serializable
data class GameReportClassesDEO(
    val extraTimeOptions: List<ExtraTimeOptionDEO>,
    val gameTypes: List<GameTypeDEO>,
)
@Serializable
data class ExtraTimeOptionDEO(
    val id: Long,
    val name: String
)


@Serializable
data class DisciplinaryActionDEO(
    val id: Long? = null,
    val team: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val number: Int? = null,
    val details: String? = null,
    val rule: Long? = null,
    val game: Long? = null,
    val redCardIssued: Boolean? = null
)


data class DisciplinaryActionStringDEO(
    val id: Long,
    val teamName: String,
    val opposingTeamName: String,
    val firstName: String,
    val lastName: String,
    val number: Int,
    val details: String,
    val ruleName: String,
    val tournamentName: String,
    val tournamentLocation: String,
    val tournamentDateTime: LocalDateTime,
    val reportShareLink: String,
    val redCardIssued: Boolean
) {
    companion object {



    }
}
@Serializable
data class DeleteDisciplinaryActionDEO(
    val id: Long
)
@Serializable
data class InjuryDEO(
    val id: Long? = null,
    val team: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val details: String? = null,
    val game: Long? = null,
)
@Serializable
data class DeleteInjuryDEO(
    val id:Long
)

@Serializable
data class GameTypeDEO(
    val id: Long? = null,
    val name: String,
)
@Serializable
data class CompleteGameReportDEO(
    val gameReport: GameReportDEO,
    val injuries: List<InjuryDEO>,
    val disciplinaryActions: List<DisciplinaryActionDEO>
)

@Serializable
data class CompleteGameReportWithRefereeReportDEO(
    val gameReport: CompleteGameReportDEO,
    val refereeReport: CompactTournamentReportDEO
)
@Serializable
data class PublicDisciplinaryActionDEO(
    val id: Long? = null,
    val team: Long? = null,
    val rule: Long? = null,
    val game: Long? = null,
)
@Serializable
data class PublicGameReportDEO(
    val gameReport: GameReportDEO,
    val disciplinaryActions: List<PublicDisciplinaryActionDEO>,
    val code: Long,
)
