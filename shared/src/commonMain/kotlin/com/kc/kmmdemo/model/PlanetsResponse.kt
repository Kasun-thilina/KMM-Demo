import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetsResponse(
    @SerialName("count") var count: Int? = null,
    @SerialName("next") var next: String? = null,
    @SerialName("previous") var previous: String? = null,
    @SerialName("results") var results: List<Planet>? = null,
)