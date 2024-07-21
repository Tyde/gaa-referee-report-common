package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.LocalDateSerializer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * gender	"mens"
 * type	"results"
 * cluborcounty	"county"
 * unique_id	"2835979"
 * date	"2024-07-19"
 * date_range	""
 * time	"6 45 PM"
 * timestamp	1721411100
 * competition_name	"Begley's Sports ACL Reserve Division 2"
 * competition_short_name	"Div 2 Res"
 * competition_id	"215637"
 * comp_style	"football"
 * comp_level	"intermediate"
 * comp_type	"league"
 * round_name	"7"
 * club_1_name	"Moy Tír na nÓg"
 * club_1_id	"1784"
 * club_2_name	"Aghyaran"
 * club_2_id	"1079"
 * team_1_goals	"0"
 * team_1_points	"0"
 * team_2_goals	"0"
 * team_2_points	"0"
 * venue_name	"Moy GAC"
 * venue_id	"163"
 * referee_surname	""
 * referee_forename	"TBC"
 * referee_county	""
 * result	"true"
 * postponed	"false"
 * replay	"false"
 * sponsor	"Begley Sports"
 * parent_competition_name	"Div 2 Reserve "
 * team_1_conceded	"true"
 * team_2_conceded	"false"
 * abandoned	"false"
 * never_played	"false"
 *
 */
@Serializable
data class ClubAndCountyResultDEO(
    val gender: String,
    val type: String,
    @SerialName("cluborcounty") val clubOrCounty: String,
    @SerialName("unique_id") val uniqueId: String,
    @Serializable(with = LocalDateSerializer::class) val date: LocalDate,
    //@Serializable(with = DateRangeSerializer::class) val date_range: Pair<LocalDate,LocalDate>? null,
    val date_range: String,
    @Serializable(with = ClubAndCountyLocalTimeSerializer::class) val time: LocalTime,
    val timestamp: Long,
    @SerialName("competition_name") val competitionName: String,
    @SerialName("competition_short_name") val competitionShortName: String,
    @SerialName("competition_id") val competitionId: String,
    @SerialName("comp_style") val competitionStyle: String, //Meaning code
    @SerialName("comp_level") val competitionLevel: String,
    @SerialName("comp_type") val competitionType: String,
    @SerialName("round_name") val roundName: String,
    @SerialName("club_1_name") val club1Name: String,
    @SerialName("club_1_id") val club1Id: String,
    @SerialName("club_2_name") val club2Name: String,
    @SerialName("club_2_id") val club2Id: String,
    @SerialName("team_1_goals") val team1Goals: String,
    @SerialName("team_1_points") val team1Points: String,
    @SerialName("team_2_goals") val team2Goals: String,
    @SerialName("team_2_points") val team2Points: String,
    @SerialName("venue_name") val venueName: String,
    @SerialName("venue_id") val venueId: String,
    @SerialName("referee_surname") val refereeSurname: String,
    @SerialName("referee_forename") val refereeForename: String,
    @SerialName("referee_county") val refereeCounty: String,
    @Serializable(with = ClubandCountyBooleanSerializer::class) val result: Boolean,
    @Serializable(with = ClubandCountyBooleanSerializer::class) val postponed: Boolean,
    @Serializable(with = ClubandCountyBooleanSerializer::class) val replay: Boolean,
    val sponsor: String,
    @SerialName("parent_competition_name") val parentCompetitionName: String,
    @Serializable(with = ClubandCountyBooleanSerializer::class) @SerialName("team_1_conceded") val team1Conceded: Boolean,
    @Serializable(with = ClubandCountyBooleanSerializer::class) @SerialName("team_2_conceded") val team2Conceded: Boolean,
    @Serializable(with = ClubandCountyBooleanSerializer::class) val abandoned: Boolean,
    @Serializable(with = ClubandCountyBooleanSerializer::class) @SerialName("never_played") val neverPlayed: Boolean,
    val owner: String


    ) {
    companion object {
    }
}




@Serializable
data class ClubAndCountyApi(
    val results: Map<String,List<ClubAndCountyResultDEO>>,
    val fixtures: List<Unit>
){
    companion object {
    }
}

class ClubAndCountyLocalTimeSerializer : KSerializer<LocalTime> {
    override fun deserialize(decoder: Decoder): LocalTime {
        return LocalTime.parse(decoder.decodeString())
    }

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalTime) {
        encoder.encodeString(DateTimeFormatter.ISO_TIME.format(value))
    }

}

class ClubandCountyBooleanSerializer: KSerializer<Boolean> {
    override fun deserialize(decoder: Decoder): Boolean {
        return decoder.decodeString() == "true"
    }

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("CaCBoolean", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Boolean) {
        encoder.encodeString(if(value) "true" else "false")
    }
}
